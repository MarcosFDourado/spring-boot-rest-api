package com.altran.colaborador.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.altran.colaborador.model.Colaborador;
import com.altran.colaborador.model.Competencia;

public interface CompetenciaRepository extends CrudRepository<Competencia,Long>{
	
	List<Competencia> findByColaborador(Colaborador colaborador);
	List<Competencia> findByDescricaoIgnoreCase(String descricao);
}
