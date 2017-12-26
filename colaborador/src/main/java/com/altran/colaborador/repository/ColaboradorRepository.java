package com.altran.colaborador.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.altran.colaborador.model.Colaborador;
import com.altran.colaborador.model.Competencia;
import com.altran.colaborador.model.Departamento;

public interface ColaboradorRepository extends PagingAndSortingRepository<Colaborador,Long>{
	
	List<Colaborador> findByNomeIgnoreCase(String nome, Pageable pageable);
	List<Colaborador> findByProfissaoIgnoreCase(String profissao);
	List<Colaborador> findByDepartamento(Departamento departamento);
	List<Colaborador> findByCompetencias(Competencia competencia);
}
