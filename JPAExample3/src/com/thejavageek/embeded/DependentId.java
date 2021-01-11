package com.thejavageek.embeded;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DependentId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idEmployee;
	private String name;
	
	public int getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((name == null) ? 0 : name.hashCode());
		result = prime * result + idEmployee;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DependentId other = (DependentId) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (idEmployee != other.idEmployee)
			return false;
		return true;
	}
	
}
