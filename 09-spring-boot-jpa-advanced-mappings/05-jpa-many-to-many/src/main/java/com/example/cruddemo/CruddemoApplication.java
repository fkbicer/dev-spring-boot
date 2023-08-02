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
import com.example.cruddemo.entity.Review;
import com.example.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {

			// createCourseAndStudents(appDAO);

			// findCourseAndStudents(appDAO);

			// findStudentAndCourses(appDAO);

			addMoreCoursesForStudent(appDAO);
		
		};
	}


	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int theId=2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		Course tempCourse1 = new Course("Fizik");
		Course tempCourse2 = new Course("Kimya");

		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);
		
		System.out.println("Saving student: " + tempStudent);
		System.out.println("associated courses:  " + tempStudent.getCourses());

		appDAO.update(tempStudent);

		System.out.println("Done!");
	}


	private void findStudentAndCourses(AppDAO appDAO) {
		int theId=2;
		Student tempStudent =  appDAO.findStudentAndCoursesByStudentId(theId);
		System.out.println("Loaded student: " + tempStudent);
		System.out.println("Students : " + tempStudent.getCourses());
		System.out.println("Done!");

	}


	private void findCourseAndStudents(AppDAO appDAO) {

		int theId=10;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);
		System.out.println("Loaded course: " + tempCourse);
		System.out.println("Students : " + tempCourse.getStudents());
		System.out.println("Done!");
	}


	private void createCourseAndStudents(AppDAO appDAO) {

		// create courses

		Course tempCourse = new Course("Matematik");

		// create students

		Student theStudent1 = new Student("furkan", "bicer","basda@asdad.co");
		Student theStudent2 = new Student("gulco", "cet","gc@gmail.co");
		
		// add students to courses

		tempCourse.addStudent(theStudent2);
		tempCourse.addStudent(theStudent1);

		// retrieve the data.

		System.out.println("Course name : " + tempCourse.getTitle() + " and students " + tempCourse.getStudents());

		appDAO.save(tempCourse);


		System.out.println("Done!");



	}


	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId=10;

		System.out.println("Deleting Course id: " + theId);

		appDAO.deleteCourseById(theId);
	}


	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int theId=10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		System.out.println("Done!");

	}


	private void createCourseAndReveiws(AppDAO appDAO) {

		// create a course
		Course tempCourse = new Course("Pacman - how to score one million");

		// add some reviews
		tempCourse.addReview(new Review("Greate course...loved it!"));
		tempCourse.addReview(new Review("not bad, should be improve..!"));
		tempCourse.addReview(new Review("Cool course, job well done!"));

		// save the course

		System.out.println("Saving the course...");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);



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
