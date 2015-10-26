package com.ro.persistence.repositories;

import com.ro.persistence.model.Hr;
import com.ro.persistence.model.HrPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by ognjen on 23.10.15..
 */
public interface HrRepository  extends JpaRepository<Hr, HrPk> {

    @Query(value = "SELECT h FROM Hr h WHERE h.hrPk.idKompanije = ?1")
    List<Hr> findByIdKompanije(Long idKompanije);

    @Query(value = "SELECT h FROM Hr h WHERE h.hrPk.id = ?1")
    Hr findById(Long id);
    Hr findByEmail(String email);
    Hr findByPassword(String password);
    List<Hr> findByIme(String ime);
    List<Hr> findByPrezime(String prezime);
    Hr findByToken(String token);

}
