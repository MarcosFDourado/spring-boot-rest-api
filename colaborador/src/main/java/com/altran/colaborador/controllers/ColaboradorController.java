package com.altran.colaborador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.altran.colaborador.model.Colaborador;
import com.altran.colaborador.repository.ColaboradorRepository;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	@RequestMapping("/findOne")
	@ResponseBody
	public ResponseEntity<Colaborador> findOne(@RequestParam long id) {
		
		Colaborador colaborador = colaboradorRepository.findOne(id);
		
		if (colaborador != null) {
			return new ResponseEntity<Colaborador> (HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Colaborador>(colaborador, HttpStatus.OK);
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public ResponseEntity<List<Colaborador>> findAll() {

		List<Colaborador> colaboradores = (List<Colaborador>) colaboradorRepository.findAll();

		if (colaboradores != null && colaboradores.isEmpty()) {
			return new ResponseEntity<List<Colaborador>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Colaborador>>(colaboradores, HttpStatus.OK);
	}

	@RequestMapping(path = "/findAllPaginated", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Page<Colaborador>> findAllPaginated(@RequestParam int page, @RequestParam int pageSize) {

		Pageable pageable = new PageRequest(page, pageSize);

		Page<Colaborador> pageItens = colaboradorRepository.findAll(pageable);

		return new ResponseEntity<Page<Colaborador>>(pageItens, HttpStatus.OK);
	}

	@RequestMapping(path = "/salvar", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public ResponseEntity<String> salvar(@RequestBody Colaborador form) {

		try {
			if (form != null) {
				colaboradorRepository.save(form);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>( HttpStatus.BAD_REQUEST );
		}

		return new ResponseEntity<String>("Salvo com sucesso!", HttpStatus.OK);
	}
}
