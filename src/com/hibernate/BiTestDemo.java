package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.*;

public class BiTestDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
		
			session.beginTransaction();
			System.out.println("Transaction Started...");

			int insDetail = 20;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, insDetail);
			System.out.println("InstructorDetail :" + instructorDetail);
			System.out.println("InstructorDetail :" + instructorDetail.getInstructor());
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Transaction is Successfully Commited... \n");
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			System.out.println(" Session is Closed !");
		}

	}

}
