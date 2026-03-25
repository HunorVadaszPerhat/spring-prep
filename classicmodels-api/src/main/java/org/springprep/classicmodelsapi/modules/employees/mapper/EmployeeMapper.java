package org.springprep.classicmodelsapi.modules.employees.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springprep.classicmodelsapi.modules.employees.dto.EmployeeDto;
import org.springprep.classicmodelsapi.modules.employees.model.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "employeeNumber", ignore = true)
    @Mapping(target = "office", ignore = true)
    @Mapping(target = "manager", ignore = true)
    @Mapping(target = "subordinates", ignore = true)
    @Mapping(target = "customers", ignore = true)
    Employee toEntity(EmployeeDto dto);

    @Mapping(target = "officeCode", source = "office.officeCode")
    @Mapping(target = "reportsTo", source = "manager.employeeNumber")
    EmployeeDto toDto(Employee entity);
}
