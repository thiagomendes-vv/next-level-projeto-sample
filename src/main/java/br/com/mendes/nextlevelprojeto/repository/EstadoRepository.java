package br.com.mendes.nextlevelprojeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mendes.nextlevelprojeto.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, String> {

}
