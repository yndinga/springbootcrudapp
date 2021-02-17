package com.javaweb.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.springboot.model.Employee;
import com.javaweb.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
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
		java.util.Optional<Employee> existingItemOptional = employeeRepository.findById(id);
		Employee employee = null;
		if(existingItemOptional.isPresent()) {
			employee = existingItemOptional.get();			
		}else {
			throw new RuntimeException("Employee not fund for id::" + id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {

		this.employeeRepository.deleteById(id);

	}
	
}

