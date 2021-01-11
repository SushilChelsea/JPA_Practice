package com.thejavageek.secondaryTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name="employee")
@SecondaryTable(name="employee_details", pkJoinColumns=@PrimaryKeyJoinColumn(name="idemployee"))
public class Employee1 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEmployee;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	private String email;
	
	@Column(table = "employee_details")
	private Double salary;
	
	@Column(table = "employee_details")
	private int reports_to;

	public int getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public int getReports_to() {
		return reports_to;
	}
	public void setReports_to(int reports_to) {
		this.reports_to = reports_to;
	}
}
