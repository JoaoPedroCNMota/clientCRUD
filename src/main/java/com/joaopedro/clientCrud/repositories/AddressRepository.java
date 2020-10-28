/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joaopedro.clientCrud.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.joaopedro.clientCrud.classes.Address;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author joaopedrocnmota
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
