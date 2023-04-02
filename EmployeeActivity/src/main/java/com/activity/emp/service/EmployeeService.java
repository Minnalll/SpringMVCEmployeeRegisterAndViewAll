package com.activity.emp.service;

import java.util.List;

import com.activity.emp.model.Employee;

public interface EmployeeService {
	
	public Integer saveEmployee(Employee p);

	public void deleteEmployee(Integer empId);

	public Employee getEmployeeById(Integer empId);

	public List<Employee> getAllEmployees();
	
	public String age(Integer empId);

}
