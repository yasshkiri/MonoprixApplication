package com.example.mprixweb.service;

import com.example.mprixweb.entities.sites;
import com.example.mprixweb.repository.SitesRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SitesService {
    private final SitesRepo sitesRepo ;

    public SitesService(SitesRepo sitesRepo) {
        this.sitesRepo = sitesRepo;
    }

    List<sites> findByNomsite(String nomsite) {
        return sitesRepo.findByNomsite(nomsite);
    }
}
