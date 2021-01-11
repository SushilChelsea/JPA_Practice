package com.thejavageek.jpa.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.thejavageek.jpa.entities.Department;
import com.thejavageek.jpa.entities.Employee;

public class MainJPQL {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAExamples");
		EntityManager em = emf.createEntityManager();
		EntityTransaction trxn = em.getTransaction();
		
		List<Employee> lst;
		trxn.begin();
		//lst = em.createQuery("SELECT d.employees FROM Department d ORDER BY d.iddepartment DESC").getResultList();
		//lst = em.createQuery("SELECT e FROM Employee e WHERE e.department IS NULL").getResultList();
		Department d = em.find(Department.class, 7);
		//lst = em.createQuery("SELECT e FROM Employee e WHERE e.department=?1").setParameter(1, d).getResultList();
		lst = em.createQuery("SELECT e FROM Employee e WHERE e.department=:dept").setParameter("dept", d).getResultList();
		trxn.commit();
		lst.forEach(System.out::println);
	}
}
