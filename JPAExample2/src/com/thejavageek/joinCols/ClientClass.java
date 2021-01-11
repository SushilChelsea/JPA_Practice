package com.thejavageek.joinCols;

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
		EntityTransaction transaction = em.getTransaction();
		
//		transaction.begin();
//		Employee1 emp = new Employee1();
//		EmployeeId empId = new EmployeeId("Pune", 2);
//		emp.setId(empId);
//		emp.setFirstName("Prasad");
//		emp.setLastName("Kharkar");
//		 
//		Phone phone1 = new Phone();
//		phone1.setPhoneNumber("45345345");
//		phone1.setProvider("Idea");
//		phone1.setOwner(emp);
//		 
//		Phone phone2 = new Phone();
//		phone2.setPhoneNumber("6456456456");
//		phone2.setProvider("BSNL");
//		phone2.setOwner(emp);
//		 
//		List<Phone> phones = new ArrayList<Phone>();
//		phones.add(phone2);
//		phones.add(phone1);
//		 
//		emp.setPhones(phones);
//		em.persist(emp);
//		transaction.commit();
		
		transaction.begin();
		EmployeeId empId = new EmployeeId("Pune", 2);
		Employee1 emp = em.find(Employee1.class, empId);
		for(Phone p: emp.getPhones()) {
			System.out.println(p);
		}
		transaction.commit();
	}

}
