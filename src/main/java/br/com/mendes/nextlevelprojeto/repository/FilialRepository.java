package br.com.mendes.nextlevelprojeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mendes.nextlevelprojeto.model.Filial;
import br.com.mendes.nextlevelprojeto.model.FilialPK;

@Repository
public interface FilialRepository extends JpaRepository<Filial, FilialPK> {

}
