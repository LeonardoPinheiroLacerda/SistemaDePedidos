package com.studies.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studies.project.domain.Cliente;
import com.studies.project.repositories.ClienteRepository;
import com.studies.project.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Cliente buscaPorId(Integer id) throws ObjectNotFoundException{
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto de identidicador "
					+ id
					+ " e tipo " 
					+ Cliente.class.getName()
					+ " não foi encontrado."));
	}
	
}
