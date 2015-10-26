package com.ro.persistence.repositories;

import com.ro.persistence.model.Snippet;
import com.ro.persistence.model.SnippetPk;
import com.ro.persistence.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by ognjen on 23.10.15..
 */
public interface SnippetRepository extends JpaRepository<Snippet, SnippetPk> {

    @Query("SELECT s FROM Snippet s WHERE s.snippetPk.idStudent = :idStudent")
    Snippet findByIdStudent(Long idStudent);

    @Query("SELECT s FROM Snippet s WHERE s.snippetPk.id = :id")
    Snippet findById(Long id);

}
