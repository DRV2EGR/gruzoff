package ru.gruzoff.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gruzoff.dto.CarDto;
import ru.gruzoff.dto.CarTypeDto;
import ru.gruzoff.dto.CarWithCarValidDto;
import ru.gruzoff.entity.*;
import ru.gruzoff.exception.NotFoundException;
import ru.gruzoff.exception.UserNotFoundExeption;
import ru.gruzoff.payload.AddNewCarDtoPayload;
import ru.gruzoff.repository.CarRepository;
import ru.gruzoff.repository.CarTypeRepository;
import ru.gruzoff.repository.CarValidityRepository;
import ru.gruzoff.repository.DriversRepository;

/**
 * The type Car service.
 */
@Service
public class CarService {
    /**
     * The Car repository.
     */
    @Autowired
    CarRepository carRepository;

    /**
     * The Car type repository.
     */
    @Autowired
    CarTypeRepository carTypeRepository;

    /**
     * The Drivers repository.
     */
    @Autowired
    DriversRepository driversRepository;

    /**
     * The Car validity repository.
     */
    @Autowired
    CarValidityRepository carValidityRepository;

    /**
     * The Class to dto service.
     */
    @Autowired
    ClassToDtoService classToDtoService;

    /**
     * <h4>Создает новую машину в сервисе.</h4>
     *<br />
     * Если у пользователя роль ROLE_DRIVER, то
     * Создается новая сущность автомобиля
     * с присвоением типа carTypeRepository.findById(addNewCarDtoPayload.getType())
     * затем сохраняется carRepository.save(car)
     * Затем создается запись CarValidity и поставляется
     * данному автомобилю значение isValid true
     * и сохраняется carValidityRepository.save(carValidity);
     * Затем находится водитель driversRepository.findByUser(user)
     * ему добавляется новая машина и сохраняется он driversRepository.save(driver)
     * <br />
     * Иначе, если роль пользователя иная (Будет ROLE_ADMIN)
     * Создается новая сущность автомобиля
     * с присвоением типа carTypeRepository.findById(addNewCarDtoPayload.getType())
     * затем сохраняется carRepository.save(car)
     * Затем создается запись CarValidity и поставляется
     * данному автомобилю значение isValid true
     * и сохраняется carValidityRepository.save(carValidity);
     * Далее, если в addNewCarDtoPayload (входные) указан id
     * водителя > 1, то находится данный водитель
     * driversRepository.findById(addNewCarDtoPayload.getDriverId())
     * и ему присваивается данная машина.
     *  driver.getCars().add(car);
     * driversRepository.save(driver)
     *
     *
     * Если в описании машины не указан водитель, то он не проставляется
     *
     * @param user                Пользователь, который отправил запрос на создание.
     * @param addNewCarDtoPayload описание новой машины в формате <br />
     *                            {
     *                                 long driverId;
     *                                 int max_weight;
     *                                 int length;
     *                                 int width;
     *                                 int height;
     *                                 int size;
     *                                 int maxPeopleCapacity;
     *                                 long type;
     *                                 String gosNomber;
     *                            }
     * @return CarDto редставление машины для пользователя в системе
     */
    public CarDto addNewCar(User user, AddNewCarDtoPayload addNewCarDtoPayload) {
        if (user.getRole().getName().equals("ROLE_DRIVER")) {
            Car car = new Car(
                    addNewCarDtoPayload.getMax_weight(),
                    addNewCarDtoPayload.getLength(),
                    addNewCarDtoPayload.getWidth(),
                    addNewCarDtoPayload.getHeight(),
                    addNewCarDtoPayload.getSize(),
                    addNewCarDtoPayload.getMaxPeopleCapacity(),
                    carTypeRepository.findById(addNewCarDtoPayload.getType()).orElseThrow(
                            () -> new NotFoundException("No such car type")
                    ),
                    addNewCarDtoPayload.getGosNomber()
            );

            carRepository.save(car);

            CarValidity carValidity = new CarValidity(
                    true,
                    null,
                    car
            );
            carValidityRepository.save(carValidity);

            Drivers driver = driversRepository.findByUser(user).orElseThrow(
                    () -> new UserNotFoundExeption("No such driver")
                );
            driver.getCars().add(car);
            driversRepository.save(driver);

            return classToDtoService.convertCarToCarDto(car);
        } else {
            Car car = new Car(
                    addNewCarDtoPayload.getMax_weight(),
                    addNewCarDtoPayload.getLength(),
                    addNewCarDtoPayload.getWidth(),
                    addNewCarDtoPayload.getHeight(),
                    addNewCarDtoPayload.getSize(),
                    addNewCarDtoPayload.getMaxPeopleCapacity(),
                    carTypeRepository.findById(addNewCarDtoPayload.getType()).orElseThrow(
                            () -> new NotFoundException("No such car type")
                    ),
                    addNewCarDtoPayload.getGosNomber()
            );

            carRepository.save(car);

            CarValidity carValidity = new CarValidity(
                    true,
                    null,
                    car
            );
            carValidityRepository.save(carValidity);

            if (addNewCarDtoPayload.getDriverId() >= 1) {
                Drivers driver = driversRepository.findById(addNewCarDtoPayload.getDriverId()).orElseThrow(
                        () -> new UserNotFoundExeption("No such driver")
                );
                driver.getCars().add(car);
                driversRepository.save(driver);
            }

            return classToDtoService.convertCarToCarDto(car);
        }
    }

    /**
     * <h4>Найти все действующие машины в базе</h4>
     * <br />
     * Находятся все машины carRepository.findAll()
     * Затем для каждой машины
     * из найденных проверяется валидность путем
     * поиска по id машины в таблице валидности
     * (carValidityRepository.findByCarId(car))
     *
     * @throws NotFoundException если arRepository.findAll() выдал не существующие id
     *
     * @return List[CarDto] массив машин в виде представлений для пользователя
     */
    public List<CarDto> getAllValidCars() {
        List<CarDto> carDtoList = new ArrayList<>();
        for (Car car : carRepository.findAll()) {
            if (carValidityRepository.findByCarId(car).orElseThrow(
                        () -> new NotFoundException("Not valid car")
                    ).isValid())
            carDtoList.add(classToDtoService.convertCarToCarDto(car));
        }

        return carDtoList;
    }

    /**
     * Получить все типы машин
     * <br />
     * Достаются все типы из базы путем
     * carTypeRepository.findAll()
     *
     * @return List[CarTypeDto] массив машин в виде представлений для пользователя
     */
    public List<CarTypeDto> getAllCarTypes() {
        List<CarTypeDto> carTypesDtoList = new ArrayList<>();
        for (CarType carType : carTypeRepository.findAll()) {
            carTypesDtoList.add(classToDtoService.convertCarTypeToCarTypeDto(carType));
        }

        return carTypesDtoList;
    }

    /**
     * Сделать машину не действующей (отстранить)
     * По причине удаления пользователя
     *
     * @throws NotFoundException если carRepository.findById(carId) получил не существующий id
     * @throws NotFoundException если carValidityRepository.findByCarId() получил не существующий id
     *
     * @param carId id машины, которую следует отстранить
     * @return boolean флаг выполнения действия
     */
    public boolean disvalidCarById(long carId) {
        CarValidity carValidity = carValidityRepository.findByCarId(
                carRepository.findById(carId).orElseThrow(
                        () -> new NotFoundException("No such car")
                )
        ).orElseThrow(
                () -> new NotFoundException("No such car valid")
        );

        if (carValidity.isValid()) {
            carValidity.setValid(false);
            carValidity.setReasonOfCrash("OWNER_DELETED");
            carValidityRepository.save(carValidity);

            return true;
        }

        return false;
    }

    /**
     * Получить все машины
     *
     * @return List[CarWithCarValidDto] массив машин в виде представлений для пользователя
     */
    public List<CarWithCarValidDto> getAllCars() {
        List<CarWithCarValidDto> carDtoList = new ArrayList<>();
        for (Car car : carRepository.findAll()) {
            carDtoList.add(classToDtoService.convertCarToCarWithCarValidDto(car, carValidityRepository.findByCarId(car).get()));
        }

        return carDtoList;
    }

    /**
     * Изменить доступность машины с указанием причины
     *
     * @throws NotFoundException если carRepository.findById(carId) получил не существующий id
     * @throws NotFoundException если carValidityRepository.findByCarId() получил не существующий id
     *
     * @param carId id машины
     * @param v новый статус машины
     * @param reason причина смены статуса
     *
     */
    public void changeCarValid(long carId, int v, String reason) {
        CarValidity carValidity = carValidityRepository.findByCarId(
                carRepository.findById(carId).orElseThrow(
                        () -> new NotFoundException("No such car")
                )
        ).orElseThrow(
                () -> new NotFoundException("No such car valid")
        );

        if (v == 1) {
            carValidity.setValid(true);
        } else {
            carValidity.setValid(false);
        }

        carValidity.setReasonOfCrash(reason);

        carValidityRepository.save(carValidity);
    }
}
