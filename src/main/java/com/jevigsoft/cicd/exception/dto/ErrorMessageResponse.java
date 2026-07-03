package com.jevigsoft.cicd.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Navishka Darshana - navishka@learnfi.lk
 * @project my-cicd-project
 * @CreatedBy IntelliJ IDEA
 * @created 26/08/2024 - 23.16
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessageResponse {

    private boolean success;
    private String message;
    private int code;
}
