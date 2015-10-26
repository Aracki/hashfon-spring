package com.ro.controller.api;

import com.ro.persistence.model.Student;
import com.ro.persistence.repositories.StudentRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by ivan on 23.10.15..
 */
@RestController
@RequestMapping(value = "/api/resources/student")
public class StudentRestController {

    private static final Logger logger = Logger.getLogger(StudentRestController.class);

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value = "")
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @RequestMapping(value = "/search/getById")
    public Student getById(@RequestParam Long id) {
        return studentRepository.findOne(id);
    }

    @RequestMapping(value = "/search/getByIme")
    public List<Student> getByIme(@RequestParam String ime) {
        return studentRepository.findByIme(ime);
    }

    @RequestMapping(value = "/search/getByPrezime")
    public List<Student> getByPrezime(@RequestParam String prezime) {
        return studentRepository.findByPrezime(prezime);
    }

//    @RequestMapping(value = "/{password}")
//    public List<Student> getByPassword(@PathVariable String password) {
//        return studentRepository.findByPassword(password);
//    }

    @RequestMapping(value = "/search/getByTelefon")
    public Student getByTelefon(@RequestParam String telefon) {
        return studentRepository.findByTelefon(telefon);
    }

    @RequestMapping(value = "/search/getByEmail")
    public Student getByEmail(@RequestParam String email) {
        return studentRepository.findByEmail(email);
    }

    @RequestMapping(value = "/search/getByAdresa")
    public Student getByAdresa(@RequestParam String adresa) {
        return studentRepository.findByAdresa(adresa);
    }

    @RequestMapping(value = "/search/getByToken")
    public Student getByToken(@RequestParam String token) {
        return studentRepository.findByToken(token);
    }

    @RequestMapping(value = "/search/getByDatumRodjenja")
    public List<Student> getByDatumRodjenja(@RequestParam Date datumRodjenja) {
        return studentRepository.findByDatumRodjenja(datumRodjenja);
    }

    @RequestMapping(value = "/search/getByGodinaDiplomiranja")
    public List<Student> getByGodinaDiplomiranja(@RequestParam Integer godinaDiplomiranja) {
        return studentRepository.findByGodinaDiplomiranja(godinaDiplomiranja);
    }

}
