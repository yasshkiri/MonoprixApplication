package com.example.mprixweb.service;

import com.example.mprixweb.entities.User;
import com.example.mprixweb.entities.mission;
import com.example.mprixweb.repository.MissionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionService {
    private final MissionRepo missionRepo;

    public MissionService(MissionRepo missionRepo) {
        this.missionRepo = missionRepo;
    }

    public mission findById(Long id){return missionRepo.findById(id).get();}

    public List<mission> findByUsers(Optional<User> usermiss){
       return missionRepo.findByUsers(usermiss);
    }

    public List<mission> findMissGamme(){
        return missionRepo.findMissGamme();
    }

    public List<mission> findMissPrix() {
        return missionRepo.findMissPrix();
    }

    public List<mission> findAll() {
        return missionRepo.findAll();
    }

    public mission save(mission miss) {
        return missionRepo.save(miss);
    }

    public void deleteById(Long id) {
        missionRepo.deleteById(id);
    }

    public long count() {
        return missionRepo.count();
    }


}
