package com.ro.controller.api;

import com.ro.persistence.model.Hr;
import com.ro.persistence.model.HrPk;
import com.ro.persistence.repositories.HrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/search/getById")
    public Hr getById(@RequestParam Long id) {
        return hrRepository.findById(id);
    }

    @RequestMapping(value = "/search/getByIdKompanije")
    public List<Hr> getByIdKompanije(@RequestParam Long idKompanije) {
        return hrRepository.findByIdKompanije(idKompanije);
    }

    @RequestMapping(value = "/search/getByEmail")
    public Hr getByEmail(@RequestParam String email) {
        return hrRepository.findByEmail(email);
    }

    @RequestMapping(value = "/search/getByIme")
    public List<Hr> getByIme(@RequestParam String ime) {
        return hrRepository.findByIme(ime);
    }

    @RequestMapping(value = "/search/getByPrezime")
    public List<Hr> getByPrezime(@RequestParam String prezime) {
        return hrRepository.findByPrezime(prezime);
    }

    @RequestMapping(value = "/search/getByToken")
    public Hr getByToken(@RequestParam String token) {
        return hrRepository.findByToken(token);
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
