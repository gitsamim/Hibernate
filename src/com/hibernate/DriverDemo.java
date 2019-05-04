package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.Student;

public class DriverDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create a student object
			System.out.println("Creating new student object...");
			
			Student obj1 = new Student("Albert", "Einstein", "albert.einstein@hotmail.com");
			
			//start a transaction 
			session.beginTransaction();
			System.out.println("Transaction Started...");
			
			//save the student object
			session.save(obj1);
		
			System.out.println("Object is Saved...");
			
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
