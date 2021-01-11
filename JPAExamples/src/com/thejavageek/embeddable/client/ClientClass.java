package com.thejavageek.embeddable.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.thejavageek.embeddable.Address;
import com.thejavageek.embeddable.Student;


public class ClientClass {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAExamples");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Address address = new Address();
		address.setArea("Sankhamul");
		address.setCity("Kathmandu");
		address.setPincode("44601");
		
		Student student = new Student();
		student.setName("Sushil");
		student.setAddress(address);
		
		em.persist(student);
		txn.commit();
		
	}
}
