package com.ro.controller.api;

import com.ro.persistence.model.Snippet;
import com.ro.persistence.repositories.SnippetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Snippet getById(@RequestParam Long id) {
        return snippetRepository.findById(id);
    }

    @RequestMapping(value = "/search/getByIdStudent")
    public List<Snippet> getByIdStudent(@RequestParam Long idStudent) {
        return snippetRepository.findByIdStudent(idStudent);

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Snippet create(Snippet snippet) {
        snippetRepository.save(snippet);
        return snippet;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Snippet update(Snippet snippet) {
        snippetRepository.save(snippet);
        return snippet;
    }

}
