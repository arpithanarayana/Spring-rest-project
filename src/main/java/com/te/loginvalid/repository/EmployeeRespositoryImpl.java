package com.te.loginvalid.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import com.te.loginvalid.dto.EmployeeDTO;
import com.te.loginvalid.dto.RegistrationEmployeeDTO;
import com.te.loginvalid.entity.Employee;
import com.te.loginvalid.entity.User;

@Repository
public class EmployeeRespositoryImpl implements EmployeeRepository{
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MySQL01");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Override
	public Optional<Employee> getEmployee(String employeeId) {
		return Optional.<Employee>ofNullable(entityManager.find(Employee.class, employeeId));
	}

	@Override
	public Employee register(Employee employee) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}

	@Override
	public String updateEmployee(Employee employee, String employeeId) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Employee employee1 = entityManager.find(Employee.class, employeeId);
		if(employee1!=null) {
			entityTransaction.begin();
			employee1.setEmployeeName(employee.getEmployeeName());
			entityTransaction.commit();	
			return "update sucessfully";
		}
		return "user not found";
	}

	@Override
	public boolean deleteEmployee(String employeeId) {
		Employee employee = entityManager.find(Employee.class, employeeId);
		if(employee!=null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<Employee> fetechDetails() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		System.out.println("hii");
		Query query = entityManager.createQuery("FROM Employee");
		List<Employee> list = query.getResultList();
		entityTransaction.commit();
		return list;
	}

	

	

}
