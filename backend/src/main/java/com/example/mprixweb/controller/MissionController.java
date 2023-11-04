package com.example.mprixweb.controller;

import com.example.mprixweb.entities.User;
import com.example.mprixweb.entities.mission;
import com.example.mprixweb.repository.UserRepo;
import com.example.mprixweb.service.MissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("mission")
@CrossOrigin(origins="http://localhost:4200")
public class MissionController {

    private final MissionService missionService ;
    private final UserRepo userRepo ;

    public MissionController(MissionService missionService, UserRepo userRepo) {
        this.missionService = missionService;
        this.userRepo= userRepo ;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getallmission() {
        List<mission> miss=missionService.findAll() ;
        return new ResponseEntity<>(miss, HttpStatus.OK) ;
    }

    @GetMapping("/allgamme")
    public ResponseEntity<?> getAllMissionGamme() {
        List<mission> miss = missionService.findMissGamme()  ;
        return new ResponseEntity<>(miss, HttpStatus.OK) ;
    }

    @GetMapping("/allprix")
    public ResponseEntity<?> getAllMissionPrix() {
        List<mission> miss = missionService.findMissPrix()  ;
        return new ResponseEntity<>(miss, HttpStatus.OK) ;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addmission(@RequestBody mission miss) {
        miss.setDatecreation(new Date(System.currentTimeMillis()));
        miss.setDateUpdate(new Date(System.currentTimeMillis()));
        mission missToResponse = missionService.save(miss) ;
        return new ResponseEntity<>(missToResponse,HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deletemission(@PathVariable(name="id") Long id){
        missionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK) ;
        }

    @GetMapping("/count")
    public ResponseEntity<?> countmission() {
        long number=missionService.count() ;
        return new ResponseEntity<>(number , HttpStatus.OK);
    }

    @GetMapping("/allmiss/{id}")
    public ResponseEntity<?> getallmissionbyUser(@PathVariable(name="id") Long id ) {
        Optional<User> usermiss= userRepo.findById(id) ;
        List<mission> miss=missionService.findByUsers(usermiss) ;
        return new ResponseEntity<>(miss,HttpStatus.OK) ;
    }


}
