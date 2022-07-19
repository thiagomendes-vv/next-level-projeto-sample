package br.com.mendes.nextlevelprojeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mendes.nextlevelprojeto.model.Empresa;
import br.com.mendes.nextlevelprojeto.model.Filial;
import br.com.mendes.nextlevelprojeto.model.FilialPK;
import br.com.mendes.nextlevelprojeto.repository.EmpresaRepository;
import br.com.mendes.nextlevelprojeto.repository.FilialRepository;

@Service
public class FilialService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private FilialRepository repo;
	
	public Filial getFilialById(Integer codigoEmpresa, Integer codigoFilial) {
		Empresa empresa = empresaRepository.findById(codigoEmpresa).orElse(null);
		FilialPK id = new FilialPK();		
		id.setEmpresa(empresa);
		id.setCodigo(codigoFilial);
		return repo.findById(id).orElse(null);
	}
}
