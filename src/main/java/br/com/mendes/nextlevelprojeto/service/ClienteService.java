package br.com.mendes.nextlevelprojeto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.mendes.nextlevelprojeto.dto.ClienteDto;
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

	public Page<Cliente> findAllPage(Pageable pageable) {
		return repo.findAll(pageable) ;
	}

	public Cliente addCliente(ClienteDto clienteDto) {
		Cliente obj = repo.findByCpf(clienteDto.getCpf());
		if (obj != null) {
			throw new ObjectFoundException("Cliente já cadastrado!");
		}
		
		return repo.save(clienteDto.toEntity());
	}

	public Cliente findById(Integer codigo) {
		// select campos from cliente where id = :codigo
		Cliente cliente = repo.findById(codigo).orElse(null);
		if (cliente == null) {
			throw new ObjectNotFoundException("Cliente não encontrado!");
		}		
		return cliente;
	}

	public void update(Integer codigo, ClienteDto clienteDto) {
		Cliente clienteAtualizado = this.findById(codigo);
		clienteAtualizado.setNome(clienteDto.getNome());
		clienteAtualizado.setCpf(clienteDto.getCpf());
		repo.save(clienteAtualizado);
	}

	public void delete(Integer codigo) {
		this.findById(codigo);		
		repo.deleteById(codigo);
	}

}
