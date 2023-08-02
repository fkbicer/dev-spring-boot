package com.example.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.cruddemo.entity.Course;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import com.example.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class AppDAOImpl implements AppDAO {

    // define field for entity manager

    private EntityManager entityManager;

    // inject entity manager using contr inj.

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(Instructor theInsturctor) {
        
        entityManager.persist(theInsturctor);

    }


    @Override
    public Instructor findInstructorById(int theId) {
            return entityManager.find(Instructor.class, theId);
    }


    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor tempInstructor = entityManager.find(Instructor.class,theId);
        // get the courses
        List<Course> courses = tempInstructor.getCourses();
        // break association
        for (Course tempCourse : courses ) {
            tempCourse.setInstructor(null);
        }
        entityManager.remove(tempInstructor);
    }


    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
     return entityManager.find(InstructorDetail.class, theId);
    }


    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class,theId);

        // remove associated object referemce
        // breake bi-directional link.
        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(tempInstructorDetail);
    }


    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        //create query
        TypedQuery<Course> query = 
                    entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data",theId);

        // execute query
        List<Course> courses = query.getResultList();

        return courses;

    }


    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
       TypedQuery<Instructor> query = entityManager.createQuery("SELECT i FROM Instructor i " + 
                                                                "JOIN FETCH i.courses " + 
                                                                "JOIN FETCH i.instructorDetail " + 
                                                                "WHERE i.id = :data", 
                                                                Instructor.class);
    
    query.setParameter("data",theId);

    Instructor instructor = query.getSingleResult();

    return instructor;
    }


    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }


    @Override
    @Transactional
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }


    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class,theId);
    }


    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        Course tempCourse = entityManager.find(Course.class, theId);
        entityManager.remove(tempCourse);
    }


    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }


    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery(
            "SELECT c FROM Course c " + "JOIN FETCH c.reviews " + "WHERE c.id = :data", Course.class);
        query.setParameter("data", theId);    

    Course course = query.getSingleResult();
    return course;
    }


    @Override
    public Course findCourseAndStudentsByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery(
            "SELECT c FROM Course c " + "JOIN FETCH c.students " + "WHERE c.id = :data", Course.class);
        query.setParameter("data", theId);  
        
    Course course = query.getSingleResult();
    return course;
    }


    @Override
    public Student findStudentAndCoursesByStudentId(int theId) {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s " + "JOIN FETCH s.courses " + "WHERE s.id = :data", Student.class);
        query.setParameter("data", theId);  
        
    Student student = query.getSingleResult();
    return student ;
    }


    @Override
    @Transactional
    public void update(Student tempStudent) {
        entityManager.merge(tempStudent);
    }


    @Override
    @Transactional
    public void deleteStudentById(int theId) {
        
        Student theStudent = entityManager.find(Student.class, theId);
        entityManager.remove(theStudent);

    }




    
    
}
