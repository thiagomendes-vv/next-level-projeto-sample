package br.com.mendes.nextlevelprojeto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.mendes.nextlevelprojeto.model.Empresa;
import br.com.mendes.nextlevelprojeto.repository.EmpresaRepository;
import br.com.mendes.nextlevelprojeto.service.exception.ObjectNotFoundException;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository repo;

	public List<Empresa> findAll() {
		List<Empresa> empresas = new ArrayList<>();
		empresas = repo.findAll();
				
		return empresas;
	}

	public Page<Empresa> findAllPage(Pageable pageable) {
		return repo.findAll(pageable) ;
	}

	public Empresa addEmpresa(Empresa empresa) {
		return repo.save(empresa);
	}

	public Empresa findById(Integer codigo) {
		Empresa empresa = repo.findById(codigo).orElse(null);
		if (empresa == null) {
			throw new ObjectNotFoundException("Empresa não encontrado!");
		}		
		return empresa;
	}

	public void update(Integer codigo, Empresa empresa) {
		Empresa empresaAtualizado = this.findById(codigo);
		empresaAtualizado.setRaizCNPJ(empresa.getRaizCNPJ());
		empresaAtualizado.setRazaoSocial(empresa.getRazaoSocial());
		repo.save(empresaAtualizado);
	}

	public void delete(Integer codigo) {
		this.findById(codigo);		
		repo.deleteById(codigo);
	}

}
