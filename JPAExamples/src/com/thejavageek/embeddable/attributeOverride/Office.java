package com.thejavageek.embeddable.attributeOverride;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.thejavageek.embeddable.Address;

@Entity
public class Office {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOffice;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="area", column=@Column(name="landmark")),
		@AttributeOverride(name="pincode", column=@Column(name="postal_code")),
	})
	private Address address;
	
	public int getIdOffice() {
		return idOffice;
	}
	public void setIdOffice(int idOffice) {
		this.idOffice = idOffice;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
