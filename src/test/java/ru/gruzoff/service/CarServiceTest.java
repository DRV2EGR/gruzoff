package ru.gruzoff.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.gruzoff.dto.CarDto;
import ru.gruzoff.dto.CarTypeDto;
import ru.gruzoff.dto.CarWithCarValidDto;
import ru.gruzoff.entity.Car;
import ru.gruzoff.entity.CarType;
import ru.gruzoff.entity.CarValidity;
import ru.gruzoff.exception.NotFoundException;
import ru.gruzoff.repository.CarRepository;
import ru.gruzoff.repository.CarTypeRepository;
import ru.gruzoff.repository.CarValidityRepository;
import ru.gruzoff.repository.DriversRepository;

@ContextConfiguration(classes = {ClassToDtoService.class, CarService.class})
@ExtendWith(SpringExtension.class)
public class CarServiceTest {
    @MockBean
    private CarRepository carRepository;

    @Autowired
    private CarService carService;

    @MockBean
    private CarTypeRepository carTypeRepository;

    @MockBean
    private CarValidityRepository carValidityRepository;

    @MockBean
    private ClassToDtoService classToDtoService;

    @MockBean
    private DriversRepository driversRepository;

    @Test
    public void testGetAllValidCars() {
        when(this.carRepository.findAll()).thenReturn(new ArrayList<Car>());
        assertTrue(this.carService.getAllValidCars().isEmpty());
        verify(this.carRepository).findAll();
    }

    @Test
    public void testGetAllValidCars2() {
        when(this.classToDtoService.convertCarToCarDto((Car) any()))
                .thenReturn(new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber"));

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(1);

        CarValidity carValidity = new CarValidity();
        carValidity.setReasonOfCrash("Just cause");
        carValidity.setValid(true);
        carValidity.setId(123L);
        carValidity.setCarId(car);
        Optional<CarValidity> ofResult = Optional.<CarValidity>of(carValidity);
        when(this.carValidityRepository.findByCarId((Car) any())).thenReturn(ofResult);

        CarType carType1 = new CarType();
        carType1.setPricePerHour(10.0f);
        carType1.setId(123L);
        carType1.setDescription("The characteristics of someone or something");

        Car car1 = new Car();
        car1.setMaxPeopleCapacity(3);
        car1.setGosNomber("Gos Nomber");
        car1.setType(carType1);
        car1.setId(123L);
        car1.setMax_weight(3);
        car1.setSize(3);
        car1.setWidth(1);
        car1.setLength(3);
        car1.setHeight(0);

        ArrayList<Car> carList = new ArrayList<Car>();
        carList.add(car1);
        when(this.carRepository.findAll()).thenReturn(carList);
        assertEquals(1, this.carService.getAllValidCars().size());
        verify(this.carRepository).findAll();
        verify(this.carValidityRepository).findByCarId((Car) any());
        verify(this.classToDtoService).convertCarToCarDto((Car) any());
    }

    @Test
    public void testGetAllValidCars3() {
        when(this.classToDtoService.convertCarToCarDto((Car) any()))
                .thenReturn(new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber"));

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(1);

        CarValidity carValidity = new CarValidity();
        carValidity.setReasonOfCrash("Just cause");
        carValidity.setValid(false);
        carValidity.setId(123L);
        carValidity.setCarId(car);
        Optional<CarValidity> ofResult = Optional.<CarValidity>of(carValidity);
        when(this.carValidityRepository.findByCarId((Car) any())).thenReturn(ofResult);

        CarType carType1 = new CarType();
        carType1.setPricePerHour(10.0f);
        carType1.setId(123L);
        carType1.setDescription("The characteristics of someone or something");

        Car car1 = new Car();
        car1.setMaxPeopleCapacity(3);
        car1.setGosNomber("Gos Nomber");
        car1.setType(carType1);
        car1.setId(123L);
        car1.setMax_weight(3);
        car1.setSize(3);
        car1.setWidth(1);
        car1.setLength(3);
        car1.setHeight(0);

        ArrayList<Car> carList = new ArrayList<Car>();
        carList.add(car1);
        when(this.carRepository.findAll()).thenReturn(carList);
        assertTrue(this.carService.getAllValidCars().isEmpty());
        verify(this.carRepository).findAll();
        verify(this.carValidityRepository).findByCarId((Car) any());
    }

    @Test
    public void testGetAllValidCars4() {
        when(this.classToDtoService.convertCarToCarDto((Car) any()))
                .thenReturn(new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber"));
        when(this.carValidityRepository.findByCarId((Car) any())).thenReturn(Optional.<CarValidity>empty());

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(0);

        ArrayList<Car> carList = new ArrayList<Car>();
        carList.add(car);
        when(this.carRepository.findAll()).thenReturn(carList);
        assertThrows(NotFoundException.class, () -> this.carService.getAllValidCars());
        verify(this.carRepository).findAll();
        verify(this.carValidityRepository).findByCarId((Car) any());
    }

    @Test
    public void testGetAllCarTypes() {
        when(this.carTypeRepository.findAll()).thenReturn(new ArrayList<CarType>());
        assertTrue(this.carService.getAllCarTypes().isEmpty());
        verify(this.carTypeRepository).findAll();
    }

    @Test
    public void testGetAllCarTypes2() {
        when(this.classToDtoService.convertCarTypeToCarTypeDto((CarType) any()))
                .thenReturn(new CarTypeDto(123L, 10.0f, "The characteristics of someone or something"));

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        ArrayList<CarType> carTypeList = new ArrayList<CarType>();
        carTypeList.add(carType);
        when(this.carTypeRepository.findAll()).thenReturn(carTypeList);
        assertEquals(1, this.carService.getAllCarTypes().size());
        verify(this.carTypeRepository).findAll();
        verify(this.classToDtoService).convertCarTypeToCarTypeDto((CarType) any());
    }

    @Test
    public void testDisvalidCarById() {
        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(1);

        CarValidity carValidity = new CarValidity();
        carValidity.setReasonOfCrash("Just cause");
        carValidity.setValid(true);
        carValidity.setId(123L);
        carValidity.setCarId(car);
        Optional<CarValidity> ofResult = Optional.<CarValidity>of(carValidity);

        CarType carType1 = new CarType();
        carType1.setPricePerHour(10.0f);
        carType1.setId(123L);
        carType1.setDescription("The characteristics of someone or something");

        Car car1 = new Car();
        car1.setMaxPeopleCapacity(3);
        car1.setGosNomber("Gos Nomber");
        car1.setType(carType1);
        car1.setId(123L);
        car1.setMax_weight(3);
        car1.setSize(3);
        car1.setWidth(1);
        car1.setLength(3);
        car1.setHeight(1);

        CarValidity carValidity1 = new CarValidity();
        carValidity1.setReasonOfCrash("Just cause");
        carValidity1.setValid(true);
        carValidity1.setId(123L);
        carValidity1.setCarId(car1);
        when(this.carValidityRepository.save((CarValidity) any())).thenReturn(carValidity1);
        when(this.carValidityRepository.findByCarId((Car) any())).thenReturn(ofResult);

        CarType carType2 = new CarType();
        carType2.setPricePerHour(10.0f);
        carType2.setId(123L);
        carType2.setDescription("The characteristics of someone or something");

        Car car2 = new Car();
        car2.setMaxPeopleCapacity(3);
        car2.setGosNomber("Gos Nomber");
        car2.setType(carType2);
        car2.setId(123L);
        car2.setMax_weight(3);
        car2.setSize(3);
        car2.setWidth(1);
        car2.setLength(3);
        car2.setHeight(1);
        Optional<Car> ofResult1 = Optional.<Car>of(car2);
        when(this.carRepository.findById((Long) any())).thenReturn(ofResult1);
        assertTrue(this.carService.disvalidCarById(123L));
        verify(this.carRepository).findById((Long) any());
        verify(this.carValidityRepository).findByCarId((Car) any());
        verify(this.carValidityRepository).save((CarValidity) any());
    }

    @Test
    public void testDisvalidCarById2() {
        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(1);

        CarValidity carValidity = new CarValidity();
        carValidity.setReasonOfCrash("Just cause");
        carValidity.setValid(false);
        carValidity.setId(123L);
        carValidity.setCarId(car);
        Optional<CarValidity> ofResult = Optional.<CarValidity>of(carValidity);
        when(this.carValidityRepository.save((CarValidity) any())).thenThrow(new NotFoundException("An error occurred"));
        when(this.carValidityRepository.findByCarId((Car) any())).thenReturn(ofResult);

        CarType carType1 = new CarType();
        carType1.setPricePerHour(10.0f);
        carType1.setId(123L);
        carType1.setDescription("The characteristics of someone or something");

        Car car1 = new Car();
        car1.setMaxPeopleCapacity(3);
        car1.setGosNomber("Gos Nomber");
        car1.setType(carType1);
        car1.setId(123L);
        car1.setMax_weight(3);
        car1.setSize(3);
        car1.setWidth(1);
        car1.setLength(3);
        car1.setHeight(1);
        Optional<Car> ofResult1 = Optional.<Car>of(car1);
        when(this.carRepository.findById((Long) any())).thenReturn(ofResult1);
        assertFalse(this.carService.disvalidCarById(123L));
        verify(this.carRepository).findById((Long) any());
        verify(this.carValidityRepository).findByCarId((Car) any());
    }

    @Test
    public void testDisvalidCarById3() {
        when(this.carValidityRepository.save((CarValidity) any())).thenThrow(new NotFoundException("An error occurred"));
        when(this.carValidityRepository.findByCarId((Car) any())).thenReturn(Optional.<CarValidity>empty());

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(1);
        Optional<Car> ofResult = Optional.<Car>of(car);
        when(this.carRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(NotFoundException.class, () -> this.carService.disvalidCarById(123L));
        verify(this.carRepository).findById((Long) any());
        verify(this.carValidityRepository).findByCarId((Car) any());
    }

    @Test
    public void testGetAllCars() {
        when(this.carRepository.findAll()).thenReturn(new ArrayList<Car>());
        assertTrue(this.carService.getAllCars().isEmpty());
        verify(this.carRepository).findAll();
    }

    @Test
    public void testGetAllCars2() {
        when(this.classToDtoService.convertCarToCarWithCarValidDto((Car) any(), (CarValidity) any()))
                .thenReturn(new CarWithCarValidDto());

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(1);

        CarValidity carValidity = new CarValidity();
        carValidity.setReasonOfCrash("Just cause");
        carValidity.setValid(true);
        carValidity.setId(123L);
        carValidity.setCarId(car);
        Optional<CarValidity> ofResult = Optional.<CarValidity>of(carValidity);
        when(this.carValidityRepository.findByCarId((Car) any())).thenReturn(ofResult);

        CarType carType1 = new CarType();
        carType1.setPricePerHour(10.0f);
        carType1.setId(123L);
        carType1.setDescription("The characteristics of someone or something");

        Car car1 = new Car();
        car1.setMaxPeopleCapacity(3);
        car1.setGosNomber("Gos Nomber");
        car1.setType(carType1);
        car1.setId(123L);
        car1.setMax_weight(3);
        car1.setSize(3);
        car1.setWidth(1);
        car1.setLength(3);
        car1.setHeight(0);

        ArrayList<Car> carList = new ArrayList<Car>();
        carList.add(car1);
        when(this.carRepository.findAll()).thenReturn(carList);
        assertEquals(1, this.carService.getAllCars().size());
        verify(this.carRepository).findAll();
        verify(this.carValidityRepository).findByCarId((Car) any());
        verify(this.classToDtoService).convertCarToCarWithCarValidDto((Car) any(), (CarValidity) any());
    }

    @Test
    public void testGetAllCars3() {
        when(this.classToDtoService.convertCarToCarWithCarValidDto((Car) any(), (CarValidity) any()))
                .thenReturn(new CarWithCarValidDto());
        when(this.carValidityRepository.findByCarId((Car) any())).thenReturn(Optional.<CarValidity>empty());

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(0);

        ArrayList<Car> carList = new ArrayList<Car>();
        carList.add(car);
        when(this.carRepository.findAll()).thenReturn(carList);
        this.carService.getAllCars();
        verify(this.carRepository).findAll();
        verify(this.carValidityRepository).findByCarId((Car) any());
    }

    @Test
    public void testGetAllCars4() {
        when(this.carRepository.findAll()).thenReturn(new ArrayList<Car>());
        assertTrue(this.carService.getAllCars().isEmpty());
        verify(this.carRepository).findAll();
    }

    @Test
    public void testGetAllCars5() {
        when(this.classToDtoService.convertCarToCarWithCarValidDto((Car) any(), (CarValidity) any()))
                .thenReturn(new CarWithCarValidDto());

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(1);

        CarValidity carValidity = new CarValidity();
        carValidity.setReasonOfCrash("Just cause");
        carValidity.setValid(true);
        carValidity.setId(123L);
        carValidity.setCarId(car);
        Optional<CarValidity> ofResult = Optional.<CarValidity>of(carValidity);
        when(this.carValidityRepository.findByCarId((Car) any())).thenReturn(ofResult);

        CarType carType1 = new CarType();
        carType1.setPricePerHour(10.0f);
        carType1.setId(123L);
        carType1.setDescription("The characteristics of someone or something");

        Car car1 = new Car();
        car1.setMaxPeopleCapacity(3);
        car1.setGosNomber("Gos Nomber");
        car1.setType(carType1);
        car1.setId(123L);
        car1.setMax_weight(3);
        car1.setSize(3);
        car1.setWidth(1);
        car1.setLength(3);
        car1.setHeight(0);

        ArrayList<Car> carList = new ArrayList<Car>();
        carList.add(car1);
        when(this.carRepository.findAll()).thenReturn(carList);
        assertEquals(1, this.carService.getAllCars().size());
        verify(this.carRepository).findAll();
        verify(this.carValidityRepository).findByCarId((Car) any());
        verify(this.classToDtoService).convertCarToCarWithCarValidDto((Car) any(), (CarValidity) any());
    }

    @Test
    public void testGetAllCars6() {
        when(this.classToDtoService.convertCarToCarWithCarValidDto((Car) any(), (CarValidity) any()))
                .thenReturn(new CarWithCarValidDto());
        when(this.carValidityRepository.findByCarId((Car) any())).thenReturn(Optional.<CarValidity>empty());

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(0);

        ArrayList<Car> carList = new ArrayList<Car>();
        carList.add(car);
        when(this.carRepository.findAll()).thenReturn(carList);
        this.carService.getAllCars();
        verify(this.carRepository).findAll();
        verify(this.carValidityRepository).findByCarId((Car) any());
    }

    @Test
    public void testChangeCarValid() {
        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(1);

        CarValidity carValidity = new CarValidity();
        carValidity.setReasonOfCrash("Just cause");
        carValidity.setValid(true);
        carValidity.setId(123L);
        carValidity.setCarId(car);
        Optional<CarValidity> ofResult = Optional.<CarValidity>of(carValidity);

        CarType carType1 = new CarType();
        carType1.setPricePerHour(10.0f);
        carType1.setId(123L);
        carType1.setDescription("The characteristics of someone or something");

        Car car1 = new Car();
        car1.setMaxPeopleCapacity(3);
        car1.setGosNomber("Gos Nomber");
        car1.setType(carType1);
        car1.setId(123L);
        car1.setMax_weight(3);
        car1.setSize(3);
        car1.setWidth(1);
        car1.setLength(3);
        car1.setHeight(1);

        CarValidity carValidity1 = new CarValidity();
        carValidity1.setReasonOfCrash("Just cause");
        carValidity1.setValid(true);
        carValidity1.setId(123L);
        carValidity1.setCarId(car1);
        when(this.carValidityRepository.save((CarValidity) any())).thenReturn(carValidity1);
        when(this.carValidityRepository.findByCarId((Car) any())).thenReturn(ofResult);

        CarType carType2 = new CarType();
        carType2.setPricePerHour(10.0f);
        carType2.setId(123L);
        carType2.setDescription("The characteristics of someone or something");

        Car car2 = new Car();
        car2.setMaxPeopleCapacity(3);
        car2.setGosNomber("Gos Nomber");
        car2.setType(carType2);
        car2.setId(123L);
        car2.setMax_weight(3);
        car2.setSize(3);
        car2.setWidth(1);
        car2.setLength(3);
        car2.setHeight(1);
        Optional<Car> ofResult1 = Optional.<Car>of(car2);
        when(this.carRepository.findById((Long) any())).thenReturn(ofResult1);
        this.carService.changeCarValid(123L, 1, "Just cause");
        verify(this.carRepository).findById((Long) any());
        verify(this.carValidityRepository).findByCarId((Car) any());
        verify(this.carValidityRepository).save((CarValidity) any());
    }

    @Test
    public void testChangeCarValid2() {
        when(this.carValidityRepository.save((CarValidity) any())).thenThrow(new NotFoundException("An error occurred"));
        when(this.carValidityRepository.findByCarId((Car) any())).thenReturn(Optional.<CarValidity>empty());

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(1);
        Optional<Car> ofResult = Optional.<Car>of(car);
        when(this.carRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(NotFoundException.class, () -> this.carService.changeCarValid(123L, 1, "Just cause"));
        verify(this.carRepository).findById((Long) any());
        verify(this.carValidityRepository).findByCarId((Car) any());
    }

    @Test
    public void testChangeCarValid3() {
        when(this.carValidityRepository.save((CarValidity) any())).thenThrow(new NotFoundException("An error occurred"));
        when(this.carValidityRepository.findByCarId((Car) any())).thenReturn(Optional.<CarValidity>empty());
        when(this.carRepository.findById((Long) any())).thenReturn(Optional.<Car>empty());
        assertThrows(NotFoundException.class, () -> this.carService.changeCarValid(123L, 1, "Just cause"));
        verify(this.carRepository).findById((Long) any());
    }
}

