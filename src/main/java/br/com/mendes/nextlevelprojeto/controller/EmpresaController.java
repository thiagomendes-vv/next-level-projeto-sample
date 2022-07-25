package br.com.mendes.nextlevelprojeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mendes.nextlevelprojeto.model.Empresa;
import br.com.mendes.nextlevelprojeto.repository.EmpresaRepository;

@RestController
@RequestMapping(path = "api/empresa")
// http://localhost:8080/api/cliente
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository repo;
	
	// http://localhost:8080/api/empresa/1
	@GetMapping(path = "{codigo}")
	public ResponseEntity<Empresa> findById(@PathVariable Integer codigo) {
		Empresa empresa = repo.findById(codigo).orElse(null);
		return ResponseEntity.ok().body(empresa);
	}

}
