package ru.gruzoff.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gruzoff.dto.BasicResponce;
import ru.gruzoff.dto.StatusReportDto;

/**
 * The type Restfull controller.
 */
@RestController
@RequestMapping(value = "/v1/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestfullController {


    /**
     * Check ststus response entity.
     *
     * @return the response entity
     */
    @GetMapping("/status_check")
    public ResponseEntity<BasicResponce> checkStstus() {
        return ResponseEntity.ok(new StatusReportDto((byte) 1));
    }
}
