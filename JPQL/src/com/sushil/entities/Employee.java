package com.sushil.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idemployee;
	private String name;
	
	public int getIdemployee() {
		return idemployee;
	}
	public void setIdemployee(int idemployee) {
		this.idemployee = idemployee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [idemployee=" + idemployee + ", name=" + name + "]";
	}
}
