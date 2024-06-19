package com.te.loginvalid.service;

import java.util.List;

import com.te.loginvalid.dto.EmployeeDTO;
import com.te.loginvalid.dto.RegistrationEmployeeDTO;
import com.te.loginvalid.entity.Employee;


public interface EmployeeService {

	EmployeeDTO getEmployee(String employeeId);

	RegistrationEmployeeDTO register(RegistrationEmployeeDTO registrationEmployeeDTO);

	String updateEmployee(RegistrationEmployeeDTO registrationEmployeeDTO, String employeeId);

	boolean deleteEmployee(String employeeId);

	List<Employee> fetechDetails();

	

}
