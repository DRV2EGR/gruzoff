package ru.gruzoff.payload;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gruzoff.entity.*;

/**
 * The type Create order dto payload.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDtoPayload {
    /**
     * The Customer id.
     */
    long customerId;
    /**
     * The Car type.
     */
    long car_type;

    /**
     * The Num of loaders.
     */
    int numOfLoaders;

    /**
     * The Order details.
     */
    protected OrderDetailsDtoPayload orderDetails;
    /**
     * The Extra customers.
     */
    protected List<UserDtoPayload> extraCustomers;
}
