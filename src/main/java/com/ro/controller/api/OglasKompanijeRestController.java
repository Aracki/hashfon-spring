package com.ro.controller.api;

import com.ro.persistence.model.Kompanija;
import com.ro.persistence.model.OglasKompanije;
import com.ro.persistence.model.OglasKompanijePk;
import com.ro.persistence.repositories.OglasKompanijeRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ognjen on 23.10.15..
 */

@RestController
@RequestMapping(value = "/api/resources/oglasKompanije")
public class OglasKompanijeRestController {

    public static final Logger LOGGER = Logger.getLogger(OglasKompanijeRestController.class);

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

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OglasKompanije create(@RequestBody OglasKompanije oglasKompanije) {
        LOGGER.info("***** Object to insert *****  " + oglasKompanije);
//        OglasKompanijePk oglasKompanijePk = new OglasKompanijePk();
//        oglasKompanijePk.setIdKompanije(oglasKompanije.getOglasKompanijePk().getIdKompanije());
        oglasKompanijeRepository.save(oglasKompanije);
        return oglasKompanije;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public OglasKompanije update(OglasKompanije oglasKompanije) {
        oglasKompanijeRepository.save(oglasKompanije);
        return oglasKompanije;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        LOGGER.info("***** Object to delete *****  " + oglasKompanijeRepository.findById(id));
        oglasKompanijeRepository.delete(oglasKompanijeRepository.findById(id));
    }

    @RequestMapping(value = "/search/getOglasKompanije")
    public List<Kompanija> getOglasKompanije(@RequestParam String search) {
        return oglasKompanijeRepository.findByOglasKompanije(search);
    }
}
