package com.example.mprixweb.repository;

import com.example.mprixweb.entities.ArticleMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticlesMissionRepo extends JpaRepository<ArticleMission,Long> {

    List<ArticleMission> findByPlanifieFalse();

    Long countByPlanifieFalse();

    @Query(value = "SELECT * FROM article_mission am where am.id_miss = ?1",
            nativeQuery = true)
    List<ArticleMission> findAllByIdmiss(Long id_miss);



}
