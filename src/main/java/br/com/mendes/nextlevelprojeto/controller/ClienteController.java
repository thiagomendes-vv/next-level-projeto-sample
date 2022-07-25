package br.com.mendes.nextlevelprojeto.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import br.com.mendes.nextlevelprojeto.dto.ClienteDto;
import br.com.mendes.nextlevelprojeto.dto.ClienteDtoOutput;
import br.com.mendes.nextlevelprojeto.model.Cliente;
import br.com.mendes.nextlevelprojeto.service.ClienteService;

@RestController
@RequestMapping(path = "api/cliente")
// http://localhost:8080/api/cliente
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<List<ClienteDtoOutput>> findAll() {
		List<Cliente> clientes = service.findAll();
		List<ClienteDtoOutput> clientesDto = 
				clientes.stream()
				.map(c -> new ClienteDtoOutput(c))
				.collect(Collectors.toList());
				
		return ResponseEntity.ok().body(clientesDto);
	}
	
	// http://localhost:8080/api/cliente/page?id=17&ordem=decrescente
	@GetMapping(path = "paginacao")
	public ResponseEntity<Page<ClienteDtoOutput>> findAllPage(Pageable pageable) {
		Page<Cliente> clientes = service.findAllPage(pageable);
		Page<ClienteDtoOutput> clientesDtoOutput = 
				clientes.map(c -> new ClienteDtoOutput(c));
		return ResponseEntity.ok().body(clientesDtoOutput);
	}
	
	// http://localhost:8080/api/cliente/1
	@GetMapping(path = "{codigo}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer codigo) {
		Cliente cliente = service.findById(codigo);
		return ResponseEntity.ok().body(cliente);
	}

	@PostMapping
	public ResponseEntity<Void> addCliente(@Valid @RequestBody ClienteDto clienteDto) {
		Cliente obj = service.addCliente(clienteDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();		
	}

	@PutMapping(path = "{codigo}")
	public ResponseEntity<Void> update(@PathVariable Integer codigo, @Valid @RequestBody ClienteDto clienteDto) {
		service.update(codigo, clienteDto);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(path = "{codigo}")
	public ResponseEntity<Void> delete(@PathVariable Integer codigo) {
		service.delete(codigo);
		return ResponseEntity.noContent().build();
	}
	
}
