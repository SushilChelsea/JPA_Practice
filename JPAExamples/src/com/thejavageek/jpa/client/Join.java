package com.thejavageek.jpa.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.thejavageek.jpa.entities.Employee;
import com.thejavageek.mapkeycolumn.Phone;

public class Join {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAExamples");
		EntityManager em = emf.createEntityManager();
		EntityTransaction trxn = em.getTransaction();
		
		/*
		List<Employee> lst;
		trxn.begin();
		lst = em.createQuery("SELECT e FROM Employee e JOIN e.phones p").getResultList();
		lst.forEach(System.out::println);
		trxn.commit();
		*/
		/*
		List<Phone> lst;
		trxn.begin();
		lst = em.createQuery("SELECT p FROM Employee e JOIN e.phones p WHERE e.firstname=:firstname").setParameter("firstname", "Ajay").getResultList();
		lst.forEach(p->System.out.println(p.getPhoneNumber()));
		trxn.commit();
		*/
		
		//Left Join
		List<Employee> lst;
		trxn.begin();
		lst = em.createQuery("SELECT e FROM Employee e Left JOIN e.department d").getResultList();
		lst.forEach(System.out::println);
		trxn.commit();
		
	}

}
