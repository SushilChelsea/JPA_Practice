package com.thejavageek.jpa.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GroupBy {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAExamples");
		EntityManager em = emf.createEntityManager();
		EntityTransaction trxn = em.getTransaction();
		trxn.begin();
		List<Object[]> lst = 
				em.createQuery("SELECT d.name, count(e) FROM Department d JOIN d.employees e GROUP BY d.name")
				.getResultList();
		System.out.println("Department" + "\t\t\t\tCount");
		for(int i=0; i<lst.size(); i++) {
			Object[] obj= lst.get(i);
			for(Object o: obj) {
				System.out.print(o + "\t\t\t\t");
			}
			System.out.println();
		}
		trxn.commit();

	}

}
