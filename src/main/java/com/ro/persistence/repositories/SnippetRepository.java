package com.ro.persistence.repositories;

import com.ro.persistence.model.Snippet;
import com.ro.persistence.model.SnippetPk;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ognjen on 23.10.15..
 */
public interface SnippetRepository extends JpaRepository<Snippet, SnippetPk> {
}
