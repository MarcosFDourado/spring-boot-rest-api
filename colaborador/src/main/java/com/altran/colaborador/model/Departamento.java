package com.altran.colaborador.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_departamento")
public class Departamento  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEPARTAMENTO_SEQ")
    @SequenceGenerator(name="DEPARTAMENTO_SEQ", sequenceName="DEPARTAMENTO_SEQ", allocationSize=1)
	private long id;
	
	private String descricao;

	public Departamento() {
		// TODO Auto-generated constructor stub
	}
	public Departamento(long id, String descricao) {
		this.id= id;
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
