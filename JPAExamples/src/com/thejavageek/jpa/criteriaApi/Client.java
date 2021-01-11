package com.thejavageek.jpa.criteriaApi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.thejavageek.jpa.entities.Employee;

public class Client {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAExamples");
		EntityManager em = emf.createEntityManager();
		EntityTransaction trxn = em.getTransaction();
		trxn.begin();
		/* JPQL
		Employee e = (Employee) em.createQuery("SELECT e FROM Employee e WHERE e.firstname=:firstname")
						.setParameter("firstname", "Ajay")
						.getSingleResult();
		System.out.println(e);				
		*/
		
		//CriteriaApi
		CriteriaBuilder cb = em.getCriteriaBuilder();
		/*
		CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
		Root<Employee> employee = query.from(Employee.class);
		query.select(employee).where(cb.equal(employee.get("firstname"), "Ajay"));
		TypedQuery<Employee> tq = em.createQuery(query);
		Employee e = tq.getSingleResult();
		System.out.println(e);	
		*/
		CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
		Root<Employee> employee = query.from(Employee.class);
		query.select(employee);
		List<Employee> lst = (List<Employee>) em.createQuery(query).getResultList();
		lst.forEach(System.out::println);
		trxn.commit();

	}

}
