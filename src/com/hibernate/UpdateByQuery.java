package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.Student;

public class UpdateByQuery {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int stuId = 3;
			//start a transaction 
			session.beginTransaction();
			System.out.println("Transaction Started...");

			Student stu = session.get(Student.class, stuId);
			System.out.println("Updating the student...");
			stu.setFirstName("Bikash"); 
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Transaction is Successfully Commited... \n");
			
			//QUERY FOR UPDATE
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student s set firstName='Vikash' where s.lastName='Raj'").executeUpdate();
			
			
			//commit transaction
			session.getTransaction().commit();
		
			
		} finally {
			session.close();
			System.out.println(" Session is Closed !");
		}
	}

}
