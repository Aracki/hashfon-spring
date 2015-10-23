package com.ro.controller.api;

import com.ro.persistence.model.Hr;
import com.ro.persistence.repositories.HrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ognjen on 23.10.15..
 */

@RestController
@RequestMapping(value = "/api/resources/hr")
public class HrRestController {

    @Autowired
    HrRepository hrRepository;

    @RequestMapping(value = "")
    public List<Hr> getAll() {
        return hrRepository.findAll();
    }

}
