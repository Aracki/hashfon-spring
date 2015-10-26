package com.ro.persistence.repositories;

import com.ro.persistence.model.Snippet;
import com.ro.persistence.model.SnippetPk;
import com.ro.persistence.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by ognjen on 23.10.15..
 */
public interface SnippetRepository extends JpaRepository<Snippet, SnippetPk> {

    @Query(value = "SELECT s FROM Snippet s WHERE s.snippetPk.idStudent = ?1")
    List<Snippet> findByIdStudent(Long idStudent);

    @Query(value = "SELECT s FROM Snippet s WHERE s.snippetPk.id = ?1")
    Snippet findById(Long id);

}
