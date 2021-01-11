package com.thejavageek.embeddable.elementCollection;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.thejavageek.embeddable.Address;
import com.thejavageek.embeddable.Student;

public class ClientClass {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAExamples");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		Student student = em.find(Student.class, 2);
		Address address = student.getAddress();
		
		
		Student s1 = new Student();
		s1.setName("Sugam");
		s1.setAddress(address);
		
		Course java = new Course();
		java.setCoursename("java standard edition");
		java.setDescription("Some description about java");
 
		Course jpa = new Course();
		jpa.setCoursename("jpa");
		jpa.setDescription("some description about jpa");
 
		Set<Course> courses = s1.getCourses();
		courses.add(java);
		courses.add(jpa);
		
		s1.setCourses(courses);
		em.persist(s1);
		transaction.commit();

	}

}
