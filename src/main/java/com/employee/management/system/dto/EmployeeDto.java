package com.employee.management.system.dto;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
    @Schema(description = "Auto-generated ID", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date hireDate;
    private Double salary;
    private Long departmentId;
}
