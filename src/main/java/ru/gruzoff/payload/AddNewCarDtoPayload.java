package ru.gruzoff.payload;

import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gruzoff.entity.CarType;

/**
 * The type Add new car dto payload.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddNewCarDtoPayload {
    /**
     * The Driver id.
     */
    protected long driverId;

    /**
     * The Max weight.
     */
    protected int max_weight;
    /**
     * The Length.
     */
    protected int length;
    /**
     * The Width.
     */
    protected int width;
    /**
     * The Height.
     */
    protected int height;
    /**
     * The Size.
     */
    protected int size;
    /**
     * The Max people capacity.
     */
    protected int maxPeopleCapacity;

    /**
     * The Type.
     */
    protected long type;

    /**
     * The Gos nomber.
     */
    protected String gosNomber;
}
