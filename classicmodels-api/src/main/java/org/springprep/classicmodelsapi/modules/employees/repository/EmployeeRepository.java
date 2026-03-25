package org.springprep.classicmodelsapi.modules.employees.repository;

import org.springprep.classicmodelsapi.modules.employees.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
