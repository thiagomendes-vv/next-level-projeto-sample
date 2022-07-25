package br.com.mendes.nextlevelprojeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mendes.nextlevelprojeto.model.FilialGenerator;
import br.com.mendes.nextlevelprojeto.model.FilialGeneratorPK;

@Repository
public interface FilialGeneratorRepository extends JpaRepository<FilialGenerator, FilialGeneratorPK> {

}
