package com.te.loginvalid.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Entity
@Table(name = "user_tbl")
public class User {
	@Id
	private String username;
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "userCredtials")
	private Employee employee;

}
