package br.com.mendes.nextlevelprojeto.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Filial implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FilialPK id = new FilialPK();
		
	private Integer cnpj;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "PONTO_DE_ATIVIDADE",
			joinColumns = {
					@JoinColumn(name = "CODIGO_EMPRESA", referencedColumnName = "CODIGO_EMPRESA"),
					@JoinColumn(name = "CODIGO_FILIAL", referencedColumnName = "CODIGO_FILIAL")
			}, 
			inverseJoinColumns = @JoinColumn(name = "CODIGO_TIPO_ATIVIDADE")
			)
	private List<TipoDeAtividade> tiposDeAtividades = new ArrayList<>();
	
	public Filial() {
	
	}

	public Filial(FilialPK id, Integer cnpj) {
		super();
		this.id = id;
		this.cnpj = cnpj;
	}

	public FilialPK getId() {
		return id;
	}

	public void setId(FilialPK id) {
		this.id = id;
	}

	public Integer getCnpj() {
		return cnpj;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}
	
	public List<TipoDeAtividade> getTiposDeAtividades() {
		return tiposDeAtividades;
	}

	public void addTipoDeAtividade(TipoDeAtividade tipoDeAtividade) {
		this.tiposDeAtividades.add(tipoDeAtividade);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Filial other = (Filial) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}
