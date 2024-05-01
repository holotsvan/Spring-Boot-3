package com.luv2code.democrud.dao;

import com.luv2code.democrud.entity.Course;
import com.luv2code.democrud.entity.Instructor;
import com.luv2code.democrud.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

//    Instructor deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    Course findCourseById(int id);

    InstructorDetail deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course courses);

    void deleteInstructorById(int id);

    void deleteCourseById(int id);

    void save(Course course);

    Course findcourseAndReviewsByCourseId(int id);
}