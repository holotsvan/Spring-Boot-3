package com.luv2code.democrud.dao;

import com.luv2code.democrud.entity.Instructor;
import com.luv2code.democrud.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    Instructor deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    InstructorDetail deleteInstructorDetailById(int id);

}