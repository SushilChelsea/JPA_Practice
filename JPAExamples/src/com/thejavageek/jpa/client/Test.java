package com.thejavageek.jpa.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.thejavageek.jpa.entities.Employee;

public class Test {

	public static void main(String[] args) {
		/* Create EntityManagerFactory */
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAExamples");
		
		/* Create and populate Entity */
		Employee employee = new Employee();
		employee.setFirstname("prasad");
		employee.setLastname("kharkar");
		employee.setEmail("someMail@gmail.com");
		employee.setIdEmployee(1);
		
		/* Create EntityManager */
		EntityManager em = emf.createEntityManager();
		
		/* Persist entity */
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
		
		/* Retrieve entity */
		employee = em.find(Employee.class, 1);
		System.out.println(employee);
 
		/* Update entity */
		em.getTransaction().begin();
		employee.setFirstname("Pranil");
		System.out.println("Employee after updation :- " + employee);
		em.getTransaction().commit();
 
		/* Remove entity */
		em.getTransaction().begin();
		em.remove(employee);
		em.getTransaction().commit();
 
		/* Check whether enittiy is removed or not */
		employee = em.find(Employee.class, 1);
		System.out.println("Employee after removal :- " + employee);
	}
}
