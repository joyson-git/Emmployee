package com.employee.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;

@Repository
public interface EmployeeReposatiy  extends JpaRepository<Employee, Long>{

	

	

}
