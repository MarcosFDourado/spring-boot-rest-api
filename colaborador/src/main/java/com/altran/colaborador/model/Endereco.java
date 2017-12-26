package com.altran.colaborador.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="tb_endereco")
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENDERECO_SEQ")
    @SequenceGenerator(name="ENDERECO_SEQ", sequenceName="ENDERECO_SEQ", allocationSize=1)
	private long id;
	private String descricao;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
