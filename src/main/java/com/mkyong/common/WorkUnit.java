package com.mkyong.common;

import org.hibernate.Session;

public class WorkUnit {

	
	public static void perform(Session session) {
		session.beginTransaction();

		Employee em = new Employee();
		
		em.setDescription("this is the description of the employee");
		em.setJob("Developer");
		em.setLastName("Smith");
		em.setName("John");
		em.setSalary(10000);
		
		session.save(em);
		
		
		//Other slow process: (ethernet frame.., file reading,.. etc) 
		/*
		try {
			Thread.sleep(15);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		session.getTransaction().commit();
	}
	
}
