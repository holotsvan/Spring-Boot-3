package com.luv2code.democrud.dao;

import com.luv2code.democrud.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    Instructor deleteInstructorById(int id);

}