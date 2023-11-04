package com.example.mprixweb.controller;
import com.example.mprixweb.dto.UserDto;
import com.example.mprixweb.entities.User;
import com.example.mprixweb.dto.zonesDto;
import com.example.mprixweb.entities.zones;
import com.example.mprixweb.repository.UserRepo;
import com.example.mprixweb.repository.ZonesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/zones")
@CrossOrigin(origins="http://localhost:4200")
public class ZonesController {
    @Autowired
    private final ZonesRepo zonerepo ;
    private final UserRepo userrepo ;

    public ZonesController(ZonesRepo zonerepo , UserRepo userrepo) {
        this.zonerepo = zonerepo;
        this.userrepo=userrepo ;
    }
     @GetMapping("/allzone")
     public ResponseEntity<?> getallzone() {
        List<zones>  zoneall=zonerepo.findAll() ;
        return new ResponseEntity<>(zoneall,HttpStatus.OK) ;
     }
    @GetMapping("/all")
    public ResponseEntity<List<zonesDto>> getZones() {
        List<zones> zonefind = zonerepo.findAll();
        List<zonesDto> zoneDtos = new ArrayList<>();
       try {
           for (zones zone : zonefind) {
               List<UserDto> users = zone.getUsers().stream().map(User -> new UserDto(User.getId(), User.getNomuser(), User.getEmail())).collect(Collectors.toList());
               zonesDto zoneDto = new zonesDto(zone.getId(), zone.getDesignZ(), users, null);
               zoneDtos.add(zoneDto);
           }
       } catch(Exception e) {
           System.out.println("error : "+e);
       }
        return new ResponseEntity<>(zoneDtos, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addZone(@RequestBody zonesDto zoneDto) {
        zones zone = new zones();
        zone.setDesignZ(zoneDto.getDesignZ());
        zones zonenom=zonerepo.findByDesignZ(zoneDto.getDesignZ()) ;
        if (zonenom!= null) {
            return new ResponseEntity<String>("Error : Zone est deja dans la base ",HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
        List<User> users = new ArrayList<>();
        for (String nomuser : zoneDto.getNomuser()) {
            User user = userrepo.findByNomuser(nomuser);
            if (user != null) {
                users.add(user);
            }
            else { return new ResponseEntity<String>("Error : "+nomuser+" est inconnue ",HttpStatus.INTERNAL_SERVER_ERROR) ; }
        }
        zone.setUsers(users);
        zone.setDateUpdate(new Date(System.currentTimeMillis()));
        zone.setDatecreation(new Date(System.currentTimeMillis()));

        zonerepo.save(zone);
        return new ResponseEntity<zones>(zone, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getZonesById(@PathVariable( name="id") Long id ) {
        Optional<zones> zone=zonerepo.findById(id) ;
        return new ResponseEntity<>(zone,HttpStatus.OK) ;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteZonesById(@PathVariable( name="id") Long id) {
        zonerepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK) ;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateZones(@PathVariable(name="id") Long id ,@RequestBody zonesDto zoneDto) {
        Optional<zones> zoneOptional = zonerepo.findById(id);
        if (zoneOptional.isPresent()) {
            zones zone = zoneOptional.get();
            zone.setDesignZ(zoneDto.getDesignZ());

            List<User> users = new ArrayList<>();
            for (String nomuser : zoneDto.getNomuser()) {
                User user = userrepo.findByNomuser(nomuser);
                if (user != null) {
                    users.add(user);
                }
                else { return new ResponseEntity<>("Error : "+nomuser+" est inconnue ",HttpStatus.INTERNAL_SERVER_ERROR) ; }
            }
            zone.setUsers(users);
            zone.setDateUpdate(new Date(System.currentTimeMillis()));

            zonerepo.save(zone);
            return new ResponseEntity<>(zone, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Error : Zone avec id " + id + " n'existe pas ",HttpStatus.NOT_FOUND);
        }
    }

}
