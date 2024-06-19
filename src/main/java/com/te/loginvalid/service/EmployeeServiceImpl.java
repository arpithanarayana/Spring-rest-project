package com.te.loginvalid.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.te.loginvalid.dto.EmployeeDTO;
import com.te.loginvalid.dto.RegistrationEmployeeDTO;
import com.te.loginvalid.entity.Employee;
import com.te.loginvalid.entity.User;
import com.te.loginvalid.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository employeeRepository;

	@Override
	public EmployeeDTO getEmployee(String employeeId) {
		Optional<Employee> employeeOp = employeeRepository.getEmployee(employeeId);
		if (employeeOp.isPresent()) {
			Employee employee = employeeOp.get();

			return EmployeeDTO.builder().employeeId(employeeId).employeeName(employee.getEmployeeName())
					.employeeDOJ(employee.getEmployeeDOJ()).username(employee.getUserCredtials().getUsername()).build();
		}
		return null;
	}

	@Override
	public RegistrationEmployeeDTO register(RegistrationEmployeeDTO registrationEmployeeDTO) {
		Employee employee = Employee.builder().employeeId(registrationEmployeeDTO.getEmployeeId())
				.employeeName(registrationEmployeeDTO.getEmployeeName())
				.employeeDOJ(registrationEmployeeDTO.getEmployeeDOJ())
				.userCredtials(User.builder().username(registrationEmployeeDTO.getUsername())
						.password(registrationEmployeeDTO.getPassword()).build())
				.build();
		Employee employee1 = employeeRepository.register(employee);
		return RegistrationEmployeeDTO.builder().employeeId(registrationEmployeeDTO.getEmployeeId())
				.employeeName(registrationEmployeeDTO.getEmployeeName())
				.employeeDOJ(registrationEmployeeDTO.getEmployeeDOJ())
				.username(registrationEmployeeDTO.getUsername())
				.password(registrationEmployeeDTO.getPassword())
				.build();
	}

	@Override
	public String updateEmployee(RegistrationEmployeeDTO registrationEmployeeDTO, String employeeId) {
		Employee employee = Employee.builder().employeeId(registrationEmployeeDTO.getEmployeeId())
				.employeeName(registrationEmployeeDTO.getEmployeeName())
				.employeeDOJ(registrationEmployeeDTO.getEmployeeDOJ())
				.userCredtials(User.builder().username(registrationEmployeeDTO.getUsername())
						.password(registrationEmployeeDTO.getPassword()).build())
				.build();
		return employeeRepository.updateEmployee(employee, employeeId);
	}

	@Override
	public boolean deleteEmployee(String employeeId) {
		return employeeRepository.deleteEmployee(employeeId);
	}

	@Override
	public List<Employee> fetechDetails() {
		return employeeRepository.fetechDetails();
	}
}
