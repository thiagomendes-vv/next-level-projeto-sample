package br.com.mendes.nextlevelprojeto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mendes.nextlevelprojeto.model.Cliente;
import br.com.mendes.nextlevelprojeto.repository.ClienteRepository;
import br.com.mendes.nextlevelprojeto.service.exception.ObjectFoundException;
import br.com.mendes.nextlevelprojeto.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;

	public List<Cliente> findAll() {
		List<Cliente> clientes = new ArrayList<>();
		clientes = repo.findAll();
				
		return clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		Cliente obj = repo.findByCpf(cliente.getCpf());
		if (obj != null) {
			throw new ObjectFoundException("Cliente já cadastrado!");
		}
		
		return repo.save(cliente);
	}

	public Cliente findById(Integer codigo) {
		// select campos from cliente where id = :codigo
		Cliente cliente = repo.findById(codigo).orElse(null);
		if (cliente == null) {
			throw new ObjectNotFoundException("Cliente não encontrado!");
		}		
		return cliente;
	}

	public void update(Integer codigo, Cliente cliente) {
		Cliente clienteAtualizado = this.findById(codigo);
		clienteAtualizado.setNome(cliente.getNome());
		repo.save(clienteAtualizado);
	}

	public void delete(Integer codigo) {
		this.findById(codigo);		
		repo.deleteById(codigo);
	}
	
}
