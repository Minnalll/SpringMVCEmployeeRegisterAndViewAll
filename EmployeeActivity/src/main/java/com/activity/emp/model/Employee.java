package com.activity.emp.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emptable")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "eid")
	private Integer empId;
	@Column(name = "ename")
	private String empName;
	@Column(name = "edesg")
	private String empDesg;
	@Column(name = "esal")
	private double empSal;
	@Column(name = "edob")
	private LocalDate empDOB;
	@Column (name = "eAge")
	private int empAge;
	

	public Employee() {
		super();
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesg() {
		return empDesg;
	}

	public void setEmpDesg(String empDesg) {
		this.empDesg = empDesg;
	}

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	public LocalDate getEmpDOB() {
		return empDOB;
	}

	public void setEmpDOB(LocalDate empDOB) {
		this.empDOB = empDOB;
	}

	
	
	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDesg=" + empDesg + ", empSal=" + empSal
				+ ", empDOB=" + empDOB + ", empAge=" + empAge + "]";
	}

}
