package br.com.mendes.nextlevelprojeto.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mendes.nextlevelprojeto.model.Estado;
import br.com.mendes.nextlevelprojeto.service.EstadoService;

@RestController
@RequestMapping(path = "api/estado")
// http://localhost:8080/api/estado
public class EstadoController {
	
	@Autowired
	private EstadoService service;
	
	@GetMapping
	public ResponseEntity<List<Estado>> findAll() {						
		return ResponseEntity.ok().body(service.findAll());
	}
	
	// http://localhost:8080/api/estado/SP
	@GetMapping(path = "{sigla}")
	public ResponseEntity<Estado> findById(@PathVariable String sigla) {
		return ResponseEntity.ok().body(service.findById(sigla));
	}

	@PostMapping
	public ResponseEntity<Void> addEstado(@Valid @RequestBody Estado estado) {
		Estado obj = service.addEstado(estado);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getSigla()).toUri();
		return ResponseEntity.created(uri).build();		
	}

	@PutMapping(path = "{sigla}")
	public ResponseEntity<Void> update(@PathVariable String sigla, @Valid @RequestBody Estado estado) {
		service.update(sigla, estado);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(path = "{sigla}")
	public ResponseEntity<Void> delete(@PathVariable String sigla) {
		service.delete(sigla);
		return ResponseEntity.noContent().build();
	}
	
}
