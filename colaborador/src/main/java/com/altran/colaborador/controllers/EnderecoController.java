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

import com.altran.colaborador.model.Endereco;
import com.altran.colaborador.repository.EnderecoRepository;



@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@RequestMapping("/findAll")
	@ResponseBody
	public ResponseEntity<List<Endereco>> findAll(){
		
		List<Endereco> enderecoes =  (List<Endereco>) enderecoRepository.findAll();
		
		if (enderecoes != null && enderecoes.isEmpty()) {
			return new ResponseEntity<List<Endereco>>(Collections.emptyList(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Endereco>>(enderecoes, HttpStatus.OK);
	}
	
	@RequestMapping(path="/salvar", method= RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public ResponseEntity<String> salvar(@RequestBody Endereco form){
		
		try {
			if (form !=null) {
				enderecoRepository.save(form);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>("Salvo com sucesso!", HttpStatus.OK);
	}
}
