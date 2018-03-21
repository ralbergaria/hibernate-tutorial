package com.lov2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lov2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create ssession factory
		try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory()) {
			// create session
			Session session = factory.getCurrentSession();
			
			// begin transaction
			session.beginTransaction();
			
			// create a student object
			System.out.println("Creatig student object");
			Student student = new Student("Paul", "Wall", "paul@luv2code.com");
			
			// save the student
			System.out.println("Saving student object");
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		
	}

}
