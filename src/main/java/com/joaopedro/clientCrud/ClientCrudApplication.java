package com.joaopedro.clientCrud;

import com.joaopedro.clientCrud.classes.Address;
import com.joaopedro.clientCrud.classes.Phone;
import com.joaopedro.clientCrud.classes.Client;
import com.joaopedro.clientCrud.classes.UserRole;
import com.joaopedro.clientCrud.repositories.AddressRepository;
import com.joaopedro.clientCrud.repositories.PhoneRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.joaopedro.clientCrud.repositories.ClientRepository;
import com.joaopedro.clientCrud.repositories.UserRepository;
import com.joaopedro.clientCrud.repositories.UserRoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ClientCrudApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    public static void main(String[] args) {
        SpringApplication.run(ClientCrudApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }

    @Override
    public void run(String... args) throws Exception {
        
        UserRole userRole = new UserRole("ROLE_ADMIN");
        UserRole userRole2 = new UserRole("ROLE_COMUM");
        userRoleRepository.saveAll(Arrays.asList(userRole, userRole2));
        
        Client c1 = new Client(null, "João Pedro Mota", "03396760857");
        c1.getEmail().addAll(Arrays.asList("joaopedrocnmota@gmail.com"));
        Phone p1 = new Phone(null, 1, "767562819", c1);
        Address a1 = new Address(null, "72720150", "logradouro logradouro",
                "setor tradicional",
                "Brazlândia", "DF",
                "complemento complemento", c1);

        c1.getPhone().addAll(Arrays.asList(p1));
        c1.getAddress().addAll(Arrays.asList(a1));

        clientRepository.saveAll(Arrays.asList(c1));
        phoneRepository.saveAll(Arrays.asList(p1));
        addressRepository.saveAll(Arrays.asList(a1));
    }

}
