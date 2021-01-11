package com.thejavageek.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Truck extends TransportationVehicle {
	private int noOfContainers;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="manufacturer_id")
	private Manufacturer manufacturer;
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getNoOfContainers() {
		return noOfContainers;
	}
	public void setNoOfContainers(int noOfContainers) {
		this.noOfContainers = noOfContainers;
	}
	@Override
	public String toString() {
		return "Truck [noOfContainers=" + noOfContainers + ", manufacturer=" + manufacturer + "]";
	}
}
