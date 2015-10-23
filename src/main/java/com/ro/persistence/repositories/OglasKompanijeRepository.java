package com.ro.persistence.repositories;

import com.ro.persistence.model.OglasKompanije;
import com.ro.persistence.model.OglasKompanijePk;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ognjen on 23.10.15..
 */
public interface OglasKompanijeRepository extends JpaRepository<OglasKompanije, OglasKompanijePk> {
}
