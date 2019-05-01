package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.Student;

public class ReadDriver {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create a student object
			
			System.out.println("Creating new student object...");
			
			Student obj1 = new Student("Laray", "Page", "laray.page@google.com");
			
			//start a transaction 
			
			session.beginTransaction();
			System.out.println("Transaction Started...");
			
			//save the student object
			
			System.out.println(obj1);
			session.save(obj1);
		
			System.out.println("Object is Saved...");		
			
			//commit transaction
			
			session.getTransaction().commit();
			System.out.println("Transaction is Successfully Commited... \n");
			System.out.println(" Done !");
			
			//Code for select object
			
			//find the primary key
			
			System.out.println("Saved student Id is : " + obj1.getId());
			
			//now get a session and start transaction
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retieve student based on the primary key
			System.out.println("\n Getting  student Id is : " + obj1.getId());
			Student s = session.get(Student.class, obj1.getId());
			System.out.println("Get Student is :" + s);
			
			session.getTransaction().commit();
			
			//commit the transaction
			
		} finally {
			session.close();
			System.out.println(" Session is Closed !");
		}

	}

}
