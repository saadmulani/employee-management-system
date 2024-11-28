package com.employee.management.system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.system.dto.DepartmentDto;
import com.employee.management.system.dto.SuccessResponse;
import com.employee.management.system.service.DepartmentService;

@RestController
@RequestMapping("/department")
@Tag(name ="Department APIs" , description = "Read, Update and Delete Department")
public class DepartmentController{
	private final DepartmentService  departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping
    @Operation(summary = "Get all departments information")
    public ResponseEntity<SuccessResponse> getAllDepartments() {
        return ResponseEntity.ok(new SuccessResponse(HttpStatus.OK.value(), HttpStatus.OK,
                "All departments fetched successfully", departmentService.getAllDepartments()));
    }

    @PostMapping
    @Operation(summary = "Create new Department")
    public ResponseEntity<SuccessResponse> createDepartment(@RequestBody DepartmentDto departmentDto) {
    	return ResponseEntity.ok(new SuccessResponse(HttpStatus.OK.value(), HttpStatus.CREATED,
                "Department added successfully", departmentService.createDepartment(departmentDto)));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update department information")
    public ResponseEntity<SuccessResponse> updateDepartment(@PathVariable Long id,@RequestBody DepartmentDto departmentDto) {
    	return ResponseEntity.ok(new SuccessResponse(HttpStatus.OK.value(), HttpStatus.OK,
                "Department updated successfully", departmentService.updateDepartment(id,departmentDto)));
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete specific department information")
    public ResponseEntity<SuccessResponse> deleteDepartmentById(@PathVariable Long id) {
    	departmentService.deleteDepartmentById(id);
    	return ResponseEntity.ok(new SuccessResponse(HttpStatus.OK.value(), HttpStatus.OK,
                "Department deleted successfully", null));
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get specific department information")
    public ResponseEntity<SuccessResponse> getDepartmentById(@PathVariable Long id) {
    	return ResponseEntity.ok(new SuccessResponse(HttpStatus.OK.value(), HttpStatus.OK,
                "Department fetched successfully", departmentService.getDepartmentById(id)));
    }
}
