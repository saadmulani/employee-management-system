package com.employee.management.system.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.employee.management.system.dto.DepartmentDto;
import com.employee.management.system.entity.Department;

@Component
public class DepartmentMapper {
    public DepartmentDto mapToDepartmentDto(Department department) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(department, DepartmentDto.class);
    }

    public Department mapToDepartment(DepartmentDto departmentDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(departmentDto, Department.class);
    }

    public List<DepartmentDto> mapToDepartmentDtoList(List<Department> departments) {
        List<DepartmentDto> departmentDtoList = new ArrayList<>();
        for (Department department : departments) {
            departmentDtoList.add( mapToDepartmentDto(department));
        }
        return departmentDtoList;
    }
}
