package com.example.mprixweb.repository;

import com.example.mprixweb.entities.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticlesRepo extends JpaRepository<Articles, Long> {

    @Query(value = "SELECT DISTINCT a.gamme_art FROM articles a",
            nativeQuery = true)
    Optional<List<String>> getgamme();

    @Query(value = "SELECT * FROM articles a where gamme_art = ?1",
            nativeQuery = true)
    List<Articles> findAllByGammeart(int gamme_art);




}
