package ru.gruzoff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gruzoff.dto.BasicResponce;
import ru.gruzoff.dto.OrderDto;
import ru.gruzoff.dto.ResponseStatusOperationDto;
import ru.gruzoff.service.CarService;
import ru.gruzoff.service.ManagerService;

@RestController
@RequestMapping(value = "/v1/api/manager", produces = MediaType.APPLICATION_JSON_VALUE)
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @Autowired
    CarService carService;

    @GetMapping("/get_orders_to_accept")
    public ResponseEntity<List<OrderDto>> getOrdersToAccept() {
        return ResponseEntity.ok(managerService.getOrdersToAccept());
    }

    @GetMapping("/accept_order")
    public ResponseEntity<BasicResponce> acceptOrder(@RequestParam long orderId, @RequestParam int status) {
        managerService.acceptById(orderId, status);
        return ResponseEntity.ok(new ResponseStatusOperationDto("OK"));
    }

    @GetMapping("/change_car_valid")
    public ResponseEntity<BasicResponce> changeCarValid(@RequestParam long carId, @RequestParam int valid, @RequestParam String reason)
    {
        carService.changeCarValid(carId, valid, reason);
        return ResponseEntity.ok(new ResponseStatusOperationDto("OK"));
    }
}
