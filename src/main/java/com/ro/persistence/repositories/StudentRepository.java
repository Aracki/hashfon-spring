package com.ro.persistence.repositories;

import com.ro.persistence.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ivan on 23.10.15..
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

}
