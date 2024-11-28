package com.employee.management.system.service;

import java.util.List;

import com.employee.management.system.dto.EmployeeDto;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();
    
    EmployeeDto createEmployee(EmployeeDto employeeDto);

	EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);

	EmployeeDto getEmployeeById(Long id);

	void deleteEmployeeById(Long id);
}
