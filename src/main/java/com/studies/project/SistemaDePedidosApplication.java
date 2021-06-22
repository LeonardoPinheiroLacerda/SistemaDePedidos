package com.studies.project;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studies.project.domain.Categoria;
import com.studies.project.domain.Produto;
import com.studies.project.repositories.CategoriaRepository;
import com.studies.project.repositories.ProdutoRepository;

@SpringBootApplication
public class SistemaDePedidosApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SistemaDePedidosApplication.class, args);
	}

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository; 
	
	
	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 800.0);
		Produto p3 = new Produto(null, "Mouse", 80.0);
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}
