package com.springcourse.JPAHibernateAdvancedMapping.DAO;

import com.springcourse.JPAHibernateAdvancedMapping.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
