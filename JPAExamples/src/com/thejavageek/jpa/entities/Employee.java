package com.thejavageek.jpa.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.eclipse.persistence.jpa.config.Cascade;

import com.thejavageek.mapkeycolumn.Phone;

@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEmployee;
	private String email;
	private String firstname;
	private String lastname;

	@ManyToOne
	@JoinColumn(name = "iddepartment")
	private Department department;
	
	@OneToOne
	@JoinColumn(name="iddesk")
	private Desk desk;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(
			name="employee_project",
			joinColumns=@JoinColumn(name="idemployee"),
			inverseJoinColumns=@JoinColumn(name="idproject")
	)
	private List<Project> projects;
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	@MapKeyColumn(name = "phones_keys")
	private Map<String, Phone> phones = new HashMap<>();
	
	public Employee() {
	}

	public int getIdEmployee() {
		return this.idEmployee;
	}
	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return this.firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return this.lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Desk getDesk() {
		return desk;
	}
	public void setDesk(Desk desk) {
		this.desk = desk;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public Map<String, Phone> getPhones() {
		return phones;
	}
	public void setPhones(Map<String, Phone> phones) {
		this.phones = phones;
	}
	@Override
	public String toString() {
		return "Employee [idEmployee=" + idEmployee + ", email=" + email + ", firstname=" + firstname + ", lastname="
				+ lastname + ", department=" + department + ", desk=" + desk + "]";
	}
}
