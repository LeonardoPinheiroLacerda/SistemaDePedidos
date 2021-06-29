package com.studies.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studies.project.domain.Pedido;
import com.studies.project.repositories.PedidoRepository;
import com.studies.project.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	public Pedido buscaPorId(Integer id) {
		
		Optional<Pedido> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto de identidicador "
					+ id
					+ " e tipo " 
					+ Pedido.class.getName()
					+ " não foi encontrado."));
		
	}
	
}
