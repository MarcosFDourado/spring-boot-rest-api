package com.altran.colaborador.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_tipo_contato")
public class TipoContato implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TP_CONTATO_SEQ")
    @SequenceGenerator(name="TP_CONTATO_SEQ", sequenceName="TP_CONTATO_SEQ", allocationSize=1)
	private long id;
	private String descricao;
	
	public TipoContato() {
		// TODO Auto-generated constructor stub
	}
	public TipoContato(String descricao) {
		this.descricao = descricao;
	}
	public TipoContato(long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
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
