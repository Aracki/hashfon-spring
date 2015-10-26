package com.ro.persistence.repositories;

import com.ro.persistence.model.Kompanija;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ognjen on 23.10.15..
 */
public interface KompanijaRepository extends JpaRepository<Kompanija, Long> {

    Kompanija findByIme(String ime);
    Kompanija findById(Long id);
    Kompanija findByEmail(String email);
    Kompanija findByAdresa(String adresa);

}
