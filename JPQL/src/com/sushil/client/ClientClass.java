package com.sushil.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.sushil.entities.Employee;

public class ClientClass {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPQL");
		EntityManager em = emf.createEntityManager();
		EntityTransaction trxn = em.getTransaction();
		/*
		List<Employee> employees;
		trxn.begin();
		employees = em.createQuery("SELECT e FROM Employee e").getResultList();
		trxn.commit();
		employees.forEach(System.out::println);
		*/
		/*
		List<String> employeesName;
		trxn.begin();
		employeesName = em.createQuery("SELECT e.name FROM Employee e").getResultList();
		trxn.commit();
		employeesName.forEach(System.out::println);
		*/
		
		List<Integer> employeeIds;
		trxn.begin();
		employeeIds = em.createQuery("SELECT e.idemployee FROM Employee e").getResultList();
		trxn.commit();
		employeeIds.forEach(System.out::println);
	}
}
