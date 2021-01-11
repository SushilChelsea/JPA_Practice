package com.thejavageek.joinCols;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee1 {

	@EmbeddedId
	private EmployeeId id;
	private String firstName;
	private String lastName;
	private int salary;
	
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
	private List<Phone> phones;
	
	public EmployeeId getId() {
		return id;
	}
	public void setId(EmployeeId empId) {
		this.id = empId;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
}
