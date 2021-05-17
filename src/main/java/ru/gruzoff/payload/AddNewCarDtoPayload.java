package ru.gruzoff.payload;

import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gruzoff.entity.CarType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddNewCarDtoPayload {
    protected long driverId;

    protected int max_weight;
    protected int length;
    protected int width;
    protected int height;
    protected int size;
    protected int maxPeopleCapacity;

    protected long type;

    protected String gosNomber;
}
