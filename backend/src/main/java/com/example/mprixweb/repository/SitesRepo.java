package com.example.mprixweb.repository;

import com.example.mprixweb.entities.EnseigneConcurrent;
import com.example.mprixweb.entities.sites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SitesRepo extends JpaRepository<sites, Long> {

    List<sites> findByEnseigne(EnseigneConcurrent enseigne);

    List<sites> findByNomsite(String nomsite);

    void deleteByEnseigne(EnseigneConcurrent enseigne);

    void deleteByEnseigneId(Long id);

    void deleteByEnseigne_Id(Long enseigneId);


}
