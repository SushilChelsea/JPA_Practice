package com.thejavageek.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVehicle;
	private String manufacturer;
 
	public int getIdVehicle() {
		return idVehicle;
	}
 
	public void setIdVehicle(int idVehicle) {
		this.idVehicle = idVehicle;
	}
 
	public String getManufacturer() {
		return manufacturer;
	}
 
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
}
