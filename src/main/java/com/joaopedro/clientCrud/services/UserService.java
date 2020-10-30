package com.joaopedro.clientCrud.services;

import com.joaopedro.clientCrud.classes.UserRole;
import com.joaopedro.clientCrud.classes.UserS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.joaopedro.clientCrud.repositories.UserRepository;
import com.joaopedro.clientCrud.repositories.UserRoleRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 *
 * @author joaopedrocnmota
 */
@RestController
@PreAuthorize("hasAnyRole('ADMIN')")
@RequestMapping(value = "/user")
public class UserService {

    @Autowired
    private UserRepository rep;

    @Autowired
    private UserRoleRepository rolerep;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserS>> findAll() {
        List<UserS> list = rep.findAll();
        return ResponseEntity.ok().body(list);
    }
    
    @RequestMapping(value ="/role" ,method = RequestMethod.GET)
    public ResponseEntity<List<UserRole>> findAllRoles() {
        List<UserRole> list = rolerep.findAll();
        return ResponseEntity.ok().body(list);
    }
}
