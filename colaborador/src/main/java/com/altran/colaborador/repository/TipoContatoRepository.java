package com.altran.colaborador.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.altran.colaborador.model.TipoContato;

public interface TipoContatoRepository extends CrudRepository<TipoContato,Long>{
	
	List<TipoContato> findByDescricao(String descricao);
}
