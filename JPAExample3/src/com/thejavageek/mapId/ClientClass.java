package com.thejavageek.mapId;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.thejavageek.embeded.DependentId;
import com.thejavageek.entities.Dependent;
import com.thejavageek.entities.Employee;

public class ClientClass {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAExample3");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Employee emp = new Employee();
		emp.setName("Prasad Kharkar");
		
		DependentId id1 = new DependentId();
		id1.setName("Sushant");
		
		DependentId id2 = new DependentId();
		id2.setName("reeya");
		
		Dependent dependent1 = new Dependent();
		dependent1.setId(id1);
		dependent1.setEmployee(emp);
		
		Dependent dependent2 = new Dependent();
		dependent2.setId(id2);
		dependent2.setEmployee(emp);
		
		em.persist(emp);
		em.persist(dependent1);
		em.persist(dependent2);
		txn.commit();
		em.close();
		emf.close();
	}

}
