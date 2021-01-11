package com.thejavageek.jpa.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.thejavageek.jpa.entities.Employee;

public class Main {

	public static void main(String[] args) {
		/* Create EntityManagerFactory */
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAExamples");
		
		/* Create and populate Entity */
		Employee employee = new Employee();
		employee.setFirstname("prasad");
		employee.setLastname("kharkar");
		employee.setEmail("someMail@gmail.com");
		
		/* Create EntityManager */
		EntityManager em = emf.createEntityManager();
		
		/* Persist entity */
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
		
		/* Retrieve entity */
		employee = em.find(Employee.class, 1);
		System.out.println(employee);

	}

}
