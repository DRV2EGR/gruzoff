package ru.gruzoff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.gruzoff.dto.*;
import ru.gruzoff.entity.User;
import ru.gruzoff.exception.UserNotFoundExeption;
import ru.gruzoff.payload.AddNewCarDtoPayload;
import ru.gruzoff.service.CarService;
import ru.gruzoff.service.UserService;

/**
 * The type Car controller.
 */
@RestController
@RequestMapping(value = "/v1/api/cars", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {
    /**
     * The Car service.
     */
    @Autowired
    CarService carService;

    /**
     * The User service.
     */
    @Autowired
    UserService userService;

    private User getAuthentificatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser = userService.findByUsername(currentUserName).orElseThrow(
                () -> {throw new UserNotFoundExeption("Bad auth");}
        );

        return currentUser;
    }

    /**
     * Add car response entity.
     *
     * @param addNewCarDtoPayload the add new car dto payload
     * @return the response entity
     */
    @PostMapping("/private/add")
    public ResponseEntity<CarDto> addCar(@RequestBody AddNewCarDtoPayload addNewCarDtoPayload) {
        return ResponseEntity.ok(carService.addNewCar(getAuthentificatedUser(), addNewCarDtoPayload));
    }

    /**
     * Gets all cars.
     *
     * @return the all cars
     */
    @GetMapping("/")
    public ResponseEntity<List<CarDto>> getAllCars() {
        return ResponseEntity.ok(carService.getAllValidCars());
    }

    /**
     * Gets all car types.
     *
     * @return the all car types
     */
    @GetMapping("/get_car_types")
    public ResponseEntity<List<CarTypeDto>> getAllCarTypes() {
        return ResponseEntity.ok(carService.getAllCarTypes());
    }

    /**
     * Delete car response entity.
     *
     * @param car_id the car id
     * @return the response entity
     */
    @DeleteMapping("/private/delete_car")
    public ResponseEntity<BasicResponce> deleteCar(@RequestParam long car_id) {
        if (carService.disvalidCarById(car_id)) {
            return ResponseEntity.ok(new ResponseStatusOperationDto("OK"));
        } else {
            return ResponseEntity.ok(new ResponseStatusOperationDto("ERROR"));
        }
    }

    /**
     * Gets all cars info.
     *
     * @return the all cars info
     */
    @GetMapping("/private/all_cars")
    public ResponseEntity<List<CarWithCarValidDto>> getAllCarsInfo() {
        return ResponseEntity.ok(carService.getAllCars());
    }
}
