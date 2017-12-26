package com.altran.colaborador.repository;

import org.springframework.data.repository.CrudRepository;

import com.altran.colaborador.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario,Long>{
	
	Usuario findByUsername(String username);
}
