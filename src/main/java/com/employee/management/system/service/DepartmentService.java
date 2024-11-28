package com.employee.management.system.service;

import java.util.List;

import com.employee.management.system.dto.DepartmentDto;

public interface DepartmentService {

	List<DepartmentDto> getAllDepartments();

	DepartmentDto createDepartment(DepartmentDto departmentDto);

	DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto);

	DepartmentDto getDepartmentById(Long id);

	void deleteDepartmentById(Long id);

}
