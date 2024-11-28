package com.employee.management.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employee.management.system.dto.EmployeeDto;
import com.employee.management.system.dto.mapper.EmployeeMapper;
import com.employee.management.system.entity.Employee;
import com.employee.management.system.repository.EmployeeRepository;
import com.employee.management.system.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final EmployeeMapper employeeMapper;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
		this.employeeRepository = employeeRepository;
		this.employeeMapper = employeeMapper;
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employeeMapper.mapToEmployeeDtoList(employees);
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// Check if ID is present and an employee with that ID already exists
		if (employeeDto.getId() != null && employeeRepository.existsById(employeeDto.getId())) {
			throw new RuntimeException("Employee already exists with id: " + employeeDto.getId());
		}

		// Map EmployeeDto to Employee
		Employee employee = employeeMapper.mapToEmployee(employeeDto);

		// If the employeeDto has no ID, the repository will assign an auto-incremented ID
		Employee savedEmployee = employeeRepository.save(employee);

		// Return the saved employee as a DTO
		return employeeMapper.mapToEmployeeDto(savedEmployee);
	}



	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if (!optionalEmployee.isPresent()) {
			throw new RuntimeException("Employee not found with id: " + id);
		}

		Employee existingEmployee = optionalEmployee.get();
		Employee updatedEmployee = employeeMapper.mapToEmployee(employeeDto);
		updatedEmployee.setId(existingEmployee.getId());
		employeeRepository.save(updatedEmployee);

		return employeeMapper.mapToEmployeeDto(updatedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if (!optionalEmployee.isPresent()) {
			throw new RuntimeException("Employee not found with id: " + id);
		}

		Employee employee = optionalEmployee.get();
		return employeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if (!optionalEmployee.isPresent()) {
			throw new RuntimeException("Employee not found with id: " + id);
		}

		Employee employee = optionalEmployee.get();
		employeeRepository.delete(employee);
	}
}
