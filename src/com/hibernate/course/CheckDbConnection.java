package com.hibernate.course;

import java.sql.Connection;
import java.sql.DriverManager;


public class CheckDbConnection {

	public static void main(String[] args) {

		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_traker?useSSL=false";
		String user="hbstudent";
		String pass="hbstudent";
		
		try {
			System.out.println("Connecting to database :" + jdbcUrl);
			
			Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connecting Success !");
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
