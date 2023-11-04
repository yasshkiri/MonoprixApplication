package com.example.mprixweb.service;

import com.example.mprixweb.entities.ArticleMission;
import com.example.mprixweb.repository.ArticlesMissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesMissionService {
    @Autowired
    ArticlesMissionRepo articlesMissionRepo;

    public List<ArticleMission> findAllByIdmiss(Long id_miss) {
        return articlesMissionRepo.findAllByIdmiss(id_miss);
    }

    public void saveAll(List<ArticleMission> articleMissions) {
        articlesMissionRepo.saveAll(articleMissions);
    }

}

