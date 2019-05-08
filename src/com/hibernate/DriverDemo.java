package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.Student;
import com.hibernate.entity.*;

public class DriverDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor instructor = new Instructor("Lary", "Page", "lary.page@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("http://www.google/youtube", "Coding !!!");
			
			instructor.setInstructorDetail(instructorDetail); 
			//start a transaction 
			session.beginTransaction();
			System.out.println("Transaction Started...");
			
			session.save(instructor);
		
			System.out.println("Object is Saved..." + instructor);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Transaction is Successfully Commited... \n");
			System.out.println(" Done !");
			
		} finally {
			session.close();
			System.out.println(" Session is Closed !");
		}

	}

}
