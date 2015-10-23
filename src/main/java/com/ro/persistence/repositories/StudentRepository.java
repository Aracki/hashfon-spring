package com.ro.persistence.repositories;

import com.ro.persistence.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ivan on 23.10.15..
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByIme(String ime);
}
