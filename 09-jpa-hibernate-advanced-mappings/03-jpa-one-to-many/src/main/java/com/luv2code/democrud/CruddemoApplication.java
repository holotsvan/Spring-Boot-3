package com.luv2code.democrud;

import com.luv2code.democrud.dao.AppDAO;
import com.luv2code.democrud.entity.Course;
import com.luv2code.democrud.entity.Instructor;
import com.luv2code.democrud.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> updateInstructor(appDAO);
    }

    private void createInstructor(AppDAO appDAO) {


//        // create the instructor
//        Instructor tempInstructor =
//                new Instructor("Chad", "Darby", "darby@luv2code.com");
//
//        // create the instructor detail
//        InstructorDetail tempInstructorDetail =
//                new InstructorDetail(
//                        "http://www.luv2code.com/youtube",
//                        "Luv 2 code!!!");
//

        Instructor tempInstructor =
                new Instructor("Madhu", "Patel", "madhu@luv2code.com");

        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://www.luv2code.com/youtube",
                        "Guitar");

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

    private void findInstuctor(AppDAO appDAO) {
        int id = 2;
        System.out.println("Finding instructor with id: " + id);
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println(instructor);
    }
//
//    private void deleteInstructor(AppDAO appDAO) {
//        int id = 2;
//        System.out.println("Deleting instructor with id: " + id);
//
//        Instructor instructor = appDAO.deleteInstructorById(id);
//
//        System.out.println("Instructor:\n" + instructor + "\nwas deleted");
//    }

    private void findInstructorDeteil(AppDAO appDAO) {
        int id = 3;
        System.out.println("Finding instructor detail with id: " + id);
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
        System.out.println(instructorDetail);
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int id = 3;
        System.out.println("Deleting instructor detail with id: " + id);

        InstructorDetail instructorDetail = appDAO.deleteInstructorDetailById(id);

        System.out.println("Instructor detail:\n" + instructorDetail + "\nwas deleted");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {

        Instructor tempInstructor =
                new Instructor("Mary", "Public", "mary@gmail.com");

        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://www.youtube.com",
                        "Guitar");

        tempInstructor.setInstructorDetail(tempInstructorDetail);
        tempInstructor.add(new Course("Java Core"));
        tempInstructor.add(new Course("JavaScript"));

        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor with id: " + id);
        Instructor instructor = appDAO.findInstructorById(id);

        System.out.println("Instructor:" + instructor);
        System.out.println("Associated courses:" + instructor.getCourses());
        System.out.println("Done.");
    }

    private void findCoursesByInstructorId(AppDAO appDAO) {
        int id = 1;

        Instructor instructor = appDAO.findInstructorById(id);

        System.out.println("Instructor: " + instructor);

        List<Course> courseList = appDAO.findCoursesByInstructorId(id);
        instructor.setCourses(courseList);

        System.out.println("Associated courses: " + instructor.getCourses());

    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int id = 1;
        System.out.println("Find instructor id: " + id);
        Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
        System.out.println(instructor);
        System.out.println(instructor.getCourses());
        System.out.println("done");
    }

    private void updateInstructor(AppDAO appDAO) {
        int id = 1;

        System.out.println("Finding instructor with id " + id);

        Instructor instructor = appDAO.findInstructorById(id);

        instructor.setLastName("TESTER");

        appDAO.update(instructor);

        System.out.println("Done");

    }

    private void updateCourse(AppDAO appDAO) {
        int id = 10;

        System.out.println("finding instructor with id " + id);

        Course course = appDAO.findCourseById(id);

        course.setTitle("Golang");

        appDAO.update(course);

        System.out.println("Done");
    }

    private void deleteInstructorById(AppDAO appDAO) {
        int id = 1;
        System.out.println("Deleting instructor with id " + id);

        appDAO.deleteInstructorById(id);
        System.out.println("deleted");
    }

    private void deleteCourseById(AppDAO appDAO) {
        int id = 10;
        System.out.println("Deleting course with id " + id);
        appDAO.deleteCourseById(id);
        System.out.println("deleted");
    }
}
