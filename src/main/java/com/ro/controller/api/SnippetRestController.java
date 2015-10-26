package com.ro.controller.api;

import com.ro.persistence.model.Snippet;
import com.ro.persistence.repositories.SnippetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ognjen on 23.10.15..
 */

@RestController
@RequestMapping(value = "/api/resources/snippet")
public class SnippetRestController {

    @Autowired
    SnippetRepository snippetRepository;

    @RequestMapping(value = "")
    public List<Snippet> getAll() {
        return snippetRepository.findAll();
    }

    @RequestMapping(value = "/search/getById")
    public Snippet getById(@PathVariable Long id) {
        return snippetRepository.findById(id);
    }

    @RequestMapping(value = "/search/getByIdStudent")
    public Snippet getByIdStudent(@PathVariable Long idStudent) {
        return snippetRepository.findByIdStudent(idStudent);
    }

}
