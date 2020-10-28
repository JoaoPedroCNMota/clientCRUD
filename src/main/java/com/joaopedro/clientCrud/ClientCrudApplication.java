package com.joaopedro.clientCrud;

import com.joaopedro.clientCrud.classes.Address;
import com.joaopedro.clientCrud.classes.Phone;
import com.joaopedro.clientCrud.classes.Client;
import com.joaopedro.clientCrud.classes.User;
import com.joaopedro.clientCrud.classes.UserType;
import com.joaopedro.clientCrud.repositories.AddressRepository;
import com.joaopedro.clientCrud.repositories.PhoneRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.joaopedro.clientCrud.repositories.ClientRepository;
import com.joaopedro.clientCrud.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;

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

    public static void main(String[] args) {
        SpringApplication.run(ClientCrudApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "admin", "123456", UserType.ADMIN);
        User u2 = new User(null, "usuario", "123456", UserType.COMUM);
        userRepository.saveAll(Arrays.asList(u1,u2));
        
        Client c1 = new Client(null, "João Pedro Mota", "03494661146");
        c1.getEmail().addAll(Arrays.asList("joaopedrocnmota@gmail.com", "joao.mota@cjr.org.br"));
        Phone p1 = new Phone(null, 1, "767562819", c1);
        Phone p2 = new Phone(null, 2, "888888888", c1);
        Address a1 = new Address(null, "72720150", "logradouro logradouro",
                "setor tradicional",
                "Brazlândia", "DF",
                "complemento complemento", c1);
        Address a2 = new Address(null, "70000000", "logradouro logradouro",
                "vendinha",
                "Vendinha", "GO",
                "complemento complemento", c1);

        c1.getPhone().addAll(Arrays.asList(p1, p2));
        c1.getAddress().addAll(Arrays.asList(a1));

        clientRepository.saveAll(Arrays.asList(c1));
        phoneRepository.saveAll(Arrays.asList(p1, p2));
        addressRepository.saveAll(Arrays.asList(a1, a2));
    }

}
