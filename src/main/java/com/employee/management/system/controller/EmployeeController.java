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

import com.employee.management.system.dto.EmployeeDto;
import com.employee.management.system.dto.SuccessResponse;
import com.employee.management.system.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@Tag(name ="Employee APIs", description = "Read, Update and Delete Employee")
public class EmployeeController  {

    private final EmployeeService  employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    @Operation(summary = "Get all employees information")
    public ResponseEntity<SuccessResponse> getAllEmployees() {
        return ResponseEntity.ok(new SuccessResponse(HttpStatus.OK.value(), HttpStatus.OK,
                "all employee fetched successfully", employeeService.getAllEmployees()));
    }

    @PostMapping
    @Operation(summary = "Create new employee")
    public ResponseEntity<SuccessResponse> createEmployee(@RequestBody EmployeeDto employeeDto) {
    	return ResponseEntity.ok(new SuccessResponse(HttpStatus.OK.value(), HttpStatus.OK,
                "Employee added successfully", employeeService.createEmployee(employeeDto)));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update existing employee information")
    public ResponseEntity<SuccessResponse> updateEmployee(@PathVariable Long id,@RequestBody EmployeeDto employeeDto) {
    	return ResponseEntity.ok(new SuccessResponse(HttpStatus.OK.value(), HttpStatus.CREATED,
                "Employee updated successfully", employeeService.updateEmployee(id,employeeDto)));
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete specific employee information")
    public ResponseEntity<SuccessResponse> deleteEmployeeById(@PathVariable Long id) {
    	employeeService.deleteEmployeeById(id);
    	return ResponseEntity.ok(new SuccessResponse(HttpStatus.OK.value(), HttpStatus.OK,
                "Employee deleted successfully", null));
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get specific employee information")
    public ResponseEntity<SuccessResponse> getEmployeeById(@PathVariable Long id) {
    	return ResponseEntity.ok(new SuccessResponse(HttpStatus.OK.value(), HttpStatus.OK,
                "Employee fetched successfully", employeeService.getEmployeeById(id)));
    }
}
