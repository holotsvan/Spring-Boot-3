package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
    CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {

//			createStudent(studentDAO);
          createMultipleStudents(studentDAO);
//          readStudent(studentDAO);
//          queryForStudents(studentDAO);
//          queryByLastName(studentDAO,"Duck");
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAllStudents(studentDAO);
        };
    }
    private void deleteAllStudents(StudentDAO studentDAO){
        System.out.println("Deleting all students from db");
        studentDAO.deleteAll();
    }
    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 1;
        System.out.println("Deleting student with id: "+ studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);

        Student myStudent = studentDAO.findById(studentId);

        System.out.println("Updating student...");

        myStudent.setFirstName("Scooby");
        studentDAO.update(myStudent);

        System.out.println("Updated student: " + myStudent);
    }


    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating 3 new student objects ...");
        // create the student objects
        Student student1 = new Student("Jack", "Doe", "jackdoe@gmail.com");
        Student student2 = new Student("Jimmy", "Doe", "jimmydoe@gmail.com");
        Student student3 = new Student("Tom", "Doe", "tomdoe@gmail.com");
        // save the student objects
        System.out.println("Saving the students ...");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
        // display id of the saved students
        System.out.println("Saved student1. Generated id: " + student1.getId());
        System.out.println("Saved student2. Generated id: " + student2.getId());
        System.out.println("Saved student3. Generated id: " + student3.getId());
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object ...");
        // create the student object
        Student student = new Student("Bonita", "Applebum", "jhondoe@gmail.com");
        // save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(student);
        // display id of the saved student
        System.out.println("Saved student. Generated id: " + student.getId());
    }

    private void readStudent(StudentDAO studentDAO) {
        //create a student object
        System.out.println("Creating new studentobject...");

        Student tempStudent = new Student("Daffy", "Duck", "daffyduck@gmail.com");

        // save the student object
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());

        // display student
        Student myStudent = studentDAO.findById(tempStudent.getId());

        System.out.println("Found the student: " + myStudent);
    }

    private void queryForStudents(StudentDAO studentDAO) {
        studentDAO.getAll().forEach(System.out::println);
    }

    private void queryByLastName(StudentDAO studentDAO, String doe) {
        studentDAO.findByLastName(doe).forEach(System.out::println);
    }

}
