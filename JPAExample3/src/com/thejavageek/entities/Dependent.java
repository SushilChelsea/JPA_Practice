package com.thejavageek.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.thejavageek.embeded.DependentId;

@Entity
public class Dependent {

	@EmbeddedId
	private DependentId id;
	
	@ManyToOne
	@MapsId("idEmployee")
	@JoinColumn(name="employee_id")
	private Employee employee;

	public DependentId getId() {
		return id;
	}
	public void setId(DependentId id) {
		this.id = id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
