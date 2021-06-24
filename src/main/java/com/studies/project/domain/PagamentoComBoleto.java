package com.studies.project.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.studies.project.domain.enums.EstadoPagamento;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

@Entity 
public class PagamentoComBoleto extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Date dataPagamento;
	
	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagemento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagemento;
		this.dataVencimento = dataVencimento;
	}
	
	
	
}