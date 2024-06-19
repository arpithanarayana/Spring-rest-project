package com.te.loginvalid.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.loginvalid.dto.EmployeeDTO;
import com.te.loginvalid.dto.RegistrationEmployeeDTO;
import com.te.loginvalid.entity.Employee;
import com.te.loginvalid.response.SuccessResponse;
import com.te.loginvalid.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = "/app/employee")
@RestController
public class AuthController {
	
private final EmployeeService employeeService;
	
	@GetMapping(path = "/dummy",
			    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
			    //consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public RegistrationEmployeeDTO dummy() {
		return new RegistrationEmployeeDTO();
	}	
	
	@GetMapping(path = "/{employeeId}", 
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<SuccessResponse> getEmployee(@PathVariable String employeeId) {
		
		EmployeeDTO employeeDTO =  employeeService.getEmployee(employeeId);
		return ResponseEntity.ok().body(SuccessResponse.builder()
				.message("A simple message")
				.data(employeeDTO)
				.status(HttpStatus.OK)
				.timestamp(LocalDateTime.now().toString()).build());
	}

	@PostMapping(path = "/",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
			)
	public ResponseEntity<SuccessResponse> registerEmployee(@RequestBody RegistrationEmployeeDTO registrationEmployeeDTO){
		registrationEmployeeDTO = employeeService.register(registrationEmployeeDTO);
		
		return ResponseEntity.ok().body(SuccessResponse.builder()
				.message("registration sucessfully")
				.data(registrationEmployeeDTO)
				.status(HttpStatus.CREATED)
				.timestamp(LocalDateTime.now().toString()).build());
	}
	
	@PutMapping(path ="/employees/{employeeId}",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
			)
	public ResponseEntity<SuccessResponse> updateEmployee(@RequestBody RegistrationEmployeeDTO registrationEmployeeDTO, @PathVariable String employeeId){
		String result =  employeeService.updateEmployee(registrationEmployeeDTO, employeeId);
		HttpStatus status = (result != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;

		return ResponseEntity.ok().body(SuccessResponse.builder()
				.message("update the details sucessfully")
				.data(status)
				.status(HttpStatus.OK)
				.timestamp(LocalDateTime.now().toString()).build());
	}
	
	@DeleteMapping(path = "/{employeeId}", 
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<SuccessResponse> deleteEmployee(@PathVariable String employeeId){
		
		boolean isdeleteIn = employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok().body(SuccessResponse.builder()
				.message("delete the details sucessfully based on the employeeId")
				.data(employeeId)
				.status(HttpStatus.OK)
				.timestamp(LocalDateTime.now().toString()).build());
	}
	
	@GetMapping(path = "/fetchemployee",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<SuccessResponse> fetechEmployee(){
		
		List<Employee> employees =  employeeService.fetechDetails();
		return ResponseEntity.ok().body(SuccessResponse.builder()
				.message("delete the details sucessfully based on the employeeId")
				.data(employees)
				.status(HttpStatus.OK)
				.timestamp(LocalDateTime.now().toString()).build());
	}

}
