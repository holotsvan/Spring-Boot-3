package com.luv2code.democrud;

import com.luv2code.democrud.dao.AppDAO;
import com.luv2code.democrud.entity.Instructor;
import com.luv2code.democrud.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> deleteInstructor(appDAO);
    }

    private void createInstructor(AppDAO appDAO) {


        // create the instructor
        Instructor tempInstructor =
                new Instructor("Chad", "Darby", "darby@luv2code.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://www.luv2code.com/youtube",
                        "Luv 2 code!!!");


//        Instructor tempInstructor =
//                new Instructor("Madhu", "Patel", "madhu@luv2code.com");
//
//        InstructorDetail tempInstructorDetail =
//                new InstructorDetail(
//                        "http://www.luv2code.com/youtube",
//                        "Guitar");

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

    private void deleteInstructor(AppDAO appDAO) {
        int id = 2;
        System.out.println("Deleting instructor with id: " + id);

        Instructor instructor = appDAO.deleteInstructorById(id);

        System.out.println("Instructor:\n" + instructor + "\nwas deleted");
    }
}
