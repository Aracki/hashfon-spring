package com.ro.controller.api;

import com.ro.persistence.model.Snippet;
import com.ro.persistence.repositories.SnippetRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}
