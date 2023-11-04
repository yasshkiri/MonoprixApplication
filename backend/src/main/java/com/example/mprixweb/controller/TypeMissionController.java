package com.example.mprixweb.controller;

import com.example.mprixweb.entities.Types_mission;
import com.example.mprixweb.repository.TypeMissionRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/typemiss")
public class TypeMissionController {
    private TypeMissionRepo typemissrepo ;


    public TypeMissionController(TypeMissionRepo typemissrepo) {
        this.typemissrepo = typemissrepo;
    }
    @GetMapping("/all")
    public ResponseEntity<?> getallmission() {
        List<Types_mission> miss = typemissrepo.findAll();
        return new ResponseEntity<>(miss, HttpStatus.OK);
    }
    }
