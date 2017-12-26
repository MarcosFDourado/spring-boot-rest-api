package com.altran.colaborador.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="tb_colaborador")
public class Colaborador implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COLABORADOR_SEQ")
    @SequenceGenerator(name="COLABORADOR_SEQ", sequenceName="COLABORADOR_SEQ", allocationSize=1)
	private long id;
	
	private String nome;

	@Column(name="ds_profissao")
	private String profissao;
	
	@Column(name="ds_resumo")
	private String resumo;
	
	@OneToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name="id_departamento")
	private Departamento departamento;
	
	@OneToOne
	@JoinColumn(name="id_endereco")
	private Endereco endereco;
	
	@OneToMany(mappedBy="colaborador")
	private List<Competencia> competencias;
	
	@OneToMany(mappedBy="colaborador")
	private List<Contato> contatos;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public List<Competencia> getCompetencias() {
		return competencias;
	}
	public void setCompetencias(List<Competencia> competencias) {
		this.competencias = competencias;
	}
	public List<Contato> getContatos() {
		return contatos;
	}
	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
