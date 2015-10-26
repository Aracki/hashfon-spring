package com.ro.controller.api;

import com.ro.persistence.model.Hr;
import com.ro.persistence.model.HrPk;
import com.ro.persistence.repositories.HrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.PathParam;
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

    @RequestMapping(value = "/{id}")
    public Hr get(@PathParam("id") HrPk id) {
        return hrRepository.findOne(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Hr insert(Hr hr) {
        hrRepository.save(hr);
        return hr;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Hr update(Hr hr) {
        hrRepository.save(hr);
        return hr;
    }
}
