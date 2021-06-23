package com.studies.project.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.studies.project.domain.enums.TipoCliente;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Getter
@Setter

@Entity
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	
	@Column(name = "CPF_ou_CNPJ")
	private String CPFouCNPJ;
	private Integer tipo; 

	@JsonManagedReference
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(
			name = "telefone",
			joinColumns = @JoinColumn(name = "cliente_id")
	)
	private Set<String> telefones = new HashSet<>();

	
	public Cliente(Integer id, String nome, String email, String cPFouCNPJ, TipoCliente tipo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.CPFouCNPJ = cPFouCNPJ;
		setTipo(tipo);
	}
	
	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
	}
	
	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
	}
	
	
}
