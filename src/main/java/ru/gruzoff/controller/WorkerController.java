package ru.gruzoff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.gruzoff.dto.BasicResponce;
import ru.gruzoff.dto.CarWithCarValidDto;
import ru.gruzoff.dto.OrderDto;
import ru.gruzoff.dto.ResponseStatusOperationDto;
import ru.gruzoff.entity.User;
import ru.gruzoff.exception.UserNotFoundExeption;
import ru.gruzoff.payload.DateFilterDtoPayload;
import ru.gruzoff.service.OrderService;
import ru.gruzoff.service.UserService;

/**
 * The type Worker controller.
 */
@RestController
@RequestMapping(value = "/v1/api/worker", produces = MediaType.APPLICATION_JSON_VALUE)
public class WorkerController {
    /**
     * The User service.
     */
    @Autowired
    UserService userService;

    /**
     * The Order service.
     */
    @Autowired
    OrderService orderService;

    private User getAuthentificatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser = userService.findByUsername(currentUserName).orElseThrow(
                () -> {throw new UserNotFoundExeption("");}
        );

        return currentUser;
    }

    /**
     * Gets all worker orders between dates.
     *
     * @return the all worker orders between dates
     */
    @GetMapping("/order")
    public ResponseEntity<List<OrderDto>> getAllWorkerOrdersBetweenDates() {
        return ResponseEntity.ok(orderService.findAllWorkerOrders(
                getAuthentificatedUser()
        ));
    }

    /**
     * Gets worker orders between dates.
     *
     * @param dateFilterDtoPayload the date filter dto payload
     * @return the worker orders between dates
     */
    @PostMapping("/orders_on_day")
    public ResponseEntity<List<OrderDto>> getWorkerOrdersBetweenDates(@RequestBody DateFilterDtoPayload dateFilterDtoPayload) {
        return ResponseEntity.ok(orderService.findOrdersOnDate(
                getAuthentificatedUser(),
                dateFilterDtoPayload.getDate1()
        ));
    }

    /**
     * Gets driver cars.
     *
     * @return the driver cars
     */
    @GetMapping("/driver/get_driver_cars")
    public ResponseEntity<List<CarWithCarValidDto>> getDriverCars() {
        return ResponseEntity.ok(orderService.getAllDriverCars(getAuthentificatedUser()));
    }

    /**
     * Take order as driver response entity.
     *
     * @param orderId the order id
     * @param carId   the car id
     * @return the response entity
     */
    @GetMapping("/driver/take_order_as_driver")
    public ResponseEntity<BasicResponce> takeOrderAsDriver(@RequestParam long orderId, @RequestParam long carId) {
        if ((orderService.takeOrderToDriver(getAuthentificatedUser(), carId, orderId))) {
            return ResponseEntity.ok(new ResponseStatusOperationDto("OK"));
        }

        return ResponseEntity.ok(new ResponseStatusOperationDto("ERROR"));
    }

    /**
     * Show relevant order by date driver response entity.
     *
     * @param dateFilterDtoPayload the date filter dto payload
     * @return the response entity
     */
    @PostMapping("/driver/show_relevant_orders_on_day")
    public ResponseEntity<List<OrderDto>> showRelevantOrderByDateDriver(@RequestBody DateFilterDtoPayload dateFilterDtoPayload) {
        return ResponseEntity.ok(orderService.showReleventOrdersOnDay(dateFilterDtoPayload.getDate1(), 1));
    }

    /**
     * Reject driver order response entity.
     *
     * @param orderId the order id
     * @return the response entity
     */
    @GetMapping("/driver/reject_order")
    public ResponseEntity<BasicResponce> rejectDriverOrder(@RequestParam long orderId) {
        if (orderService.rejectWorkerAcceptedOrder(getAuthentificatedUser(), orderId, 1)) {
            return ResponseEntity.ok(new ResponseStatusOperationDto("OK"));
        }
        return ResponseEntity.ok(new ResponseStatusOperationDto("ERROR"));
    }

    /**
     * Show relevant order by date loader response entity.
     *
     * @param dateFilterDtoPayload the date filter dto payload
     * @return the response entity
     */
    @PostMapping("/loader/show_relevant_orders_on_day")
    public ResponseEntity<List<OrderDto>> showRelevantOrderByDateLoader(@RequestBody DateFilterDtoPayload dateFilterDtoPayload) {
        return ResponseEntity.ok(orderService.showReleventOrdersOnDay(dateFilterDtoPayload.getDate1(), 2));
    }


    /**
     * Take order as loader response entity.
     *
     * @param orderId the order id
     * @return the response entity
     */
    @GetMapping("/loader/take_order_as_loader")
    public ResponseEntity<BasicResponce> takeOrderAsLoader(@RequestParam long orderId) {
        if ((orderService.takeOrderToLoader(getAuthentificatedUser(), orderId))) {
            return ResponseEntity.ok(new ResponseStatusOperationDto("OK"));
        }

        return ResponseEntity.ok(new ResponseStatusOperationDto("ERROR"));
    }

    /**
     * Reject loader order response entity.
     *
     * @param orderId the order id
     * @return the response entity
     */
    @GetMapping("/loader/reject_order")
    public ResponseEntity<BasicResponce> rejectLoaderOrder(@RequestParam long orderId) {
        if (orderService.rejectWorkerAcceptedOrder(getAuthentificatedUser(), orderId, 2)) {
            return ResponseEntity.ok(new ResponseStatusOperationDto("OK"));
        }
        return ResponseEntity.ok(new ResponseStatusOperationDto("ERROR"));
    }

}
