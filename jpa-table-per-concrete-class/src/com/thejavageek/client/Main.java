package com.thejavageek.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.thejavageek.entities.Bike;
import com.thejavageek.entities.Car;
import com.thejavageek.entities.Truck;

public class Main {

	public static void main(String[] args) {
		/* Create EntityManagerFactory */
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("entity-inheritance");
		
		/* Create EntityManager */
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		
		txn.begin();
		Bike cbr1000rr = new Bike();
		cbr1000rr.setManufacturer("honda");
		cbr1000rr.setNoOfpassengers(1);
		cbr1000rr.setSaddleHeight(30);
		em.persist(cbr1000rr);
		 
		Car avantador = new Car();
		avantador.setManufacturer("lamborghini");
		avantador.setNoOfDoors(2);
		avantador.setNoOfpassengers(2);
		em.persist(avantador);
		 
		Truck truck = new Truck();
		truck.setLoadCapacity(100);
		truck.setManufacturer("mercedes");
		truck.setNoOfContainers(2);
		em.persist(truck);
		
		Car volkswagen = new Car();
		volkswagen.setManufacturer("VolksWagen");
		volkswagen.setNoOfDoors(4);
		volkswagen.setNoOfpassengers(4);
		em.persist(volkswagen);
		
		txn.commit();
		
		/*
		Bike b1 = em.find(Bike.class, 1);
		System.out.println(b1.getNoOfpassengers());
		
		Car c1 = em.find(Car.class, 2);
		System.out.println(c1.getNoOfpassengers());
		*/
		emf.close();

	}

}
