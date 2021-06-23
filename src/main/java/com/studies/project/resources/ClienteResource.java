package com.studies.project.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.studies.project.domain.Cliente;
import com.studies.project.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Cliente> buscaPorId(@PathVariable Integer id){
		Cliente obj = service.buscaPorId(id);
		return ResponseEntity.ok(obj);	
	}
	
	
}
