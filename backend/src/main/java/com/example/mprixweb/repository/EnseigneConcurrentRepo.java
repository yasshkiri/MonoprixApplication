package com.example.mprixweb.repository;

import com.example.mprixweb.entities.EnseigneConcurrent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnseigneConcurrentRepo extends JpaRepository<EnseigneConcurrent, Long> {


    EnseigneConcurrent findEnseigneById(Long id);

    EnseigneConcurrent findAllById(Long id);


}
