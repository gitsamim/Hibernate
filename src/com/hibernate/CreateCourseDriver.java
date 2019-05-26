package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.*;

public class CreateCourseDriver {

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
			System.out.println(" Begin Transaction ...");
			
			//get the instruction from DB
			
			// create the Courses
			
			// add courses to instructor
			
			// save the Courses
			
			int insId = 4;
			Instructor instructor = session.get(Instructor.class, insId);
			
			Course course1 = new Course("Geography");
			Course course2 = new Course("History");
			
			instructor.add(course1);
			instructor.add(course2);
			
			session.save(course1);
			session.save(course2);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Transaction is Successfully Commited... \n");
			System.out.println(" Done !");
			
		} finally {
			session.close();
			factory.close();
			System.out.println(" Session is Closed !");
		}

	}

}
