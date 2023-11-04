package com.example.mprixweb.controller;

import com.example.mprixweb.entities.EnseigneConcurrent;

import com.example.mprixweb.entities.sites;
import com.example.mprixweb.repository.EnseigneConcurrentRepo;
import com.example.mprixweb.repository.SitesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enseigne")
@CrossOrigin(origins = "http://localhost:4200")
public class EnseigneConcurrentController {

    @Autowired
    private final EnseigneConcurrentRepo ensrepo ;

    private final SitesRepo siterepo ;

    public EnseigneConcurrentController(EnseigneConcurrentRepo ensrepo, SitesRepo siterepo) {
        this.ensrepo = ensrepo;
        this.siterepo = siterepo;
    }

    @GetMapping("/all")
    public ResponseEntity<List<EnseigneConcurrent>> getAllEnseigne() {
        List<EnseigneConcurrent> ens=ensrepo.findAll() ;
        return new ResponseEntity<>(ens, HttpStatus.OK) ;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEnseigne(@RequestBody EnseigneConcurrent enseigne) {
        enseigne.setDatecreation(new Date(System.currentTimeMillis()));
        enseigne.setDateUpdate(new Date(System.currentTimeMillis()));
        ensrepo.save(enseigne) ;
        return new ResponseEntity<>(HttpStatus.CREATED) ;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteenseigneetSite(@PathVariable(name="id") Long id ) {
        Optional<EnseigneConcurrent> enseigneOptional = ensrepo.findById(id);

        if (enseigneOptional.isPresent()) {
            EnseigneConcurrent enseigne = enseigneOptional.get();
            List<sites> sites = siterepo.findByEnseigne(enseigne);

            // Delete the associated sites
            siterepo.deleteAll(sites);

            // Delete the enseigne
            ensrepo.deleteById(id);

            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
