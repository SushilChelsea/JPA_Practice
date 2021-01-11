package com.thejavageek.mapkeycolumn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.thejavageek.jpa.entities.Employee;

@Entity
public class Phone {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idphone;
	@Column(name="phone_number")
	private String phoneNumber;
	private String provider;

	@ManyToOne
	private Employee owner;

	public int getIdphone() {
		return idphone;
	}
	public void setIdphone(int idphone) {
		this.idphone = idphone;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public Employee getOwner() {
		return owner;
	}
	public void setOwner(Employee owner) {
		this.owner = owner;
	}
}
