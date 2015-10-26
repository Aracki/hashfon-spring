package com.ro.controller.api;

import com.ro.persistence.model.Kompanija;
import com.ro.persistence.repositories.KompanijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
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

    @RequestMapping(value = "/{id}")
    public Kompanija get(@PathVariable Long id) {
        Kompanija k = kompanijaRepository.findOne(id);
        return k;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Kompanija insert(Kompanija k) {
        kompanijaRepository.save(k);
        return k;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Kompanija update(Kompanija k) {
        kompanijaRepository.save(k);
        return k;
    }
}
