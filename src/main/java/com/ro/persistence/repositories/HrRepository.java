package com.ro.persistence.repositories;

import com.ro.persistence.model.Hr;
import com.ro.persistence.model.HrPk;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ognjen on 23.10.15..
 */
public interface HrRepository  extends JpaRepository<Hr, HrPk> {
}
