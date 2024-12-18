package com.employee.management.system.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SuccessResponse {

    private Integer statusCode;

    private HttpStatus status;

    private String message;

    private Object data;
}
