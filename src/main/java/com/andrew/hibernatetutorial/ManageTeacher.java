package com.andrew.hibernatetutorial;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageTeacher {
	private SessionFactory sessionFactory = null;

	public ManageTeacher() {
		try {
			sessionFactory = new Configuration().configure().addAnnotatedClass(TeacherEntity.class)
					.buildSessionFactory();
		} catch (HibernateException hibernateException) {
			hibernateException.printStackTrace();
		}

	}

	private int addTeacher(int id, String name, String grade, String subject) {
		Integer newTeacherId = -1;
		Transaction transaction = null;
		TeacherEntity teacher = null;

		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();

			teacher = new TeacherEntity(id, name, grade, subject);

			newTeacherId = (Integer) session.save(teacher);

			transaction.commit();
		} catch (HibernateException hibernateException) {
			hibernateException.printStackTrace();
		}

		return newTeacherId;
	}

	private void createTeachers() {
		addTeacher(1, "John", "A", "English");
		addTeacher(2, "Smith", "B", "Science");
		addTeacher(3, "Doe", "C", "Maths");
	}

	private void showTeachers() {
		Transaction transaction = null;
		Iterator<TeacherEntity> iterator = null;
		TeacherEntity teacher = null;

		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();

			List<TeacherEntity> teachers = session
					.createQuery("FROM TeacherEntity", TeacherEntity.class).getResultList();

			iterator = teachers.iterator();

			while (iterator.hasNext()) {
				teacher = iterator.next();
				System.out.println("Name: " + teacher.getName());
				System.out.println("Roll No: " + teacher.getSubject());
			}
			transaction.commit();
		} catch (HibernateException hibernateException) {
			hibernateException.printStackTrace();
		}
	}

	public void updateTeacher(int id, String name, String grade, String subject) {
		Transaction transaction = null;
		TeacherEntity teacher = null;

		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();

			teacher = session.get(TeacherEntity.class, id);

			if (!(name.equals("")))
				teacher.setName(name);
			if (!(grade.equals("")))
				teacher.setGrade(grade);
			if (!(subject.equals("")))
				teacher.setSubject(subject);

			transaction.commit();
		} catch (HibernateException hibernateException) {
			hibernateException.printStackTrace();
		}
	}

	public void deleteTeacher(int id) {
		Transaction transaction = null;
		TeacherEntity teacher = null;

		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();

			teacher = session.get(TeacherEntity.class, id);

			session.delete(teacher);

			transaction.commit();
		} catch (HibernateException hibernateException) {
			hibernateException.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ManageTeacher manageTeacher = new ManageTeacher();

//		manageTeacher.createTeachers();
		manageTeacher.showTeachers();
	}

}
