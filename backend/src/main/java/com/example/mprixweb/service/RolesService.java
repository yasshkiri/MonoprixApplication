package com.example.mprixweb.service;


import com.example.mprixweb.entities.roles;
import com.example.mprixweb.repository.RolesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RolesService {
    private final RolesRepo ur ;
    @Autowired
    public RolesService(RolesRepo ur) {
        this.ur = ur;
    }
    @Transactional
    public roles addroles(roles role) {
        return ur.save(role) ;
    }

    public List<roles> findAllroles() {
        return ur.findAll() ;
    }
    public roles findRolesById (Long id) {return ur.findRolesById(id) ;}

    public roles updaterole(roles role) {
        return ur.save(role);
    }
    public void deleterole ( Long id)  {ur.deleteById(id) ;}



}
