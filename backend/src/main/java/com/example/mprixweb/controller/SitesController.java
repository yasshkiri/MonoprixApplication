package com.example.mprixweb.controller;

import com.example.mprixweb.entities.EnseigneConcurrent;
import com.example.mprixweb.entities.sites;
import com.example.mprixweb.repository.EnseigneConcurrentRepo;
import com.example.mprixweb.repository.SitesRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sites")
@CrossOrigin(origins="http://localhost:4200")
public class SitesController {

    private SitesRepo siterepo ;
    private EnseigneConcurrentRepo ensrepo ;

    public SitesController(SitesRepo siterepo, EnseigneConcurrentRepo ensrepo) {
        this.siterepo = siterepo;
        this.ensrepo = ensrepo;
    }

    @GetMapping("/allsite")
    public ResponseEntity<?> getsite() {
        List<sites> sites = siterepo.findAll();
        return new ResponseEntity<>(sites, HttpStatus.OK);
    }
    @GetMapping("/all/{id}")
    public ResponseEntity<?> getsitesbyenseigne(@PathVariable(name="id") Long id) {
        EnseigneConcurrent enseigne = ensrepo.findEnseigneById(id);

        List<sites> sites = siterepo.findByEnseigne(enseigne);
        return new ResponseEntity<>(sites, HttpStatus.OK);
    }

    @GetMapping("/allbynomsite/{nomsite}")
    public ResponseEntity<?> getSitesByNomsite(@PathVariable(name="nomsite") String nomsite) {
        List<sites> sites = siterepo.findByNomsite(nomsite);
        return new ResponseEntity<>(sites, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getsiteById(@PathVariable(name="id") Long id) {
        Optional<sites> site=siterepo.findById(id) ;
        return new ResponseEntity<>(site,HttpStatus.OK) ;
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateSite(@RequestBody sites site) {
        site.setDateUpdate(new Date(System.currentTimeMillis()));
        siterepo.save(site)  ;
        return new ResponseEntity<>(HttpStatus.OK) ;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletezone(@PathVariable(name="id") Long id) {
        siterepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK) ;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addsites(@RequestBody sites site) {
        site.setDateUpdate(new Date(System.currentTimeMillis()));
        site.setDatecreation(new Date(System.currentTimeMillis()));
        siterepo.save(site) ;
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
