package com.thejavageek.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Car extends PassengerVehicle {
	private int noOfDoors;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="manufacturer_id")
	private Manufacturer manufacturer;
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public int getNoOfDoors() {
		return noOfDoors;
	}
	public void setNoOfDoors(int noOfDoors) {
		this.noOfDoors = noOfDoors;
	}
	@Override
	public String toString() {
		return "Car [noOfDoors=" + noOfDoors + ", manufacturer=" + manufacturer + "]";
	}
}
