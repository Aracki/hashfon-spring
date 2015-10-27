package com.ro.controller.api;

import com.ro.persistence.model.OglasKompanije;
import com.ro.persistence.model.OglasKompanijePk;
import com.ro.persistence.repositories.OglasKompanijeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
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

    @RequestMapping(value = "/search/getById")
    public OglasKompanije getById(@RequestParam Long id) {
        return oglasKompanijeRepository.findById(id);
    }

    @RequestMapping(value = "/search/getByIdKompanije")
    public List<OglasKompanije> getByIdKompanije(@RequestParam Long idKompanije) {
        return oglasKompanijeRepository.findByIdKompanije(idKompanije);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public OglasKompanije create(OglasKompanije oglasKompanije) {
        oglasKompanijeRepository.save(oglasKompanije);
        return oglasKompanije;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public OglasKompanije update(OglasKompanije oglasKompanije) {
        oglasKompanijeRepository.save(oglasKompanije);
        return oglasKompanije;
    }
}
