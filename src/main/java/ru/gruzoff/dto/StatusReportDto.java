package ru.gruzoff.dto;

import lombok.Data;

@Data
public class StatusReportDto extends BasicResponce {
    String status;

    public StatusReportDto(byte status) {
        super();
        this.status = (status == 1)?"working":"error";
    }
}
