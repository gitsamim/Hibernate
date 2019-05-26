package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.*;

public class DeleteCourseDriver {

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
					
			// get a course from DB
			int courseId = 2;
			Course course = session.get(Course.class, courseId);
			
			System.out.println("Deleteing the : \n" + course);
			session.delete(course);
			
			// delete the course

			
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
