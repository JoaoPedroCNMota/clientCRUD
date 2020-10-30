/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joaopedro.clientCrud.services;

import com.joaopedro.clientCrud.repositories.UserRepository;
import com.joaopedro.clientCrud.classes.UserS;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author joaopedrocnmota
 */

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UserRepository rep;
    
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserS u = rep.findByLogin(login);
        if(u == null){
            throw new UsernameNotFoundException(login);
        }
        System.out.println("------------->>>>>>>>> " + u.toString());
        System.out.println("------------->>>>>>>>> " + u.getLogin() + "->" + u.getRoles().toString());
        System.out.println("------------->>>>>>>>> " + u.getAuthorities().toArray().toString());
        return new User(u.getLogin(), u.getPass(), true, true, true , true, u.getAuthorities());
    }
    
}
