package com.example.mprixweb.repository;

import com.example.mprixweb.entities.User;
import com.example.mprixweb.entities.mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MissionRepo extends JpaRepository<mission, Long> {
    List<mission> findByUsers(Optional<User> usermiss);

    @Query(value = "SELECT * FROM mission m where m.id_type = 1",
            nativeQuery = true)
    List<mission> findMissPrix();

    @Query(value = "SELECT * FROM mission m where m.id_type = 2",
            nativeQuery = true)
    List<mission> findMissGamme();
}
