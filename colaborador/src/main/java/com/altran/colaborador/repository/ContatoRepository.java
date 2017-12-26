package com.altran.colaborador.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.altran.colaborador.model.Colaborador;
import com.altran.colaborador.model.Contato;
import com.altran.colaborador.model.TipoContato;

public interface ContatoRepository extends CrudRepository<Contato,Long>{

	List<Contato> findByColaborador(Colaborador colaborador);
	List<Contato> findByDescricao(String descricao);
	List<Contato> findByTipo(TipoContato tipo);
}
