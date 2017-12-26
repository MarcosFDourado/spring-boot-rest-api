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

import com.altran.colaborador.model.Contato;
import com.altran.colaborador.repository.ContatoRepository;



@RestController
@RequestMapping("/contato")
public class ContatoController {

	@Autowired
	private ContatoRepository contatoRepository;
	
	@RequestMapping("/findAll")
	@ResponseBody
	public ResponseEntity<List<Contato>> findAll(){
		
		List<Contato> contatoes =  (List<Contato>) contatoRepository.findAll();
		
		if (contatoes != null && contatoes.isEmpty()) {
			return new ResponseEntity<List<Contato>>(Collections.emptyList(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Contato>>(contatoes, HttpStatus.OK);
	}
	
	@RequestMapping(path="/salvar", method= RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public ResponseEntity<String> salvar(@RequestBody Contato form){
		
		try {
			if (form !=null) {
				contatoRepository.save(form);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>("Salvo com sucesso!", HttpStatus.OK);
	}
}
