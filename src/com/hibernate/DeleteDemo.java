package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.*;

public class DeleteDemo {

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

			int id = 1;
			//return null if not found
			Instructor ins = session.get(Instructor.class, id);
			System.out.println(" Found Instructor :" + ins);
			
			if( ins != null)
			{
				//will also delete details object because of CascadeType.ALL
				session.delete(ins); 
			}
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Transaction is Successfully Commited... \n");
			
			
		} finally {
			session.close();
			System.out.println(" Session is Closed !");
		}

	}

}
