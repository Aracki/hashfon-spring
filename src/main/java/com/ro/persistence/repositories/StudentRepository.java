package com.ro.persistence.repositories;

import com.ro.persistence.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by ivan on 23.10.15..
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByIme(String ime);
    Student findById(Long id);
    List<Student> findByPrezime(String prezime);
    List<Student> findByPassword(String password);
    Student findByTelefon(String telefon);
    Student findByEmail(String email);
    Student findByAdresa(String adresa);
    List<Student> findByDatumRodjenja(Date datumRodjenja);
    Student findByToken(String token);
    List<Student> findByGodinaDiplomiranja(Integer godinaDiplomiranja);

    //za pretragu studenta po snippet tagovima
    @Query("SELECT DISTINCT s FROM Snippet sp JOIN sp.student s WHERE sp.hash.tag = :search")
    List<Student> findBySnippetTag(@Param("search") String search);
}
