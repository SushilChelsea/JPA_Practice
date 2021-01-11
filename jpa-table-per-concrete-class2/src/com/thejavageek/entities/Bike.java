package com.thejavageek.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
    @NamedQuery(name="Bike.findBikeByManufacturer",
                query="SELECT b FROM Bike b WHERE b.manufacturer=:manufacturer")
}) 
public class Bike extends PassengerVehicle {
	public final static String FIND_BY_MANUFACTURER_Native_SQL = "select * from bike b where b.manufacturer_id=?1";
	public final static String FIND_ALL_Native_SQL = "select * from bike b";
	
	private int saddleHeight;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="manufacturer_id")
	private Manufacturer manufacturer;
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getSaddleHeight() {
		return saddleHeight;
	}
	public void setSaddleHeight(int saddleHeight) {
		this.saddleHeight = saddleHeight;
	}
	@Override
	public String toString() {
		return "Bike [idVehicle="+ super.getIdVehicle() + ", noOfpassengers="+ super.getNoOfpassengers() + ", saddleHeight=" + saddleHeight + ", manufacturer=" + manufacturer + "]";
	}
}
