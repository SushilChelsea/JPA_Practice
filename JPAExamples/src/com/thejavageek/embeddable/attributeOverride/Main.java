package com.thejavageek.embeddable.attributeOverride;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.thejavageek.embeddable.Address;
import com.thejavageek.embeddable.Student;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAExamples");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		Address address = new Address();
		address.setArea("Bhrikutinagar");
		address.setCity("Nepalgunj");
		address.setPincode("5504");
		
		Student student = new Student();
		student.setName("Sulav");
		student.setAddress(address);
		
		Office office = new Office();
		office.setAddress(address);
		
		em.persist(student);
		em.persist(office);
		
		transaction.commit();
	}

}
