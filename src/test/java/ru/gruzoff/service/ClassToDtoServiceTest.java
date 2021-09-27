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

//    @Test
//    public void testConvertAdressToAdressDto() {
//        AdressDto actualConvertAdressToAdressDtoResult = this.classToDtoService.convertAdressToAdressDto(
//                new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f));
//        assertEquals("Country", actualConvertAdressToAdressDtoResult.getCountry());
//        assertEquals("Oxford", actualConvertAdressToAdressDtoResult.getTown());
//        assertEquals("Street", actualConvertAdressToAdressDtoResult.getStreet());
//        assertEquals("House Nomber", actualConvertAdressToAdressDtoResult.getHouseNomber());
//        assertEquals("Extra House Definition", actualConvertAdressToAdressDtoResult.getExtraHouseDefinition());
//    }
//
//    @Test
//    public void testConvertAdressToAdressDto2() {
//        Adress adress = mock(Adress.class);
//        when(adress.getExtraHouseDefinition()).thenReturn("foo");
//        when(adress.getHouseNomber()).thenReturn("foo");
//        when(adress.getStreet()).thenReturn("foo");
//        when(adress.getTown()).thenReturn("foo");
//        when(adress.getCountry()).thenReturn("foo");
//        AdressDto actualConvertAdressToAdressDtoResult = this.classToDtoService.convertAdressToAdressDto(adress);
//        assertEquals("foo", actualConvertAdressToAdressDtoResult.getCountry());
//        assertEquals("foo", actualConvertAdressToAdressDtoResult.getTown());
//        assertEquals("foo", actualConvertAdressToAdressDtoResult.getStreet());
//        assertEquals("foo", actualConvertAdressToAdressDtoResult.getHouseNomber());
//        assertEquals("foo", actualConvertAdressToAdressDtoResult.getExtraHouseDefinition());
//        verify(adress).getHouseNomber();
//        verify(adress).getTown();
//        verify(adress).getStreet();
//        verify(adress).getExtraHouseDefinition();
//        verify(adress).getCountry();
//    }
//
//    @Test
//    public void testConvertOrderDetailsToOrderDetailsDto() {
//        Adress adress = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);
//        adress.setLatitude(10.0f);
//        adress.setExtraHouseDefinition("Extra House Definition");
//        adress.setCountry("Country");
//        adress.setLongitude(10.0f);
//        adress.setId(123L);
//        adress.setHouseNomber("House Nomber");
//        adress.setTown("Oxford");
//        adress.setStreet("Street");
//
//        Adress adress1 = new Adress();
//        adress1.setLatitude(10.0f);
//        adress1.setExtraHouseDefinition("Extra House Definition");
//        adress1.setCountry("Country");
//        adress1.setLongitude(10.0f);
//        adress1.setId(123L);
//        adress1.setHouseNomber("House Nomber");
//        adress1.setTown("Oxford");
//        adress1.setStreet("Street");
//
//        OrderDetails orderDetails = new OrderDetails();
//        orderDetails.setAdressTo(adress1);
//        orderDetails.setAdressFrom(adress);
//        OrderDetailsDto actualConvertOrderDetailsToOrderDetailsDtoResult = this.classToDtoService
//                .convertOrderDetailsToOrderDetailsDto(orderDetails);
//        assertEquals(
//                "OrderDetailsDto(adressFrom=AdressDto(country=Country, town=Oxford, street=Street, houseNomber=House"
//                        + " Nomber, extraHouseDefinition=Extra House Definition), adressTo=AdressDto(country=Country, town=Oxford,"
//                        + " street=Street, houseNomber=House Nomber, extraHouseDefinition=Extra House Definition), dateTime=null,"
//                        + " timeOnOrder=0.0, loadersCapacity=0, comment=null)",
//                actualConvertOrderDetailsToOrderDetailsDtoResult.toString());
//        assertNull(actualConvertOrderDetailsToOrderDetailsDtoResult.getDateTime());
//        assertEquals(0, actualConvertOrderDetailsToOrderDetailsDtoResult.getLoadersCapacity());
//        assertNull(actualConvertOrderDetailsToOrderDetailsDtoResult.getComment());
//        assertEquals(0.0f, actualConvertOrderDetailsToOrderDetailsDtoResult.getTimeOnOrder());
//        AdressDto adressTo = actualConvertOrderDetailsToOrderDetailsDtoResult.getAdressTo();
//        assertEquals("House Nomber", adressTo.getHouseNomber());
//        assertEquals("Extra House Definition", adressTo.getExtraHouseDefinition());
//        assertEquals("Country", adressTo.getCountry());
//        AdressDto adressFrom = actualConvertOrderDetailsToOrderDetailsDtoResult.getAdressFrom();
//        assertEquals("Street", adressFrom.getStreet());
//        assertEquals("House Nomber", adressFrom.getHouseNomber());
//        assertEquals("Extra House Definition", adressFrom.getExtraHouseDefinition());
//        assertEquals("Country", adressFrom.getCountry());
//        assertEquals("Oxford", adressTo.getTown());
//        assertEquals("Oxford", adressFrom.getTown());
//        assertEquals("Street", adressTo.getStreet());
//    }
//
//    @Test
//    public void testConvertCarToCarDto() {
//        CarType carType = new CarType();
//        carType.setPricePerHour(10.0f);
//        carType.setId(123L);
//        carType.setDescription("The characteristics of someone or something");
//
//        Car car = new Car();
//        car.setType(carType);
//        CarDto actualConvertCarToCarDtoResult = this.classToDtoService.convertCarToCarDto(car);
//        assertNull(actualConvertCarToCarDtoResult.getGosNomber());
//        assertEquals(0, actualConvertCarToCarDtoResult.getWidth());
//        assertEquals(123, actualConvertCarToCarDtoResult.getType());
//        assertEquals(0, actualConvertCarToCarDtoResult.getSize());
//        assertEquals(0, actualConvertCarToCarDtoResult.getMax_weight());
//        assertEquals(0, actualConvertCarToCarDtoResult.getMaxPeopleCapacity());
//        assertEquals(0, actualConvertCarToCarDtoResult.getLength());
//        assertEquals(0, actualConvertCarToCarDtoResult.getHeight());
//    }
//
//    @Test
//    public void testConvertCarToCarDto2() {
//        assertNull(this.classToDtoService.convertCarToCarDto(null));
//    }
//
//    @Test
//    public void testConvertCarToCarDto3() {
//        CarType carType = new CarType();
//        carType.setPricePerHour(10.0f);
//        carType.setId(123L);
//        carType.setDescription("The characteristics of someone or something");
//        Car car = mock(Car.class);
//        when(car.getGosNomber()).thenReturn("foo");
//        when(car.getType()).thenReturn(carType);
//        when(car.getMaxPeopleCapacity()).thenReturn(1);
//        when(car.getSize()).thenReturn(1);
//        when(car.getHeight()).thenReturn(1);
//        when(car.getWidth()).thenReturn(1);
//        when(car.getLength()).thenReturn(1);
//        when(car.getMax_weight()).thenReturn(3);
//        CarDto actualConvertCarToCarDtoResult = this.classToDtoService.convertCarToCarDto(car);
//        assertEquals("foo", actualConvertCarToCarDtoResult.getGosNomber());
//        assertEquals(1, actualConvertCarToCarDtoResult.getWidth());
//        assertEquals(123, actualConvertCarToCarDtoResult.getType());
//        assertEquals(1, actualConvertCarToCarDtoResult.getSize());
//        assertEquals(3, actualConvertCarToCarDtoResult.getMax_weight());
//        assertEquals(1, actualConvertCarToCarDtoResult.getMaxPeopleCapacity());
//        assertEquals(1, actualConvertCarToCarDtoResult.getLength());
//        assertEquals(1, actualConvertCarToCarDtoResult.getHeight());
//        verify(car).getLength();
//        verify(car).getMax_weight();
//        verify(car).getWidth();
//        verify(car).getMaxPeopleCapacity();
//        verify(car).getHeight();
//        verify(car).getSize();
//        verify(car).getType();
//        verify(car).getGosNomber();
//    }
//
//    @Test
//    public void testConvertUserToUserPublicDto() {
//        UserPublicDto actualConvertUserToUserPublicDtoResult = this.classToDtoService
//                .convertUserToUserPublicDto(new User(123L, "janedoe"));
//        assertNull(actualConvertUserToUserPublicDtoResult.getEmail());
//        assertEquals("janedoe", actualConvertUserToUserPublicDtoResult.getUsername());
//        assertNull(actualConvertUserToUserPublicDtoResult.getSecondName());
//        assertNull(actualConvertUserToUserPublicDtoResult.getPhoneNumber());
//        assertNull(actualConvertUserToUserPublicDtoResult.getLastName());
//        assertEquals(123L, actualConvertUserToUserPublicDtoResult.getId());
//        assertNull(actualConvertUserToUserPublicDtoResult.getFirstName());
//    }
//
//    @Test
//    public void testConvertUserToUserPublicDto2() {
//        User user = mock(User.class);
//        when(user.getPhoneNumber()).thenReturn("foo");
//        when(user.getEmail()).thenReturn("foo");
//        when(user.getUsername()).thenReturn("foo");
//        when(user.getLastName()).thenReturn("foo");
//        when(user.getSecondName()).thenReturn("foo");
//        when(user.getFirstName()).thenReturn("foo");
//        UserPublicDto actualConvertUserToUserPublicDtoResult = this.classToDtoService.convertUserToUserPublicDto(user);
//        assertEquals("foo", actualConvertUserToUserPublicDtoResult.getEmail());
//        assertEquals("foo", actualConvertUserToUserPublicDtoResult.getUsername());
//        assertEquals("foo", actualConvertUserToUserPublicDtoResult.getSecondName());
//        assertEquals("foo", actualConvertUserToUserPublicDtoResult.getPhoneNumber());
//        assertEquals("foo", actualConvertUserToUserPublicDtoResult.getLastName());
//        assertEquals(0L, actualConvertUserToUserPublicDtoResult.getId());
//        assertEquals("foo", actualConvertUserToUserPublicDtoResult.getFirstName());
//        verify(user).getSecondName();
//        verify(user).getUsername();
//        verify(user).getFirstName();
//        verify(user).getLastName();
//        verify(user).getPhoneNumber();
//        verify(user).getEmail();
//    }
//
//    @Test
//    public void testConvertCarTypeToCarTypeDto() {
//        CarTypeDto actualConvertCarTypeToCarTypeDtoResult = this.classToDtoService
//                .convertCarTypeToCarTypeDto(new CarType(10.0f, "The characteristics of someone or something"));
//        assertEquals("The characteristics of someone or something",
//                actualConvertCarTypeToCarTypeDtoResult.getDescription());
//        assertEquals(10.0f, actualConvertCarTypeToCarTypeDtoResult.getPricePerHour());
//        assertEquals(0L, actualConvertCarTypeToCarTypeDtoResult.getId());
//    }
//
//    @Test
//    public void testConvertCarTypeToCarTypeDto2() {
//        CarType carType = mock(CarType.class);
//        when(carType.getDescription()).thenReturn("foo");
//        when(carType.getPricePerHour()).thenReturn(10.0f);
//        CarTypeDto actualConvertCarTypeToCarTypeDtoResult = this.classToDtoService.convertCarTypeToCarTypeDto(carType);
//        assertEquals("foo", actualConvertCarTypeToCarTypeDtoResult.getDescription());
//        assertEquals(10.0f, actualConvertCarTypeToCarTypeDtoResult.getPricePerHour());
//        assertEquals(0L, actualConvertCarTypeToCarTypeDtoResult.getId());
//        verify(carType).getPricePerHour();
//        verify(carType).getDescription();
//    }
//
//    @Test
//    public void testConvertCarValidityToCarValidityDto() {
//        CarValidityDto actualConvertCarValidityToCarValidityDtoResult = this.classToDtoService
//                .convertCarValidityToCarValidityDto(new CarValidity());
//        assertNull(actualConvertCarValidityToCarValidityDtoResult.getReasonOfCrash());
//        assertFalse(actualConvertCarValidityToCarValidityDtoResult.isValid());
//    }
//
//    @Test
//    public void testConvertCarValidityToCarValidityDto2() {
//        CarValidityDto actualConvertCarValidityToCarValidityDtoResult = this.classToDtoService
//                .convertCarValidityToCarValidityDto(new CarValidity(true, "Just cause", new Car()));
//        assertEquals("Just cause", actualConvertCarValidityToCarValidityDtoResult.getReasonOfCrash());
//        assertTrue(actualConvertCarValidityToCarValidityDtoResult.isValid());
//    }
//
//    @Test
//    public void testConvertCarValidityToCarValidityDto3() {
//        CarValidity carValidity = mock(CarValidity.class);
//        when(carValidity.getReasonOfCrash()).thenReturn("foo");
//        when(carValidity.isValid()).thenReturn(true);
//        CarValidityDto actualConvertCarValidityToCarValidityDtoResult = this.classToDtoService
//                .convertCarValidityToCarValidityDto(carValidity);
//        assertEquals("foo", actualConvertCarValidityToCarValidityDtoResult.getReasonOfCrash());
//        assertTrue(actualConvertCarValidityToCarValidityDtoResult.isValid());
//        verify(carValidity).isValid();
//        verify(carValidity).getReasonOfCrash();
//    }
//
//    @Test
//    public void testConvertCarToCarWithCarValidDto() {
//        CarType carType = new CarType();
//        carType.setPricePerHour(10.0f);
//        carType.setId(123L);
//        carType.setDescription("The characteristics of someone or something");
//
//        Car car = new Car();
//        car.setType(carType);
//        CarWithCarValidDto actualConvertCarToCarWithCarValidDtoResult = this.classToDtoService
//                .convertCarToCarWithCarValidDto(car, new CarValidity());
//        assertNull(actualConvertCarToCarWithCarValidDtoResult.getGosNomber());
//        assertEquals(
//                "CarWithCarValidDto(max_weight=0, length=0, width=0, height=0, size=0, maxPeopleCapacity=0, type"
//                        + "=CarTypeDto(id=123, pricePerHour=10.0, description=The characteristics of someone or something),"
//                        + " gosNomber=null, validity=CarValidityDto(isValid=false, reasonOfCrash=null))",
//                actualConvertCarToCarWithCarValidDtoResult.toString());
//        assertEquals(0, actualConvertCarToCarWithCarValidDtoResult.getWidth());
//        assertEquals(0, actualConvertCarToCarWithCarValidDtoResult.getHeight());
//        assertEquals(0, actualConvertCarToCarWithCarValidDtoResult.getMaxPeopleCapacity());
//        assertEquals(0, actualConvertCarToCarWithCarValidDtoResult.getMax_weight());
//        assertEquals(0, actualConvertCarToCarWithCarValidDtoResult.getLength());
//        assertEquals(0, actualConvertCarToCarWithCarValidDtoResult.getSize());
//        CarValidityDto validity = actualConvertCarToCarWithCarValidDtoResult.getValidity();
//        assertFalse(validity.isValid());
//        assertNull(validity.getReasonOfCrash());
//        CarTypeDto type = actualConvertCarToCarWithCarValidDtoResult.getType();
//        assertEquals(123L, type.getId());
//        assertEquals("The characteristics of someone or something", type.getDescription());
//        assertEquals(10.0f, type.getPricePerHour());
//    }
//
//    @Test
//    public void testConvertCarToCarWithCarValidDto2() {
//        CarType carType = new CarType();
//        carType.setPricePerHour(10.0f);
//        carType.setId(123L);
//        carType.setDescription("The characteristics of someone or something");
//        Car car = mock(Car.class);
//        when(car.getGosNomber()).thenReturn("foo");
//        when(car.getType()).thenReturn(carType);
//        when(car.getMaxPeopleCapacity()).thenReturn(1);
//        when(car.getSize()).thenReturn(1);
//        when(car.getHeight()).thenReturn(1);
//        when(car.getWidth()).thenReturn(1);
//        when(car.getLength()).thenReturn(1);
//        when(car.getMax_weight()).thenReturn(3);
//        CarWithCarValidDto actualConvertCarToCarWithCarValidDtoResult = this.classToDtoService
//                .convertCarToCarWithCarValidDto(car, new CarValidity());
//        assertEquals("foo", actualConvertCarToCarWithCarValidDtoResult.getGosNomber());
//        assertEquals(
//                "CarWithCarValidDto(max_weight=3, length=1, width=1, height=1, size=1, maxPeopleCapacity=1, type"
//                        + "=CarTypeDto(id=123, pricePerHour=10.0, description=The characteristics of someone or something),"
//                        + " gosNomber=foo, validity=CarValidityDto(isValid=false, reasonOfCrash=null))",
//                actualConvertCarToCarWithCarValidDtoResult.toString());
//        assertEquals(1, actualConvertCarToCarWithCarValidDtoResult.getWidth());
//        assertEquals(1, actualConvertCarToCarWithCarValidDtoResult.getHeight());
//        assertEquals(1, actualConvertCarToCarWithCarValidDtoResult.getMaxPeopleCapacity());
//        assertEquals(3, actualConvertCarToCarWithCarValidDtoResult.getMax_weight());
//        assertEquals(1, actualConvertCarToCarWithCarValidDtoResult.getLength());
//        assertEquals(1, actualConvertCarToCarWithCarValidDtoResult.getSize());
//        CarValidityDto validity = actualConvertCarToCarWithCarValidDtoResult.getValidity();
//        assertFalse(validity.isValid());
//        assertNull(validity.getReasonOfCrash());
//        CarTypeDto type = actualConvertCarToCarWithCarValidDtoResult.getType();
//        assertEquals(123L, type.getId());
//        assertEquals("The characteristics of someone or something", type.getDescription());
//        assertEquals(10.0f, type.getPricePerHour());
//        verify(car).getLength();
//        verify(car).getMax_weight();
//        verify(car).getWidth();
//        verify(car).getMaxPeopleCapacity();
//        verify(car).getHeight();
//        verify(car).getSize();
//        verify(car).getType();
//        verify(car).getGosNomber();
//    }

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

