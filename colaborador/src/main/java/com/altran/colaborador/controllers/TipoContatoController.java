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

import com.altran.colaborador.model.TipoContato;
import com.altran.colaborador.repository.TipoContatoRepository;



@RestController
@RequestMapping("/tipoContato")
public class TipoContatoController {

	@Autowired
	private TipoContatoRepository tipoContatoRepository;
	
	@RequestMapping("/findAll")
	@ResponseBody
	public ResponseEntity<List<TipoContato>> findAll(){
		
		List<TipoContato> tipoContatos =  (List<TipoContato>) tipoContatoRepository.findAll();
		
		if (tipoContatos != null && tipoContatos.isEmpty()) {
			return new ResponseEntity<List<TipoContato>>(Collections.emptyList(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<TipoContato>>(tipoContatos, HttpStatus.OK);
	}
	
	@RequestMapping(path="/salvar", method= RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public ResponseEntity<String> salvar(@RequestBody TipoContato form){
		
		try {
			if (form !=null) {
				tipoContatoRepository.save(form);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>("Salvo com sucesso!", HttpStatus.OK);
	}
}
