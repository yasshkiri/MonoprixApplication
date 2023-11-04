package com.example.mprixweb.repository;

import com.example.mprixweb.entities.roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepo extends JpaRepository<roles, Long> {
roles findRolesById( Long id ) ;
}
