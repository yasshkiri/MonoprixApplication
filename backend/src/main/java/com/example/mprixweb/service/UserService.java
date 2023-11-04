package com.example.mprixweb.service;

import com.example.mprixweb.entities.User;
import com.example.mprixweb.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo ur;

    @Autowired
    public UserService(UserRepo ur) {
        this.ur = ur;
    }

    public User adduser(User user) {
        return ur.save(user);
    }

    public List<User> findAlluser() {
        return ur.findAll();
    }

    public List<User> findUserByNomuser(String nomuser) {
        return ur.findAllByNomuser(nomuser);
    }

    public User findByNomuser(String nomuser) {
        return ur.findByNomuser(nomuser);
    }
    public User findUserById(Long id) {
        return ur.findUserById(id);
    }

    public User updateUser(User user) {
        return ur.save(user);
    }

    public void deleteUserById(Long id) {
        ur.deleteById(id);
    }

    public List<User> findUserByIdRole(Long id_role) {
        return ur.findUserByIdRrole(id_role);
    }

    public List<User> findAllUsersCommercials () {
        return findUserByIdRole(2L); //id_role = 3 correspond au role commercial
    }

    public List<User> findAllUsersActiveCommercials () {
        return (List<User>) findAllUsersCommercials().stream().filter(user -> user.isActif()); //id_role = 3 correspond au role commercial
    }

    public List<Long> getIdByNomuser(String nomuser) {
        return ur.getIdByNomuser(nomuser);
    }
}
