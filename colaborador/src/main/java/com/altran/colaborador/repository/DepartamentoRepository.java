package com.altran.colaborador.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.altran.colaborador.model.Departamento;

public interface DepartamentoRepository extends CrudRepository<Departamento,Long>{

	List<Departamento> findByDescricao(String descricao);
}
