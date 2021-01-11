package com.thejavageek.joinCols;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Phone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idphone;
	@Column(name="phone_number")
	private String phoneNumber;
	private String provider;
	
	@JoinColumns({
		@JoinColumn(name="emp_id", referencedColumnName="idemployee"),
		@JoinColumn(name="location", referencedColumnName="branchname")
	})
	@ManyToOne
	private Employee1 owner;

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
	public Employee1 getOwner() {
		return owner;
	}
	public void setOwner(Employee1 owner) {
		this.owner = owner;
	}
	@Override
	public String toString() {
		return "Phone [idphone=" + idphone + ", phoneNumber=" + phoneNumber + ", provider=" + provider + "]";
	}
	
}
