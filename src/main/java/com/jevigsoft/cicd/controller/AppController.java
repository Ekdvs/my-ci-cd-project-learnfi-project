package com.jevigsoft.cicd.controller;

import com.jevigsoft.cicd.dto.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author Navishka Darshana - navishka@learnfi.lk
 * @project my-cicd-project
 * @CreatedBy IntelliJ IDEA
 * @created 26/01/2024 - 14.08
 */

@RestController
@RequestMapping(value = "/application")
@RequiredArgsConstructor
@Log4j2
public class AppController {

    @Value("${appVersion}")
    private String appVersion;


    @GetMapping(value = "/version")
    public ResponseEntity<?> getAppVersion() {
        log.info("start method getAppVersion");
        return ResponseEntity.ok(new CommonResponse<>(true, "application version",appVersion));
    }

}
