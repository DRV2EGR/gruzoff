package ru.gruzoff.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gruzoff.entity.*;

public interface OrderReposiory extends JpaRepository<Order, Long> {
    Optional<Order> findByIdAndCustomerId(long id, Customers customerId);

    Optional<Order> findAllByCustomerIdAndOrderDetailsDateTimeBetween(Customers customer, Date date1, Date date2);

    List<Optional<Order>> findAllByDriverId(Drivers drivers);

    List<Optional<Order>> findAllByLoadersContaining(Loaders user);

    List<Optional<Order>> findAllByDriverIdIsNull();

    List<Optional<Order>> findAllByDriverIdIsNullAndOrderDetailsDateTime(Date date);

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
