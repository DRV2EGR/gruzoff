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
     * Add new car car dto.
     *
     * @param user                the user
     * @param addNewCarDtoPayload the add new car dto payload
     * @return the car dto
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
     * Gets all valid cars.
     *
     * @return the all valid cars
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
     * Gets all car types.
     *
     * @return the all car types
     */
    public List<CarTypeDto> getAllCarTypes() {
        List<CarTypeDto> carTypesDtoList = new ArrayList<>();
        for (CarType carType : carTypeRepository.findAll()) {
            carTypesDtoList.add(classToDtoService.convertCarTypeToCarTypeDto(carType));
        }

        return carTypesDtoList;
    }

    /**
     * Disvalid car by id boolean.
     *
     * @param carId the car id
     * @return the boolean
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
     * Gets all cars.
     *
     * @return the all cars
     */
    public List<CarWithCarValidDto> getAllCars() {
        List<CarWithCarValidDto> carDtoList = new ArrayList<>();
        for (Car car : carRepository.findAll()) {
            carDtoList.add(classToDtoService.convertCarToCarWithCarValidDto(car, carValidityRepository.findByCarId(car).get()));
        }

        return carDtoList;
    }

    /**
     * Change car valid.
     *
     * @param carId  the car id
     * @param v      the v
     * @param reason the reason
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
