package com.thejavageek.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.thejavageek.entities.Bike;
import com.thejavageek.entities.Car;
import com.thejavageek.entities.Manufacturer;
import com.thejavageek.entities.Truck;

public class Main {

	public static void main(String[] args) {
		/* Create EntityManagerFactory */
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("entity-inheritance");
		
		/* Create EntityManager */
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		/*
		txn.begin();
		Manufacturer m1 = new Manufacturer();
		m1.setId(1);
		m1.setName("honda");
		em.persist(m1);
		txn.commit();
		txn.begin();
		Bike cbr1000rr = new Bike();
		cbr1000rr.setManufacturer(m1);
		cbr1000rr.setNoOfpassengers(1);
		cbr1000rr.setSaddleHeight(30);
		em.persist(cbr1000rr);
		txn.commit();
		txn.begin();
		 
		Manufacturer m2 = new Manufacturer();
		m2.setId(2);
		m2.setName("lamborghini");
		em.persist(m2);
		txn.commit();
		txn.begin();
		Car avantador = new Car();
		avantador.setManufacturer(m2);
		avantador.setNoOfDoors(2);
		avantador.setNoOfpassengers(2);
		em.persist(avantador);
		txn.commit();
		txn.begin();
		 
		Manufacturer m3 = new Manufacturer();
		m3.setId(2);
		m3.setName("mercedes");
		em.persist(m3);
		txn.commit();
		txn.begin();
		Truck truck = new Truck();
		truck.setLoadCapacity(100);
		truck.setManufacturer(m3);
		truck.setNoOfContainers(2);
		em.persist(truck);
		txn.commit();
		*/
		
		Manufacturer m11 = em.find(Manufacturer.class, 1);
		//System.out.println(m11.getBike());
		// createQuery example
		/*
		Bike b1 = (Bike) em.createQuery("SELECT b FROM Bike b WHERE b.manufacturer=:manufacturer")
				.setParameter("manufacturer", m11)
				.getSingleResult();
		*/
		
		// createNamedQuery example
		/*
		Bike b1 = (Bike) em.createNamedQuery("Bike.findBikeByManufacturer")
				.setParameter("manufacturer", m11)
				.getSingleResult();
		*/
		/*
		Bike b1 = (Bike) em.createNativeQuery("select * from bike b where b.manufacturer_id=?1", Bike.class)
				.setParameter(1, 1).getSingleResult();
		*/

		Bike b1 = (Bike) em.createNativeQuery(Bike.FIND_BY_MANUFACTURER_Native_SQL, Bike.class)
				.setParameter(1, 1).getSingleResult();
		System.out.println(b1);
		
//		List<Bike> lst = em.createNativeQuery(Bike.FIND_ALL).getResultList();
//		System.out.println(lst);
		
		emf.close();

	}

}
