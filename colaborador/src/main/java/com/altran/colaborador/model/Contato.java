package com.altran.colaborador.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_contato")
public class Contato  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTATO_SEQ")
    @SequenceGenerator(name="CONTATO_SEQ", sequenceName="CONTATO_SEQ", allocationSize=1)
	private long id;
	
	private String descricao;
	
	@OneToOne
	@JoinColumn(name="id_tp_contato")
	private TipoContato tipo;
	
	@ManyToOne
	@JoinColumn( name = "id_colaborador")
	private Colaborador colaborador;
	
	public TipoContato getTipo() {
		return tipo;
	}
	public void setTipo(TipoContato tipo) {
		this.tipo = tipo;
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
	public Colaborador getColaborador() {
		return colaborador;
	}
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	
}
