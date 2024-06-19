package com.te.loginvalid.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class RegistrationEmployeeDTO {
	private String employeeId;
	private LocalDateTime employeeDOJ;
	private String employeeName;
	private String username;
	private String password;

}
