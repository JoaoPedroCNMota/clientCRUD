/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joaopedro.clientCrud.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author joaopedrocnmota
 */

@Entity
public class UserRole implements GrantedAuthority{

    @Id
    private String roleName;

    @ManyToMany
    List<UserS> users;

    public UserRole() {
    }

    public UserRole(String roleName) {
        this.roleName = roleName;
    }
    
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    @Override
    public String getAuthority() {
        return this.roleName; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
