package com.example.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cruddemo.dao.AppDAO;
import com.example.cruddemo.entity.Course;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
		
		};
	}


	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting course, id : " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}


	private void updateCourse(AppDAO appDAO) {
		int theId = 10;

		// find course first.
		System.out.println("Finding courses id : " + theId);

		Course tempCourse = appDAO.findCourseById(theId);

		tempCourse.setTitle("Personal football trainer - semi-pro.");
		appDAO.update(tempCourse);
		System.out.println("Done!");

	}


	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Finding instructor: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		tempInstructor.setFirstName("AliCabbar");

		appDAO.update(tempInstructor);
		System.out.println("Done!");

	}


	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId=1;

		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor " + tempInstructor);
		System.out.println("associated courses : " + tempInstructor.getCourses());

		System.out.println("Done!");
	}


	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id:" + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());
	}


	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId=1;
		System.out.println("Finding instructor id:" + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());
	}


	private void createInstructorWithCourses(AppDAO appDAO) {

			// create the instructor

		Instructor tempInstructor =
					new Instructor("Furkan", 
								"Maliki", 
								"fqfwqf@blabla.com");

		// create the instructor detail

		InstructorDetail tempInstructorDetail =
					new InstructorDetail("http://www.clacla.com/youtube",
							 			"coding is my hobby");

		
		// associate the objects

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("Air Guitar- The Ultimate Guide");
		Course tempCourse2 = new Course("Pin Ball - Master Class");
		Course tempCourse3 = new Course("Math");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		tempInstructor.add(tempCourse3);

		// save the instructor.
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses : " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Done!");

	}


	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId=4;
		System.out.println("Id:4 is deleting...");
		appDAO.deleteInstructorDetailById(4);
		System.out.println("Done!");


	}


	private void findInstructorDetail(AppDAO appDAO) {
			int theId = 2;
			InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

			System.out.println("tempInstructorDetail: " + tempInstructorDetail);

			System.out.println("the associated Instructor: " + tempInstructorDetail.getInstructor());

			System.out.println("done!");

	}


	private void deleteInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);
		System.out.println("done!");

	}


	private void findInstructorById(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associate instructorDetail only" + tempInstructor.getInstructorDetail());

	}


	public void createInstructor(AppDAO appDAO) {

		// create the instructor

		Instructor tempInstructor =
					new Instructor("Chad","Darby", "darby@blabla.com");

		// create the instructor detail

		InstructorDetail tempInstructorDetail =
					new InstructorDetail("http://www.clacla.com/youtube", "coding is my hobby");

		
		// associate the objects

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor.
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);


					

	}



}
