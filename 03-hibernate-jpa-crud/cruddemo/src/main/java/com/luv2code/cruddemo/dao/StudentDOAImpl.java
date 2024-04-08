package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDOAImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    StudentDOAImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> getAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        List<Student> students = theQuery.getResultList();
        return students;
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName =:theLastName", Student.class);

        theQuery.setParameter("theLastName", theLastName);
        List<Student> students = theQuery.getResultList();
        return students;
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class, id);

        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public void deleteAll() {
        entityManager.createQuery("Delete from Student").executeUpdate();
    }
}
