package com.thejavageek.jpa.client;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.thejavageek.jpa.entities.Department;
import com.thejavageek.jpa.entities.Employee;

public class OneToManyClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAExamples");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		Employee employee1 = new Employee();
		employee1.setFirstname("pranil");
		employee1.setLastname("gilda");
		employee1.setEmail("sdfsdf");

		Employee employee2 = new Employee();
		employee2.setFirstname("prasad");
		employee2.setLastname("kharkar");
		employee2.setEmail("dfgfdg");

		em.persist(employee2);
		em.persist(employee1);
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee1);
		employees.add(employee2);

		Department department1 = new Department();
		department1.setName("IT");
		department1.setEmployees(employees);

		//employee1.setDepartment(department1);

		for(Employee e: employees) {
			e.setDepartment(department1);
		}
		em.persist(department1);
		transaction.commit();

		transaction.begin();
		int employeeID = employee1.getIdEmployee();
		int departmentid = department1.getIddepartment();
		System.out.println(employee1);
		System.out.println(department1);
		
		Employee employee = em.find(Employee.class, employeeID);
		System.out.println(employee.getDepartment());

		Department department = em.find(Department.class, departmentid);
		System.out.println(department.getEmployees());

		transaction.commit();
	}

}
