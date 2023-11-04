package com.example.mprixweb.repository;

import com.example.mprixweb.entities.zones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonesRepo extends JpaRepository<zones , Long> {

    zones findByDesignZ(String designZ);

}
