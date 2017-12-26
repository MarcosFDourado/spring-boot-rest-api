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

import com.altran.colaborador.model.Competencia;
import com.altran.colaborador.repository.CompetenciaRepository;



@RestController
@RequestMapping("/competencia")
public class CompetenciaController {

	@Autowired
	private CompetenciaRepository competenciaRepository;
	
	@RequestMapping("/findAll")
	@ResponseBody
	public ResponseEntity<List<Competencia>> findAll(){
		
		List<Competencia> competenciaes =  (List<Competencia>) competenciaRepository.findAll();
		
		if (competenciaes != null && competenciaes.isEmpty()) {
			return new ResponseEntity<List<Competencia>>(Collections.emptyList(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Competencia>>(competenciaes, HttpStatus.OK);
	}
	
	@RequestMapping(path="/salvar", method= RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public ResponseEntity<String> salvar(@RequestBody Competencia form){
		
		try {
			if (form !=null) {
				competenciaRepository.save(form);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>("Salvo com sucesso!", HttpStatus.OK);
	}
}
