package com.te.loginvalid.repository;

import java.util.List;
import java.util.Optional;

import com.te.loginvalid.dto.RegistrationEmployeeDTO;
import com.te.loginvalid.entity.Employee;

public interface EmployeeRepository {

	Optional<Employee> getEmployee(String employeeId);

	Employee register(Employee employee);

	String updateEmployee(Employee employee, String employeeId);

	boolean deleteEmployee(String employeeId);

	List<Employee> fetechDetails();

}
