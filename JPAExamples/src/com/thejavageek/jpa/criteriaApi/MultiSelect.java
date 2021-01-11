package com.thejavageek.jpa.criteriaApi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.thejavageek.jpa.entities.Employee;

public class MultiSelect {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAExamples");
		EntityManager em = emf.createEntityManager();
		EntityTransaction trxn = em.getTransaction();
		trxn.begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
		Root<Employee> employee = query.from(Employee.class);
		query.multiselect(employee.get("firstname"), employee.get("lastname"));
		List<Object[]> results = em.createQuery(query).getResultList();
		 
		for (Object[] info : results) {
			System.out.println("First name = " + info[0] + " "
				+ "Last Name = " + info[1]);
		}
		trxn.commit();

	}

}
