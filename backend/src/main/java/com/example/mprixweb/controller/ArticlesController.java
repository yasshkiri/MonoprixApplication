package com.example.mprixweb.controller;

import com.example.mprixweb.entities.Articles;
import com.example.mprixweb.repository.ArticlesRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
@CrossOrigin(origins="http://localhost:4200/")
public class ArticlesController {

     private  final ArticlesRepo artrepo ;

    public ArticlesController(ArticlesRepo artrepo) {
        this.artrepo = artrepo;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getallarticles() {
        List<Articles> article=artrepo.findAll() ;
        return new ResponseEntity<>(article, HttpStatus.OK) ;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getarticleById(@PathVariable(name="id") Long id ) {
        Optional<Articles> article=artrepo.findById(id) ;
        return new ResponseEntity<>(article,HttpStatus.OK) ;
      }

      @PostMapping("/add")
      public ResponseEntity<?> addarticle(@RequestBody Articles article) {
        article.setDatecreation(new Date(System.currentTimeMillis()));
        article.setDateUpdate(new Date(System.currentTimeMillis()));
        artrepo.save(article) ;
        return new ResponseEntity<>(HttpStatus.CREATED) ;
      }



      @PutMapping("/update")
      public ResponseEntity<?> updatearticle(@RequestBody Articles article) {
        article.setDateUpdate(new Date(System.currentTimeMillis()));
        artrepo.save(article) ;
        return new ResponseEntity<>(HttpStatus.OK) ;
      }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletearticle(@PathVariable(name="id") Long id) {
        artrepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK) ;
    }

    @GetMapping("/getgamme")
    public ResponseEntity<?> getallgame() {
        Optional<List<String>> gammes=artrepo.getgamme() ;
        return new ResponseEntity<>(gammes , HttpStatus.OK) ;
    }

}
