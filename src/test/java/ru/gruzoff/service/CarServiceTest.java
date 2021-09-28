package ru.gruzoff.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import ru.gruzoff.dto.CarDto;
import ru.gruzoff.dto.CarTypeDto;
import ru.gruzoff.dto.CarWithCarValidDto;
import ru.gruzoff.entity.*;
import ru.gruzoff.exception.NotFoundException;
import ru.gruzoff.payload.AddNewCarDtoPayload;
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
    public void testAddNewCar_null(){
        Role role = new Role(); role.setName("ROLE_DRIVER");
        User user = new User(); user.setRole(role);
        AddNewCarDtoPayload addNewCarDtoPayload = new AddNewCarDtoPayload();
        addNewCarDtoPayload.setType(1);

        Car car = new Car();

        when(this.carTypeRepository.findById(addNewCarDtoPayload.getType())).thenReturn(Optional.of(new CarType()));

        when(this.carRepository.save(car)).thenReturn(car);

        CarValidity carValidity = new CarValidity();
        carValidity.setValid(true);
        carValidity.setCarId(car);

        when(this.carValidityRepository.save(carValidity)).thenReturn(carValidity);

        Drivers drivers = new Drivers();
        when(this.driversRepository.findByUser(user)).thenReturn(Optional.of(drivers));
        drivers.setCars(new ArrayList<>());

        when(this.driversRepository.save(drivers)).thenReturn(drivers);

        CarDto carDto = new CarDto();

        assertEquals(carDto, this.carService.addNewCar(user, addNewCarDtoPayload));
    }

}

