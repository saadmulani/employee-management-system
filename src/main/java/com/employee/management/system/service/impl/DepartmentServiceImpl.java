package com.employee.management.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employee.management.system.dto.DepartmentDto;
import com.employee.management.system.dto.mapper.DepartmentMapper;
import com.employee.management.system.entity.Department;
import com.employee.management.system.repository.DepartmentRepository;
import com.employee.management.system.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository departmentRepository;
	private final DepartmentMapper departmentMapper;

	public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
		this.departmentRepository = departmentRepository;
		this.departmentMapper = departmentMapper;
	}

	@Override
	public List<DepartmentDto> getAllDepartments() {
		List<Department> departments = departmentRepository.findAll();
		return departmentMapper.mapToDepartmentDtoList(departments);
	}

	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		Department department = departmentMapper.mapToDepartment(departmentDto);
		Department savedDepartment = departmentRepository.save(department);
		return departmentMapper.mapToDepartmentDto(savedDepartment);
	}

	@Override
	public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) {
		Optional<Department> optionalDepartment = departmentRepository.findById(id);
		if (!optionalDepartment.isPresent()) {
			throw new RuntimeException("Department not found with id: " + id);
		}

		Department existingDepartment = optionalDepartment.get();
		Department updatedDepartment = departmentMapper.mapToDepartment(departmentDto);
		updatedDepartment.setId(existingDepartment.getId());
		departmentRepository.save(updatedDepartment);

		return departmentMapper.mapToDepartmentDto(updatedDepartment);
	}

	@Override
	public DepartmentDto getDepartmentById(Long id) {
		Optional<Department> optionalDepartment = departmentRepository.findById(id);
		if (!optionalDepartment.isPresent()) {
			throw new RuntimeException("Department not found with id: " + id);
		}

		Department department = optionalDepartment.get();
		return departmentMapper.mapToDepartmentDto(department);
	}

	@Override
	public void deleteDepartmentById(Long id) {
		Optional<Department> optionalDepartment = departmentRepository.findById(id);
		if (!optionalDepartment.isPresent()) {
			throw new RuntimeException("Department not found with id: " + id);
		}

		Department department = optionalDepartment.get();
		departmentRepository.delete(department);
	}
}
