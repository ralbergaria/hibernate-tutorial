package com.lov2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lov2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student student = new Student("Daffy", "Duck", "Daffy@luv2code.com");
			System.out.println(student);
			// save the student
			System.out.println("Saving student object");
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Save student. genarate id: " + student.getId());
			System.out.println("Done!!");
			
			// now get a new session transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			// retrive student based on
			System.out.println("\nGetting student with id: " + student.getId());
			
			Student myStudent = session.get(Student.class, student.getId());
			// commit transaction
			session.getTransaction().commit();
					
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		
	}

}
