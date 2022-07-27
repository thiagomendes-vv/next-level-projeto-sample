package br.com.mendes.nextlevelprojeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mendes.nextlevelprojeto.model.RotaDeEntrega;
import br.com.mendes.nextlevelprojeto.model.RotaDeEntregaPK;

@Repository
public interface RotaDeEntregaRepository extends JpaRepository<RotaDeEntrega, RotaDeEntregaPK> {

}
