/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joaopedro.clientCrud.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaopedro.clientCrud.domain.Client;

/**
 *
 * @author joaopedrocnmota
 */

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
    
}
