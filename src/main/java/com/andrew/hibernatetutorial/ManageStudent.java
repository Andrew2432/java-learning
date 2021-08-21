package com.andrew.hibernatetutorial;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageStudent {

	private int addStudent(int id, String name, String rollNo, String grade) {
		Integer newStudentId = -1;
		Transaction transaction = null;
		Student student = null;

		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();

			student = new Student(id, name, rollNo, grade);

			newStudentId = (Integer) session.save(student);

			transaction.commit();

			return newStudentId;
		} catch (HibernateException hibernateException) {
			hibernateException.printStackTrace();
		}

		return newStudentId;
	}

	private void createStudents() {
		addStudent(1, "Andrew", "1001", "A");
		addStudent(2, "Joel", "1002", "B");
		addStudent(1, "Nishaanth", "1003", "C");
		addStudent(1, "Mohan", "1004", "D");
	}

	private void showStudents() {
		Transaction transaction = null;
		Iterator<Student> iterator = null;
		Student student = null;

		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();

			List<Student> students = session.createQuery("FROM Student", Student.class)
					.getResultList();

			iterator = students.iterator();

			while (iterator.hasNext()) {
				student = iterator.next();
				System.out.println("Name: " + student.getName());
				System.out.println("Roll No: " + student.getRollNo());
			}
			transaction.commit();
		} catch (HibernateException hibernateException) {
			hibernateException.printStackTrace();
		}
	}

	public void updateStudent(int id, String name, String rollNo, String grade) {
		Transaction transaction = null;
		Student student = null;

		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();

			student = session.get(Student.class, id);

			if (!(name.equals("")))
				student.setName(name);
			if (!(rollNo.equals("")))
				student.setRollNo(rollNo);
			if (!(grade.equals("")))
				student.setGrade(grade);

			transaction.commit();
		} catch (HibernateException hibernateException) {
			hibernateException.printStackTrace();
		}
	}

	public void deleteStudent(int id) {
		Transaction transaction = null;
		Student student = null;

		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();

			student = session.get(Student.class, id);

			session.delete(student);

			transaction.commit();
		} catch (HibernateException hibernateException) {
			hibernateException.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ManageStudent manageStudent = new ManageStudent();

//		manageStudent.createStudents();
//		manageStudent.updateStudent(1, "", "", "D");
//		manageStudent.deleteStudent(1);
		manageStudent.showStudents();
	}
}
