package com.ro.controller.api;

import com.ro.persistence.model.Kompanija;
import com.ro.persistence.repositories.KompanijaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
import java.util.List;

/**
 * Created by ognjen on 23.10.15..
 */

@RestController
@RequestMapping(value = "/api/resources/kompanija")
public class KompanijaRestController {

    private static final Logger logger = Logger.getLogger(KompanijaRestController.class);

    @Autowired
    KompanijaRepository kompanijaRepository;

    @RequestMapping(value = "")
    public List<Kompanija> getAll() {
        return kompanijaRepository.findAll();
    }

    @RequestMapping(value = "/search/getById")
    public Kompanija getById(@RequestParam Long id) {
        return kompanijaRepository.findById(id);
    }

    @RequestMapping(value = "/search/getByIme")
    public Kompanija getByIme(@RequestParam String ime) {
        return kompanijaRepository.findByIme(ime);
    }

    @RequestMapping(value = "/search/getByEmail")
    public Kompanija getByEmail(@RequestParam String email) {
        return kompanijaRepository.findByEmail(email);
    }

    @RequestMapping(value = "/search/getByAdresa")
    public Kompanija getByAdresa(@RequestParam String adresa) {
        return kompanijaRepository.findByAdresa(adresa);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Kompanija create(Kompanija k) {
        kompanijaRepository.save(k);
        return k;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Kompanija update(@RequestBody Kompanija k) {
        try {
            logger.info("***** Podaci kompanije za update ****** " + k);
            Kompanija kompanijaZaUpdate = kompanijaRepository.findById(k.getId());
            kompanijaZaUpdate.setAdresa(k.getAdresa());
            kompanijaZaUpdate.setEmail(k.getEmail());
            kompanijaZaUpdate.setOpis(k.getOpis());
            kompanijaRepository.save(kompanijaZaUpdate);
            return k;
        } catch (Exception e) {
            return null;
        }
    }
}
