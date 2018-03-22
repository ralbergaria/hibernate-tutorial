package com.lov2code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lov2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create ssession factory
		try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory()) {
			// create session
			Session session = factory.getCurrentSession();

			// begin transaction
			session.beginTransaction();

			// Query students
			List<Student> listStudents = session.createQuery("from Student").list();
			// Display the students
			displayStudents(listStudents);

			// Query students
			listStudents = session.createQuery("from Student s where s.lastName='Doe'").list();
			// Display the students
			System.out.println("Dislay students have last name Doe");
			displayStudents(listStudents);

			// Query students
			listStudents = session.createQuery("from Student s where s.lastName='Doe' or s.firstName='Daffy'").list();
			// Display the students
			System.out.println("Dislay students have last name Doe or Daffy");
			displayStudents(listStudents);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!!");

		} catch (Exception e) {
			e.printStackTrace();
		} 



	}

	private static void displayStudents(List<Student> listStudents) {
		for(Student student : listStudents) {
			System.out.println(student);
		}
	}

}
