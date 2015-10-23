package com.ro.controller.api;

import com.ro.persistence.model.Student;
import com.ro.persistence.repositories.StudentRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ivan on 23.10.15..
 */
@RestController
@RequestMapping(value = "/api/resources/students")
public class StudentRestController {

    private static final Logger logger = Logger.getLogger(StudentRestController.class);

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value = "")
    public List<Student> getAllStudents(@RequestParam(required = false, value = "ime") String ime) {
        if (ime != null) {
            if (logger.isDebugEnabled()) {
                logger.debug(ime);
            }
            return studentRepository.findByIme(ime);
        } else {
            return studentRepository.findAll();
        }
    }


}
