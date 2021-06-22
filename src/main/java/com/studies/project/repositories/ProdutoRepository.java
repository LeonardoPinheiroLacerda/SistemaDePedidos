package com.studies.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studies.project.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
