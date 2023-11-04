package com.example.mprixweb.controller;

import com.example.mprixweb.dto.loginDto;
import com.example.mprixweb.entities.User;
import com.example.mprixweb.repository.RolesRepo;
import com.example.mprixweb.repository.UserRepo;
import com.example.mprixweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

    private final UserService userService;

    @Autowired
    private JwtTokenUtil tokenUtil ;

    private final UserRepo urr ;
    private final RolesRepo rolerepo ;


    public UserController(UserService userService , UserRepo urr , JwtTokenUtil tokenUtil, RolesRepo rolerepo) {
        this.userService = userService;
        this.urr=urr ;
        this.tokenUtil=tokenUtil ;
        this.rolerepo = rolerepo;
    }
    @CrossOrigin(origins="http://localhost:4200")

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User userData) {
        User user = urr.findUserByEmail(userData.getEmail());
        if ( user.getPassword().equals(userData.getPassword() ) )   {
            String token =tokenUtil.generateToken(user) ;
            loginDto LoginDTO = new loginDto(user.getId(), user.getEmail(), user.getNomuser());
            LoginDTO.setToken(token);
            System.out.println(userData);
            return ResponseEntity.ok(LoginDTO) ; }
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }


       /* User user = userepo.findUserById(userData.getId());
        System.out.println(user);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if (user.getPassword().equals(userData.getPassword())) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
        /*int id = Integer.parseInt(user.getId());
        String password = user.getPassword();
        System.out.println(id);
        System.out.println(password);

        // perform operations with id and password

        */

   /* @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser( ) {
        List<User> Users=urr.findAllWithRoles();
        return new ResponseEntity<>(Users, HttpStatus.OK) ;
    }*/


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser() {
            List<User> users = userService.findAlluser();
            return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/all/{nomuser}")
    public ResponseEntity<List<User>> getAllUserByNomuser(@PathVariable(name="nomuser") String nomuser) {
        List<User> users = userService.findUserByNomuser(nomuser);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/all/getIdByNom/{nomuser}")
    public ResponseEntity<List<Long>> getIdByNomuser(@PathVariable(name="nomuser") String nomuser) {
        List<Long> ids = userService.getIdByNomuser(nomuser);
        return new ResponseEntity<>(ids, HttpStatus.OK);
    }

    @GetMapping("/allCommercials")
    public ResponseEntity<List<User>> getAllUsersCommercials() {
        List<User> usersCommercials = userService.findAllUsersCommercials();
        return new ResponseEntity<>(usersCommercials, HttpStatus.OK);
    }

    @GetMapping("/allActiveCommercials")
    public ResponseEntity<List<User>> getAllActiveCommercials() {
        List<User> activeCommercials = userService.findAllUsersActiveCommercials();
        return new ResponseEntity<>(activeCommercials, HttpStatus.OK);
    }

    /*@GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUser() {
        List<User> users = userrepo.findAlluser();
        List<UserDTO> userDTOs = new ArrayList<>();

        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setIdUser(user.getIdUser());
            userDTO.setNomuser(user.getNomuser());
            userDTO.setEmail(user.getEmail());
            userDTO.setActif(user.isActif());
            userDTO.setDatecreation(user.getDatecreation());
            userDTO.setIdUserCreation(user.getIdUserCreation());
            userDTO.setDateupdate(user.getDateupdate());
            userDTO.setIdUserUpdate(user.getIdUserUpdate());

            RoleDTO roleDTO = new RoleDTO();
            Role role = user.getRole();
            if (role != null) {
                roleDTO.setIdRole(role.getIdRole());
                roleDTO.setDesignationRole(role.getDesignationRole());
                roleDTO.setDateCreation(role.getDateCreation());
                roleDTO.setIdUserCreation(role.getUserCreation().getIdUser());
                roleDTO.setDateUpdate(role.getDateUpdate());
                roleDTO.setIdUserUpdate(role.getUserUpdate().getIdUser());
            }

            userDTO.setRoleDTO(roleDTO);
            userDTOs.add(userDTO);
        }

        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }*/


    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable(value = "id") Long id) {
        User user= userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK) ;
    }



     @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
         User newUser= userService.adduser(user);
         return new ResponseEntity<>(newUser, HttpStatus.CREATED) ;
    }

    @GetMapping("/count")
    public ResponseEntity<?> countusers() {
        return new ResponseEntity<>(urr.count(),HttpStatus.OK) ;
    }

     @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        user.setDate_update(new Date(System.currentTimeMillis()));
        com.example.mprixweb.entities.User UpdateUser= userService.updateUser(user);
        return new ResponseEntity<>(UpdateUser, HttpStatus.OK) ;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser( @PathVariable(value = "id")  Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK) ;
    }



}
