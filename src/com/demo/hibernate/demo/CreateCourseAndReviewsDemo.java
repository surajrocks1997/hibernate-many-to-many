package com.demo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.demo.entity.Course;
import com.demo.hibernate.demo.entity.Instructor;
import com.demo.hibernate.demo.entity.InstructorDetail;
import com.demo.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Course tempCourse = new Course("Pacman - Scoring 1M points");
			tempCourse.addReview(new Review("Great"));
			tempCourse.addReview(new Review("Wow"));
			tempCourse.addReview(new Review("Excellent"));
			
			session.save(tempCourse);

			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
