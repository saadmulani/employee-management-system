package com.employee.management.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentDto {
    @Schema(description = "Auto-generated ID", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String deptName;
    private String location;
}
