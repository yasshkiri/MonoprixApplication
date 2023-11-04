package com.example.mprixweb.controller;

import com.example.mprixweb.entities.ArticleMission;
import com.example.mprixweb.entities.Articles;
import com.example.mprixweb.entities.mission;
import com.example.mprixweb.repository.ArticlesMissionRepo;
import com.example.mprixweb.service.ArticlesMissionService;
import com.example.mprixweb.service.ArticlesService;
import com.example.mprixweb.service.MissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("artmiss")
@CrossOrigin(origins="http://localhost:4200")
public class ArticlesMissionController {

    private ArticlesMissionRepo artmissrepo ;

    private ArticlesMissionService articlesMissionService;

    private ArticlesService articlesService;
    private MissionService missionService;

    public ArticlesMissionController(ArticlesMissionRepo artmissrepo
    , ArticlesMissionService articlesMissionService, MissionService missionService, ArticlesService articlesService) {
        this.artmissrepo = artmissrepo;
        this.articlesMissionService = articlesMissionService;
        this.missionService = missionService;
        this.articlesService = articlesService;
    }


    @GetMapping("/all")
    public ResponseEntity<?> getallartmiss() {
        List<ArticleMission> article=artmissrepo.findAll();
        return new ResponseEntity<>(article , HttpStatus.OK) ;
    }
    @GetMapping("/find/{idmiss}")
    public ResponseEntity<?> getallarticleByIdmiss(@PathVariable(name="idmiss") Long idmiss) {
        List<ArticleMission> article=articlesMissionService.findAllByIdmiss(idmiss);
        return new ResponseEntity<>(article , HttpStatus.OK) ;
    }

    @GetMapping("nonplanifie")
    public ResponseEntity<?> getartmissnonplanifie() {
        List<ArticleMission> articles= artmissrepo.findByPlanifieFalse() ;
        return new ResponseEntity<>(articles,HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<?> countarticlemission() {
        Long number=artmissrepo.countByPlanifieFalse();
        return new ResponseEntity<>(number ,HttpStatus.OK) ;
    }

    @PostMapping("/save/{idMiss}/{gammeArt}")
    public ResponseEntity<?> saveAllByGammeArtAndIdMiss(@PathVariable(name= "idMiss") Long idMiss, @PathVariable(name= "gammeArt") int gammeArt) {
        //String message = "";
        try {
            mission newMiss = missionService.findById(idMiss);
            List<Articles> articles = articlesService.findAllByGammeart(gammeArt);
            List<ArticleMission> articlesMission = articles.stream()
                    .map(art -> new ArticleMission(art, newMiss))
                    .collect(Collectors.toList());
            articlesMissionService.saveAll(articlesMission);
            // message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            // message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }








}
