package com.example.mprixweb.repository;

import com.example.mprixweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Override
    long count();
    User findUserById(Long id);

    @Query(value = "SELECT * FROM user u where u.id_role = ?1",
            nativeQuery = true)
    List<User> findUserByIdRrole(Long id_role);

    List<User> findAllByNomuser(String nomuser);
    User findByNomuser(String nomuser);

    User findUserByEmail(String email);
    @Query(value = "SELECT u.id FROM user u where u.nomuser = ?1",
            nativeQuery = true)
    List<Long> getIdByNomuser(String nomuser);
}
