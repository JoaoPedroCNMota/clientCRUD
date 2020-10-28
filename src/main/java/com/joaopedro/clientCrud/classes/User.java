/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joaopedro.clientCrud.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author joaopedrocnmota
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String pass;
    private Integer usertype;

    public User() {
    }

    public User(Integer id, String login, String pass, UserType usertype) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.usertype = usertype.getCod();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public UserType getUsertype() {
        return UserType.toEnum(usertype);
    }

    public void setUsertype(UserType usertype) {
        this.usertype = usertype.getCod();
    }

}
