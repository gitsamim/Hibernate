package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.Student;

public class ReadByQuery {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//start a transaction 
			session.beginTransaction();
			System.out.println("Transaction Started...");
			
			//query the student with Java property name not db column name 
			List<Student> stuList = session.createQuery("from Student").getResultList();
			
			//Display the student
				showStudents(stuList);
			
		//Query with condition
				stuList = session.createQuery(" from Student s where s.firstName like '%Sa%' ").getResultList();	
				//Display the student
				showStudents(stuList);
				
			//commit transaction			
			session.getTransaction().commit();
			System.out.println("Transaction is Successfully Commited... \n");

			
		} finally {
			session.close();
			System.out.println(" Session is Closed !");
		}

	}

	private static void showStudents(List<Student> stuList) {
		for(Student s : stuList)
		{
			System.out.println(s + "\n");
		}

	}

}
