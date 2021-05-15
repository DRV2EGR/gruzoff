package ru.gruzoff.payload;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gruzoff.entity.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDtoPayload {
    long customerId;
    long car_type;

    int numOfLoaders;

    protected OrderDetailsDtoPayload orderDetails;
    protected List<UserDtoPayload> extraCustomers;
}
