package br.com.mendes.nextlevelprojeto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class TipoDeAtividade {
	
	@Id
	private String codigo;
	private String descricao;
	
	@ManyToMany(mappedBy = "tiposDeAtividades")
	private List<Filial> filiais = new ArrayList<>();
	
	public TipoDeAtividade() {
	
	}

	public TipoDeAtividade(String codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Filial> getFiliais() {
		return filiais;
	}

	public void addFilial(Filial filial) {
		this.filiais.add(filial);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoDeAtividade other = (TipoDeAtividade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
