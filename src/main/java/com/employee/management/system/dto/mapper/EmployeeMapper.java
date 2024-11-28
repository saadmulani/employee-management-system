package com.employee.management.system.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.employee.management.system.dto.EmployeeDto;
import com.employee.management.system.entity.Department;
import com.employee.management.system.entity.Employee;
import com.employee.management.system.repository.DepartmentRepository;

@Component
public class EmployeeMapper {

	public EmployeeDto mapToEmployeeDto(Employee employee) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(employee, EmployeeDto.class);
	}

	public Employee mapToEmployee(EmployeeDto employeeDto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(employeeDto, Employee.class);
	}

	public List<EmployeeDto> mapToEmployeeDtoList(List<Employee> employees) {
		List<EmployeeDto> employeeDtoList = new ArrayList<>();
		for (Employee employee : employees) {
			employeeDtoList.add(mapToEmployeeDto(employee));
		}
		return employeeDtoList;
	}
}

