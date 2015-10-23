package com.ro.controller.api;

import com.ro.persistence.model.Hash;
import com.ro.persistence.repositories.HashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ognjen on 23.10.15..
 */

@RestController
@RequestMapping(value = "/api/resources/hash")
public class HashRestController {

    @Autowired
    HashRepository hashRepository;

    @RequestMapping(value = "")
    public List<Hash> getAll() {
        return hashRepository.findAll();
    }

}