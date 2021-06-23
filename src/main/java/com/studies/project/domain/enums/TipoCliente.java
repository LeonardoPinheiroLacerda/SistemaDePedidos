package com.studies.project.domain.enums;

import lombok.Getter;

@Getter
public enum TipoCliente {
	
	PESSOAFISICA(0, "Pessoa Fisíca"),
	PESSOAJURIDICA(1, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public static TipoCliente toEnum(Integer cod) throws IllegalArgumentException {
		if(cod == null) 
			return null;
		
		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod()))
				return x;
		}
		
		throw new IllegalArgumentException("Id invalido: " + cod);
	}
	
}
