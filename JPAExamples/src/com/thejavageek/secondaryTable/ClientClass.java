package com.thejavageek.secondaryTable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ClientClass {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAExamples");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		Employee1 emp = new Employee1();
		emp.setFirstName("Ratan");
		emp.setLastName("It");
		emp.setEmail("Ratan@abc.com");
		emp.setSalary(800000.00);
		em.persist(emp);
		transaction.commit();
		
		transaction.begin();
		int emp1id = emp.getIdEmployee();
		Employee1 emp2 = new Employee1();
		emp2.setFirstName("Durga");
		emp2.setLastName("Soft");
		emp2.setEmail("durga@gmail.com");
		emp2.setReports_to(emp1id);
		emp2.setSalary(400000.00);
		em.persist(emp2);
		transaction.commit();
		
		em.close();
		emf.close();
	}

}
