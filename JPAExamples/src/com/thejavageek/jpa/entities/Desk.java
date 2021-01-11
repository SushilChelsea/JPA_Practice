package com.thejavageek.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Desk {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddesk;
	@Column(name="desknumber")
	private int deskNumber;
	private String Location;
	
	@OneToOne(mappedBy="desk")
	private Employee employee;
	
	public int getIddesk() {
		return iddesk;
	}
	public void setIddesk(int iddesk) {
		this.iddesk = iddesk;
	}
	public int getDeskNumber() {
		return deskNumber;
	}
	public void setDeskNumber(int deskNumber) {
		this.deskNumber = deskNumber;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Desk [iddesk=" + iddesk + ", deskNumber=" + deskNumber + ", Location=" + Location;
	}
}
