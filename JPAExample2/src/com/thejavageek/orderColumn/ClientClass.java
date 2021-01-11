package com.thejavageek.orderColumn;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ClientClass {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAExample2");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		txn.begin();
		Employee2 emp = new Employee2();
		emp.setFirstName("Prasad");
		emp.setLastName("Kharkar");
 
		List<String> phones = new ArrayList<String>();
		phones.add("353745415");
		phones.add("225765367");
		phones.add("92573626726");
		emp.setPhones(phones);
 
		em.persist(emp);
		txn.commit();
 
		int id = emp.getIdEmployee();
 
		emp = em.find(Employee2.class, id);
 
		phones = emp.getPhones();
 
		for (String s : phones) {
			System.out.println(s);
		}
 
		em.close();
		emf.close();

	}

}

