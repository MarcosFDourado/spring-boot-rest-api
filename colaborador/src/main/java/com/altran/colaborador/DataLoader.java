package com.altran.colaborador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.altran.colaborador.model.Departamento;
import com.altran.colaborador.model.TipoContato;
import com.altran.colaborador.repository.DepartamentoRepository;
import com.altran.colaborador.repository.TipoContatoRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private TipoContatoRepository tipoContatoRepository;

	@Autowired
	private DepartamentoRepository departamentoRepository;


	public void run(ApplicationArguments args) {
		inserirTipoContato(new TipoContato(1L, "Telefone Fixo"));
		inserirTipoContato(new TipoContato(2L, "Telefone Comercial"));
		inserirTipoContato(new TipoContato(3L, "Celular"));
		inserirTipoContato(new TipoContato(4L, "Email"));
		inserirTipoContato(new TipoContato(5L, "Facebook"));
		inserirTipoContato(new TipoContato(6L, "LinkedIn"));
		
		inserirDepartamento(new Departamento(1L,"Escritório de Inovações") );
		inserirDepartamento(new Departamento(2L,"Recurso Humanos")         );
		inserirDepartamento(new Departamento(3L,"Fabrica de Software")     );
		inserirDepartamento(new Departamento(4L,"Marketing")               );
	}

	private void inserirTipoContato(TipoContato tipo) {
		if (!tipoContatoRepository.exists(tipo.getId()))
			tipoContatoRepository.save(tipo);
	}
	private void inserirDepartamento(Departamento departamento) {
		if (!departamentoRepository.exists(departamento.getId()))
			departamentoRepository.save(departamento);
	}
}