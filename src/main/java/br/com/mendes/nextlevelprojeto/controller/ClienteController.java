package br.com.mendes.nextlevelprojeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mendes.nextlevelprojeto.model.Cliente;
import br.com.mendes.nextlevelprojeto.service.ClienteService;

@RestController
@RequestMapping(path = "api/cliente")
// http://localhost:8080/api/cliente
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public List<Cliente> findAll() {
		List<Cliente> clientes = service.findAll();
		
		return clientes;
	}
	
	// http://localhost:8080/api/cliente/1
	@GetMapping(path = "{codigo}")
	public Cliente findById(@PathVariable Integer codigo) {
		Cliente cliente = service.findById(codigo);
		return cliente;
	}

	@PostMapping
	public void addCliente(@RequestBody Cliente cliente) {
		service.addCliente(cliente);
	}

	@PutMapping(path = "{codigo}")
	public void update(@PathVariable Integer codigo, @RequestBody Cliente cliente) {
		service.update(codigo, cliente);
	}
	
	@DeleteMapping(path = "{codigo}")
	public void delete(@PathVariable Integer codigo) {
		service.delete(codigo);
	}
	
}
