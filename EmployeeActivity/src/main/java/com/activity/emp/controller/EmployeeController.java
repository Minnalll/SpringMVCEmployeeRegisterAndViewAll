package com.activity.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.activity.emp.model.Employee;
import com.activity.emp.service.EmployeeService;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	//new employee registration form
	@GetMapping("/register")
	public String newEmployeeRegistrationForm (Model model) {
		//set form backing option
		model.addAttribute("employee", new Employee());
		return "EmployeeRegister";	
	}
	// save or update data
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Employee employee, Model model) {
		// save operation
		Integer saveEmployee = service.saveEmployee(employee);
		model.addAttribute("employee", new Employee());
		model.addAttribute("message", "Employee '"+saveEmployee+"' saved");
		return "EmployeeRegister";		
	}
	// display all values
	@GetMapping("/all")
	public String showAllProducts(Model model) {
		List<Employee> emp = service.getAllEmployees();
		model.addAttribute("list", emp);
		return "EmployeeData";
	}
	// Delete Product based on PathVariable-id
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Integer id,Model model) {
		//delete record
		service.deleteEmployee(id);
		//get new data and goto UI
		List<Employee> emp = service.getAllEmployees();
		model.addAttribute("message", "Employee '"+id+"' Deleted");
		model.addAttribute("list", emp);
		return "EmployeeData";
	}
	// show Edit Page
	@GetMapping("/edit/{id}")
	public String showEditPage(@PathVariable Integer id,Model model) {
		//load Product from DB
		Employee emp = service.getEmployeeById(id);
		//send object to UI => Form data
		model.addAttribute("employee", emp);
		return "EmployeeRegister";
	}
}
