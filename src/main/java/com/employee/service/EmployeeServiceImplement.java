package com.employee.service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import org.springframework.stereotype.Service;
import com.employee.model.Employee;
import com.employee.repositary.EmployeeReposatiy;


@Service
public class EmployeeServiceImplement implements EmployeeService {

    private final EmployeeReposatiy employeeRepository;

    @Autowired
    public EmployeeServiceImplement(EmployeeReposatiy employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
		
	}

	 @Override
	    public Employee getEmployeeById(long id) {
	        return employeeRepository.findById(id).orElse(null);
	    }

	@Override
	public void deleteEmployeeById(long id) {
		// TODO Auto-generated method stub
		this.employeeRepository.deleteById(id);	
	}
	  @Override
	    public Page<Employee> findPagination(int pageNo, int pageSize) {
	        PageRequest pageable = PageRequest.of(pageNo - 1, pageSize);
	        return employeeRepository.findAll(pageable);
	    }
}
