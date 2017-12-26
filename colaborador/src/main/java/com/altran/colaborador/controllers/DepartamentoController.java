package com.altran.colaborador.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.altran.colaborador.model.Departamento;
import com.altran.colaborador.repository.DepartamentoRepository;



@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@RequestMapping("/findAll")
	@ResponseBody
	public ResponseEntity<List<Departamento>> findAll(){
		
		List<Departamento> departamentoes =  (List<Departamento>) departamentoRepository.findAll();
		
		if (departamentoes != null && departamentoes.isEmpty()) {
			return new ResponseEntity<List<Departamento>>(Collections.emptyList(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Departamento>>(departamentoes, HttpStatus.OK);
	}
	
	@RequestMapping(path="/salvar", method= RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public ResponseEntity<String> salvar(@RequestBody Departamento form){
		
		try {
			if (form !=null) {
				departamentoRepository.save(form);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>("Salvo com sucesso!", HttpStatus.OK);
	}
}
