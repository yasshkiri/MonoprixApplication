package com.example.mprixweb.service;

import com.example.mprixweb.entities.Articles;
import com.example.mprixweb.repository.ArticlesRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ArticlesService {

    @Autowired
    ArticlesRepo articlesRepo;

   public List<Articles> findAllArticles() {
        return articlesRepo.findAll();
    }

    public List<Articles> findAllByGammeart(int gamme_art){return articlesRepo.findAllByGammeart(gamme_art);}
}
