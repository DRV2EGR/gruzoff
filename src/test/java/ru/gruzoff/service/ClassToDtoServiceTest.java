package ru.gruzoff.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.gruzoff.dto.AdressDto;
import ru.gruzoff.dto.CarDto;
import ru.gruzoff.dto.CarTypeDto;
import ru.gruzoff.dto.CarValidityDto;
import ru.gruzoff.dto.CarWithCarValidDto;
import ru.gruzoff.dto.OrderDetailsDto;
import ru.gruzoff.dto.UserPublicDto;
import ru.gruzoff.entity.Adress;
import ru.gruzoff.entity.Car;
import ru.gruzoff.entity.CarType;
import ru.gruzoff.entity.CarValidity;
import ru.gruzoff.entity.OrderDetails;
import ru.gruzoff.entity.User;

@ContextConfiguration(classes = {ClassToDtoService.class, UserService.class})
@ExtendWith(SpringExtension.class)
public class ClassToDtoServiceTest {
    @Autowired
    private ClassToDtoService classToDtoService;

    @MockBean
    private UserService userService;


    @Test
    public void testConvertAdressToAdressDto_correct(){
        //String country; String town; String street; String houseNomber; String extraHouseDefinition; float latitude; float longitude;

        Adress adress = new Adress();
        adress.setCountry("c");
        adress.setTown("t");
        adress.setStreet("s");
        adress.setHouseNomber("3");
        adress.setExtraHouseDefinition("76");
        adress.setLatitude(12f);
        adress.setLongitude(45f);

        AdressDto adressDto = new AdressDto();
        adressDto.setCountry("c");
        adressDto.setExtraHouseDefinition("76");
        adressDto.setHouseNomber("3");
        adressDto.setStreet("s");
        adressDto.setTown("t");

        assertEquals(adressDto, this.classToDtoService.convertAdressToAdressDto(adress));
    }

    @Test
    public void testConvertAdressToAdressDto_empty(){
        Adress adress = new Adress();

        AdressDto adressDto = new AdressDto();

        assertEquals(adressDto, this.classToDtoService.convertAdressToAdressDto(adress));
    }

    @Test
    public void testConvertAdressToAdressDto_null(){
        AdressDto adressDto = new AdressDto();

        assertDoesNotThrow(() -> this.classToDtoService.convertAdressToAdressDto(null));
        assertEquals(adressDto, this.classToDtoService.convertAdressToAdressDto(null));
    }

    @Test
    public void testConvertCarToCarDto_correct(){
        //int max_weight; int length; int width; int height; int size; int maxPeopleCapacity; CarType type; String gosNomber;
        Car car = new Car();
        car.setMax_weight(300);
        car.setLength(250);
        car.setWidth(150);
        car.setHeight(200);
        car.setSize(100000);
        car.setMaxPeopleCapacity(5);

        CarType carType = new CarType(); carType.setId(1);

        car.setType(carType);
        car.setGosNomber("666hui");

        CarDto carDto = new CarDto();
        carDto.setGosNomber("666hui");
        carDto.setHeight(200);
        carDto.setLength(250);
        carDto.setWidth(150);
        carDto.setMax_weight(300);
        carDto.setMaxPeopleCapacity(5);
        carDto.setSize(100000);
        carDto.setType(1);

        assertEquals(carDto, this.classToDtoService.convertCarToCarDto(car));
    }

    @Test
    public void testConvertCarToCarDto_empty(){
        Car car = new Car();
        CarType carType = new CarType();
        car.setType(carType);

        CarDto carDto = new CarDto();

        assertEquals(carDto, this.classToDtoService.convertCarToCarDto(car));
    }

    @Test
    public void testConvertCarToCarDto_null(){
        AdressDto adressDto = new AdressDto();

        assertDoesNotThrow(() -> this.classToDtoService.convertCarToCarDto(null));
        assertEquals(adressDto, this.classToDtoService.convertCarToCarDto(null));
    }

}

