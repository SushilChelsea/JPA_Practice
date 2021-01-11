package com.thejavageek.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.thejavageek.compoundPrimaryKey.EmbeddedEmployeeId;
import com.thejavageek.compoundPrimaryKey.EmployeeId;

@Entity
@Table(name="emp")
//@IdClass(EmployeeId.class) //compound primary key using @IdClass
public class Employee {
 
	/*@Id
	private String branchName;
	@Id
	private int idEmployee;*/
	
	@EmbeddedId
	private EmbeddedEmployeeId id;
 
	private String firstName;
	private String lastName;
	private int salary;
 
	/*public String getBranchName() {
		return branchName;
	}
 
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
 
	public int getIdEmployee() {
		return idEmployee;
	}
 
	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}*/
 
	public EmbeddedEmployeeId getId() {
		return id;
	}
	public void setId(EmbeddedEmployeeId id) {
		this.id = id;
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
 
}
