package com.example.mprixweb.controller;

import com.example.mprixweb.entities.roles;
import com.example.mprixweb.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins="http://localhost:4200")
public class RolesController {
    private final RolesService rolerepo ;
    @Autowired
    public RolesController(RolesService rolerepo) {
        this.rolerepo = rolerepo;
    }

    @GetMapping("/all")
    public ResponseEntity<List<roles>> getAllroles() {
        List<roles> role= rolerepo.findAllroles() ;
        return new ResponseEntity<>(role , HttpStatus.OK) ;

    }

    @GetMapping("find/{id}")
    public ResponseEntity<roles> getRoleById(@PathVariable(name ="id") Long id ) {
        roles role=rolerepo.findRolesById(id) ;
        return new ResponseEntity<>(role, HttpStatus.OK) ;

    }
    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping("/add")
    public ResponseEntity<roles> addRole( @RequestBody roles role) {
        roles newRole=rolerepo.addroles(role) ;
        return new ResponseEntity<>(newRole , HttpStatus.CREATED) ;
    }

    @PutMapping("/update")
    public ResponseEntity<roles> updateRole( @RequestBody roles role) {
        roles updrole=rolerepo.updaterole(role) ;
        return  new ResponseEntity<>(updrole , HttpStatus.OK ) ;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<roles> deleteRole( @PathVariable(name="id") Long id) {
        rolerepo.deleterole(id);
        return new ResponseEntity<>(HttpStatus.OK) ;
    }
}
