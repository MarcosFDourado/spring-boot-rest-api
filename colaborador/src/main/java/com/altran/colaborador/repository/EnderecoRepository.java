package com.altran.colaborador.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.altran.colaborador.model.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco,Long>{
	
	List<Endereco> findByDescricao(String descricao);
}
