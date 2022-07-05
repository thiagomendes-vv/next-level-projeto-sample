package br.com.mendes.nextlevelprojeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mendes.nextlevelprojeto.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	public Cliente findByCpf(String cpf);

}
