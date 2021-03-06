package com.thejavageek.jpa.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddepartment;
	private String name;
	
	@OneToMany(mappedBy="department")
	private List<Employee> employees;
 
	public int getIddepartment() {
		return iddepartment;
	}
	public void setIddepartment(int iddepartment) {
		this.iddepartment = iddepartment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Department [iddepartment=" + iddepartment + ", name=" + name
				+ "]";
	}
	
}
