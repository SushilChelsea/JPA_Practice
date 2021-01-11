package com.thejavageek.jpa.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.thejavageek.jpa.entities.Desk;
import com.thejavageek.jpa.entities.Employee;

public class OneToOneClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAExamples");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
//		Desk desk = em.find(Desk.class, 1); 
//		Employee employee = em.find(Employee.class, 1);
//		System.out.println(desk);
//		System.out.println(employee);
//		employee.setDesk(desk);
//		System.out.println("==== after ====");
//		System.out.println(desk);
//		System.out.println(employee);
		
		Employee employee = new Employee();
		employee.setFirstname("pranil");
		employee.setLastname("gilda");
		employee.setEmail("sdfsdf");
		Desk desk = em.find(Desk.class, 1); // retrieves desk from database
		employee.setDesk(desk);
		em.persist(employee);
		desk = em.find(Desk.class, 1); // retrieves desk from database
		desk.setEmployee(employee);
		System.out.println(desk.getEmployee());
		
		txn.commit();
	}

}
