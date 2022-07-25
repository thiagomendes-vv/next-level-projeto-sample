package br.com.mendes.nextlevelprojeto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.mendes.nextlevelprojeto.model.TipoDeAtividade;
import br.com.mendes.nextlevelprojeto.repository.TipoDeAtividadeRepository;
import br.com.mendes.nextlevelprojeto.service.exception.ObjectNotFoundException;

@Service
public class TipoDeAtividadeService {
	
	@Autowired
	private TipoDeAtividadeRepository repo;

	public List<TipoDeAtividade> findAll() {
		List<TipoDeAtividade> tipoDeAtividades = new ArrayList<>();
		tipoDeAtividades = repo.findAll();
				
		return tipoDeAtividades;
	}

	public Page<TipoDeAtividade> findAllPage(Pageable pageable) {
		return repo.findAll(pageable) ;
	}

	public TipoDeAtividade addTipoDeAtividade(TipoDeAtividade tipoDeAtividade) {
		return repo.save(tipoDeAtividade);
	}

	public TipoDeAtividade findById(String codigo) {
		TipoDeAtividade tipoDeAtividade = repo.findById(codigo).orElse(null);
		if (tipoDeAtividade == null) {
			throw new ObjectNotFoundException("Tipo de atividade não encontrado!");
		}		
		return tipoDeAtividade;
	}

	public void update(String codigo, TipoDeAtividade tipoDeAtividade) {
		TipoDeAtividade tipoDeAtividadeAtualizado = this.findById(codigo);
		tipoDeAtividadeAtualizado.setDescricao(tipoDeAtividade.getDescricao());
		repo.save(tipoDeAtividadeAtualizado);
	}

	public void delete(String codigo) {
		this.findById(codigo);		
		repo.deleteById(codigo);
	}

}
