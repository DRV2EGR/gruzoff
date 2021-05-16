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

@RestController
@RequestMapping(value = "/v1/api/cars", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {
    @Autowired
    CarService carService;

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

    @PostMapping("/private/add")
    public ResponseEntity<CarDto> addCar(@RequestBody AddNewCarDtoPayload addNewCarDtoPayload) {
        return ResponseEntity.ok(carService.addNewCar(getAuthentificatedUser(), addNewCarDtoPayload));
    }

    @GetMapping("/")
    public ResponseEntity<List<CarDto>> getAllCars() {
        return ResponseEntity.ok(carService.getAllValidCars());
    }

    @GetMapping("/get_car_types")
    public ResponseEntity<List<CarTypeDto>> getAllCarTypes() {
        return ResponseEntity.ok(carService.getAllCarTypes());
    }

    @DeleteMapping("/private/delete_car")
    public ResponseEntity<BasicResponce> deleteCar(@RequestParam long car_id) {
        if (carService.disvalidCarById(car_id)) {
            return ResponseEntity.ok(new ResponseStatusOperationDto("OK"));
        } else {
            return ResponseEntity.ok(new ResponseStatusOperationDto("ERROR"));
        }
    }

    @GetMapping("/private/all_cars")
    public ResponseEntity<List<CarWithCarValidDto>> getAllCarsInfo() {
        return ResponseEntity.ok(carService.getAllCars());
    }
}
