package com.joaopedro.clientCrud.services;

import com.joaopedro.clientCrud.classes.User;
import com.joaopedro.clientCrud.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author joaopedrocnmota
 */

@RestController
@RequestMapping(value = "/user")
public class UserService {
   
    @Autowired
    private UserRepository rep;
    
    
    @RequestMapping(method = RequestMethod.POST)
    public User login(@PathVariable String login, String pass) {
        User x = rep.findByLoginAndPass(login, pass); 
        return x;
    }
}
