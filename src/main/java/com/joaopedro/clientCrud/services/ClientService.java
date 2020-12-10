package com.joaopedro.clientCrud.services;

import com.joaopedro.clientCrud.domain.Address;
import com.joaopedro.clientCrud.domain.Client;
import com.joaopedro.clientCrud.domain.Phone;
import com.joaopedro.clientCrud.repositories.AddressRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.joaopedro.clientCrud.repositories.ClientRepository;
import com.joaopedro.clientCrud.repositories.PhoneRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author joaopedrocnmota
 */
@RestController
@RequestMapping(value = "/client")
public class ClientService {

	@Autowired
	private ClientRepository rep;

	@Autowired
	private AddressRepository addressrep;

	@Autowired
	private PhoneRepository phonerep;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Client>> findAll() {
		List<Client> list = rep.findAll();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Client> find(@PathVariable Integer id) {
		Optional<Client> x = rep.findById(id);
		return x;
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		rep.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ClientDTO dto) {
		Client client = this.fromDTO(dto);
		client = rep.save(client);
		addressrep.saveAll(client.getAddress());
		phonerep.saveAll(client.getPhone());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public Client fromDTO(ClientDTO dto) {
		Client c = new Client(null, dto.getName(), dto.getCpf());
		Address a = new Address(null, dto.getCep(), dto.getLogradouro(), dto.getBairro(), dto.getCidade(), dto.getUf(),
				dto.getComplemento(), c);
		c.getAddress().add(a);
		Phone p = new Phone(null, dto.getTypeNumber(), dto.getNumber(), c);
		c.getPhone().add(p);
		c.getEmail().add(dto.getEmail1());
		if (dto.getEmail2() != null) {
			c.getEmail().add(dto.getEmail2());
		}
		if (dto.getEmail3() != null) {
			c.getEmail().add(dto.getEmail3());
		}

		return c;
	}
}
