package com.ro.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ro.persistence.model.Hash;
import com.ro.persistence.model.Snippet;
import com.ro.persistence.model.SnippetPk;
import com.ro.persistence.model.Student;
import com.ro.persistence.repositories.HashRepository;
import com.ro.persistence.repositories.SnippetRepository;
import com.ro.persistence.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by ognjen on 23.10.15..
 */

@RestController
@RequestMapping(value = "/api/resources/snippet")
public class SnippetRestController {

    @Autowired
    SnippetRepository snippetRepository;

    @Autowired
    HashRepository hashRepository;

    @Autowired
    StudentRepository studentRepository;

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

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Snippet create(@RequestBody Snippet snippet) {
        System.out.println(snippet.toString());

        try{
            Hash hash = (Hash) hashRepository.findByTag(snippet.getHash().getTag());
            snippet.setHash(hash);
        } catch (Exception e){
            snippet.getHash().setTag(snippet.getHash().getTag().toLowerCase());
            hashRepository.save(snippet.getHash());
        }

        Student s = studentRepository.findById(Long.parseLong("1"));
        snippet.setStudent(s);
        SnippetPk pk = new SnippetPk();
        pk.setIdStudent(s.getId());
        snippet.setSnippetPk(pk);
        return snippetRepository.save(snippet);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Snippet update(Snippet snippet) {
        snippetRepository.save(snippet);
        return snippet;
    }

}
