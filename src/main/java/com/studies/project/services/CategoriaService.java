package com.studies.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studies.project.domain.Categoria;
import com.studies.project.repositories.CategoriaRepository;
import com.studies.project.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public Categoria buscar(Integer id) {
		
		Optional<Categoria> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto de identidicador "
					+ id
					+ " e tipo " 
					+ Categoria.class.getName()
					+ " não foi encontrado."
			)
		);
		
		
	}
	
}
