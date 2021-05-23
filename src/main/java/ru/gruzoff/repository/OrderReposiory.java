package ru.gruzoff.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gruzoff.entity.*;

/**
 * The interface Order reposiory.
 */
public interface OrderReposiory extends JpaRepository<Order, Long> {
    /**
     * Find by id and customer id optional.
     *
     * @param id         the id
     * @param customerId the customer id
     * @return the optional
     */
    Optional<Order> findByIdAndCustomerId(long id, Customers customerId);

    /**
     * Find all by customer id and order details date time between optional.
     *
     * @param customer the customer
     * @param date1    the date 1
     * @param date2    the date 2
     * @return the optional
     */
    Optional<Order> findAllByCustomerIdAndOrderDetailsDateTimeBetween(Customers customer, Date date1, Date date2);

    /**
     * Find all by driver id list.
     *
     * @param drivers the drivers
     * @return the list
     */
    List<Optional<Order>> findAllByDriverId(Drivers drivers);

    /**
     * Find all by loaders containing list.
     *
     * @param user the user
     * @return the list
     */
    List<Optional<Order>> findAllByLoadersContaining(Loaders user);

    /**
     * Find all by driver id is null list.
     *
     * @return the list
     */
    List<Optional<Order>> findAllByDriverIdIsNull();

    /**
     * Find all by driver id is null and order details date time list.
     *
     * @param date the date
     * @return the list
     */
    List<Optional<Order>> findAllByDriverIdIsNullAndOrderDetailsDateTime(Date date);

    /**
     * Find all by status list.
     *
     * @param status the status
     * @return the list
     */
    List<Optional<Order>> findAllByStatus(String status);

    /**
     * Find all by car id list.
     *
     * @param car the car
     * @return the list
     */
    List<Optional<Order>> findAllByCarId(Car car);

    /**
     * Count by loaders list.
     *
     * @param date the date
     * @return the list
     */
/*
        select o.id from orders o
        left join order_details od ON o.order_details_id = od.id
        left join orders_loaders ol on ol.order_id = o.id
        group by o.id, od.loaders_capacity
        HAVING count(loaders_id) < od.loaders_capacity ;
     */
    @Query("select o.id from Order o where o.loaders.size < o.orderDetails.loadersCapacity and o.orderDetails.dateTime = ?1")
    List<Optional<Long>> countByLoaders(Date date);
}
