package com.ro.persistence.repositories;

import com.ro.persistence.model.OglasKompanije;
import com.ro.persistence.model.OglasKompanijePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by ognjen on 23.10.15..
 */
public interface OglasKompanijeRepository extends JpaRepository<OglasKompanije, OglasKompanijePk> {

    @Query(value = "SELECT o FROM OglasKompanije o WHERE o.oglasKompanijePk.idKompanije = ?1")
    List<OglasKompanije> findByIdKompanije(Long idKompanije);

    @Query(value = "SELECT o FROM OglasKompanije o WHERE o.oglasKompanijePk.id = ?1")
    OglasKompanije findById(Long id);

}
