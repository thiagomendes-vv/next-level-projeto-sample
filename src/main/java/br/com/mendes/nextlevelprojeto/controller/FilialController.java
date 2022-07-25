package br.com.mendes.nextlevelprojeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mendes.nextlevelprojeto.model.Filial;
import br.com.mendes.nextlevelprojeto.service.FilialService;

@RestController
@RequestMapping(path = "api/filial")
public class FilialController {

	@Autowired
	private FilialService service;
	
	//localhost:8080/api/filial/consulta?empresa=1&filial=1
	@GetMapping(path = "consulta")
	public ResponseEntity<Filial> getFilialById(
			@RequestParam(name = "empresa", defaultValue = "0") Integer codigoEmpresa,
			@RequestParam(name = "filial", defaultValue = "0") Integer codigoFilial
			) {
		return ResponseEntity.ok().body(service.getFilialById(codigoEmpresa, codigoFilial));
				
	}
}
