package com.thejavageek.jpa.client;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.thejavageek.jpa.entities.Employee;
import com.thejavageek.jpa.entities.Project;

public class ManyToMany {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAExamples");
 
		/* Create EntityManager */
		EntityManager em = emf.createEntityManager();
 
		EntityTransaction transaction = em.getTransaction();
 
		transaction.begin();
 
		Employee prasad = new Employee();
		prasad.setFirstname("prasad");
		prasad.setLastname("kharkar");
 
		Employee harish = new Employee();
		harish.setFirstname("Harish");
		harish.setLastname("taware");
 
		Project ceg = new Project();
		ceg.setName("CEG");
 
		Project gtt = new Project();
		gtt.setName("GTT");
 
		List<Project> projects = new ArrayList<Project>();
		projects.add(ceg);
		projects.add(gtt);
 
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(prasad);
		employees.add(harish);
 
		ceg.setEmployees(employees);
		gtt.setEmployees(employees);
 
		prasad.setProjects(projects);
		harish.setProjects(projects);
 
		em.persist(prasad);
 
		transaction.commit();
	}

}
