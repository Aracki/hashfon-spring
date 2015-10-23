package com.ro.controller.api;

import com.ro.persistence.model.Kompanija;
import com.ro.persistence.repositories.KompanijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ognjen on 23.10.15..
 */

@RestController
@RequestMapping(value = "/api/resources/kompanija")
public class KompanijaRestController {

    @Autowired
    KompanijaRepository kompanijaRepository;

    @RequestMapping(value = "")
    public List<Kompanija> getAll() {
        return kompanijaRepository.findAll();
    }

}
