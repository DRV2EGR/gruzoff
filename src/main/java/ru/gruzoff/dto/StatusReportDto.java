package ru.gruzoff.dto;

public class StatusReportDto extends BasicResponce {
    String status;

    public StatusReportDto(byte status) {
        this.status = (status == 1)?"ok":"error";
    }
}
