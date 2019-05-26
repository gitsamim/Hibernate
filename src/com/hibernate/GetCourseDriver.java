package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.*;

public class GetCourseDriver {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction 
			session.beginTransaction();
			System.out.println(" Begin Transaction ... \n");
					
			int insId = 4;
			Instructor instructor = session.get(Instructor.class, insId);
			System.out.println("Instructor : \n" + instructor);
			System.out.println("\n");

			System.out.println("Courses : \n" + instructor.getCourese());
			System.out.println("\n");
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Transaction is Successfully Commited... \n");
			System.out.println(" Done ! \n");
			
		} finally {
			session.close();
			factory.close();
			System.out.println(" Session is Closed ! \n");
		}

	}

}
