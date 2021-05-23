package ru.gruzoff.dto;

import lombok.Data;

/**
 * The type Status report dto.
 */
@Data
public class StatusReportDto extends BasicResponce {
    /**
     * The Status.
     */
    String status;

    /**
     * Instantiates a new Status report dto.
     *
     * @param status the status
     */
    public StatusReportDto(byte status) {
        super();
        this.status = (status == 1)?"working":"error";
    }
}
