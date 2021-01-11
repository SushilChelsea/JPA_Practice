package com.thejavageek.jpa.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.thejavageek.jpa.entities.Department;
import com.thejavageek.jpa.entities.Employee;

public class ManyToOneClient {
	public static void main(String[] args) {
		/* Create EntityManagerFactory */
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAExamples");
		/* Create EntityManager */
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		Employee employee = new Employee();
		employee.setEmail("someMail@gmail.com");
		employee.setFirstname("Prasad");
		employee.setLastname("kharkar");
		
		txn.begin();
		Department department = em.find(Department.class, 1);//returns the department named vert
		System.out.println(department);
		txn.commit();
		
		employee.setDepartment(department);
		 
		txn.begin();
		em.persist(employee);
		txn.commit();
		
	}
}
