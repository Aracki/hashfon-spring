package com.ro.controller.api;

import com.ro.persistence.model.OglasKompanije;
import com.ro.persistence.repositories.OglasKompanijeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ognjen on 23.10.15..
 */

@RestController
@RequestMapping(value = "/api/resources/oglasKompanije")
public class OglasKompanijeRestController {

    @Autowired
    OglasKompanijeRepository oglasKompanijeRepository;

    @RequestMapping(value = "")
    public List<OglasKompanije> getAll() {
        return oglasKompanijeRepository.findAll();
    }

}
