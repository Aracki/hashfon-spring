package com.ro.controller.api;

import com.ro.persistence.model.OglasKompanije;
import com.ro.persistence.model.OglasKompanijePk;
import com.ro.persistence.repositories.OglasKompanijeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/{id}")
    public OglasKompanije get(@PathVariable OglasKompanijePk id) {
        return oglasKompanijeRepository.findOne(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public OglasKompanije insert(OglasKompanije oglasKompanije) {
        oglasKompanijeRepository.save(oglasKompanije);
        return oglasKompanije;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public OglasKompanije update(OglasKompanije oglasKompanije) {
        oglasKompanijeRepository.save(oglasKompanije);
        return oglasKompanije;
    }
}
