package com.ro.persistence.repositories;

import com.ro.persistence.model.Hash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ognjen on 23.10.15..
 */
public interface HashRepository extends JpaRepository<Hash, Long> {

    Hash findById(Long id);
    List<Hash> findByTag(String tag);

}
