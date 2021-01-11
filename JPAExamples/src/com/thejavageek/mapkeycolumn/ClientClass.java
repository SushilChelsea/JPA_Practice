package com.thejavageek.mapkeycolumn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.thejavageek.jpa.entities.Employee;

public class ClientClass {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAExamples");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		Employee emp = new Employee();
		emp.setFirstname("Ajay");
		emp.setLastname("Joshi");
 
		Phone phone1 = new Phone();
		phone1.setOwner(emp);
		phone1.setPhoneNumber("53434524");
		phone1.setProvider("Airtel");
 
		Phone phone2 = new Phone();
		phone2.setOwner(emp);
		phone2.setProvider("bsnl");
		phone2.setPhoneNumber("56252314");
		emp.getPhones().put("Home", phone1);
		emp.getPhones().put("Work", phone2);
 
		em.persist(emp);
 
		emp = new Employee();
		emp.setFirstname("Ashish");
		emp.setLastname("Sharma");
 
		Phone phone3 = new Phone();
		phone3.setOwner(emp);
		phone3.setPhoneNumber("8795656");
		phone3.setProvider("Idea");
 
		Phone phone4 = new Phone();
		phone4.setOwner(emp);
		phone4.setPhoneNumber("0165410254");
		phone4.setProvider("Reliance");
 
		emp.getPhones().put("Home", phone3);
		emp.getPhones().put("Work", phone4);
		em.persist(emp);
		transaction.commit();
	}
}
