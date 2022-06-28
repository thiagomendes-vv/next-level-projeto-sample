package br.com.mendes.nextlevelprojeto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mendes.nextlevelprojeto.model.Cliente;
import br.com.mendes.nextlevelprojeto.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;

	public List<Cliente> findAll() {
		List<Cliente> clientes = new ArrayList<>();
		clientes = repo.findAll();
				
		return clientes;
	}

	public void addCliente(Cliente cliente) {
		repo.save(cliente);
	}

	public Cliente findById(Integer codigo) {
		Cliente cliente = repo.findById(codigo).orElse(null);
		return cliente;
	}

	public void update(Integer codigo, Cliente cliente) {
		Cliente clienteAtualizado = this.findById(codigo);
		if (clienteAtualizado == null) {
			throw new RuntimeException("Cliente não encontrado!");
		}
		clienteAtualizado.setNome(cliente.getNome());
		repo.save(clienteAtualizado);
	}

	public void delete(Integer codigo) {
		Cliente clienteApagar = this.findById(codigo);		
		if (clienteApagar == null) {
			throw new RuntimeException("Cliente não encontrado!");
		}
		repo.deleteById(codigo);
	}
	
}
