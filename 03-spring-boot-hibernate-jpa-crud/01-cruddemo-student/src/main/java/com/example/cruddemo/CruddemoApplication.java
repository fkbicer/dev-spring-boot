package com.example.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			// createStudent(studentDAO);
			createMultipleStudent(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// dateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
		};
		
			

	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all Students...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted students quantity = " + numRowsDeleted);
		
	}
	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 1;
		System.out.println("Deleting student ID : " + studentId);
		studentDAO.delete(studentId);

	}
	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: PK

		Student theStudent = studentDAO.findById(1);
		System.out.println("Selected student:\n" + theStudent);

		// change first name to "Scooby"
		System.out.println("Updating student...");
		theStudent.setFirstName("Karaca");

		// update the student
		studentDAO.update(theStudent);

		// display the updated student
		System.out.println("Updated student :\n " + theStudent);


	}
	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List <Student> theStudents = studentDAO.findByLastName("Duck");
		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println("-------------------------");
			System.out.println(tempStudent);
		}

	}
	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List <Student> theStudents = studentDAO.findAll();
		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println("-------------------------");
			System.out.println(tempStudent);
		}

	}
	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Daffy", "Duck", "duckkymail@blabla.com");

		// save the student
		System.out.println("Saving the student.");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: PK.
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent );

	}
	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "fq@gmail.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

	}
	private void createMultipleStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new students object...");
		Student tempStudent1 = new Student("Paul", "Doe", "fq@gmail.com");
		Student tempStudent2 = new Student("Paul", "Doe", "fq@gmail.com");
		Student tempStudent3 = new Student("Paul", "Doe", "fq@gmail.com");
		Student tempStudent4 = new Student("Paul", "Doe", "fq@gmail.com");

		// save the student object
		System.out.println("Saving students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent1.getId());
		System.out.println("Saved student. Generated id: " + tempStudent2.getId());
		System.out.println("Saved student. Generated id: " + tempStudent3.getId());
		System.out.println("Saved student. Generated id: " + tempStudent4.getId());


	}
}
