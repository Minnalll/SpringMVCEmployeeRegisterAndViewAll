package com.activity.emp.serviceimpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activity.emp.dao.EmployeeRepository;
import com.activity.emp.model.Employee;
import com.activity.emp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Integer saveEmployee(Employee e) {
		// save or update -> same object with PK
		e = repo.save(e);
		Integer empId = e.getEmpId();
		return empId;
	}

	@Override
	public void deleteEmployee(Integer empId) {
		// deletes an employee from repo using ID
		repo.deleteById(empId);

	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		// retrieve an employee from repo using ID
		Optional<Employee> emp = repo.findById(empId);
		if (emp.isPresent()) {
			return emp.get();
		} else {
			return new Employee();
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		// to retrieve all employees from repo
		
		List<Employee> findAll = repo.findAll();
		
		for (Employee employee : findAll) {
			employee.setEmpAge(calculateAge(employee.getEmpDOB()));
			repo.save(employee);
		}
		return repo.findAll();
	}

	@Override
	public String age(Integer empId) {
		Employee referenceById = repo.getReferenceById(empId);
		return null;
	}

//	@Override
//	public String age(Integer empId) {
//		repo.fi
//		LocalDate dob = LocalDate.parse(input);
//		// prints the age
//		System.out.println("You are " + calculateAge(dob) + " years old.");
//	}
//
//	// the method calculates the age
	public int calculateAge(LocalDate dob) {
		// creating an instance of the LocalDate class and invoking the now() method
		// now() method obtains the current date from the system clock in the default
		// time zone
		LocalDate curDate = LocalDate.now();
		// calculates the amount of time between two dates and returns the years
		if ((dob != null) && (curDate != null)) {
			return Period.between(dob, curDate).getYears();
		} else {
			return 0;
		}
	}
}
