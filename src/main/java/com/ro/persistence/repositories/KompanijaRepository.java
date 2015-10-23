package com.ro.persistence.repositories;

import com.ro.persistence.model.Kompanija;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ognjen on 23.10.15..
 */
public interface KompanijaRepository extends JpaRepository<Kompanija, Long> {
}
