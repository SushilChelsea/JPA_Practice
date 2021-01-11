package com.thejavageek.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.thejavageek.compoundPrimaryKey.EmbeddedEmployeeId;
import com.thejavageek.compoundPrimaryKey.EmployeeId;
import com.thejavageek.entities.Employee;

public class ClientClass {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAExample2");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		// using @IdClass
		/*transaction.begin();
		EmployeeId id = new EmployeeId("pune", 1);
		Employee emp = em.find(Employee.class, id);
		System.out.println("First name = " + emp.getFirstName() + " "
			+ "Last Name = " + emp.getLastName() + " " + "salary = "
			+ emp.getSalary());
		transaction.commit();
		System.out.println("==================================================");
		transaction.begin();
		emp = new Employee();
		emp.setIdEmployee(1);
		emp.setBranchName("banglore");
		emp.setFirstName("prasad");
		emp.setLastName("kharkar");
		em.persist(emp);
		transaction.commit();*/
		
		transaction.begin();
		EmbeddedEmployeeId id = new EmbeddedEmployeeId("pune", 1);
		Employee emp = em.find(Employee.class, id);
		System.out.println("First name = " + emp.getFirstName() + " "
			+ "Last Name = " + emp.getLastName() + " " + "salary = "
			+ emp.getSalary());
		transaction.commit();
		
	}

}
