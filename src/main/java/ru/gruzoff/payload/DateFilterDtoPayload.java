package ru.gruzoff.payload;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The type Date filter dto payload.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateFilterDtoPayload {
    /**
     * The Date 1.
     */
    protected Date date1;
    /**
     * The Date 2.
     */
    protected Date date2;
}
