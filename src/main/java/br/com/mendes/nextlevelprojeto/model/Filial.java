package br.com.mendes.nextlevelprojeto.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Filial {

	@EmbeddedId
	private FilialPK id = new FilialPK();
		
	private Integer cnpj;
	
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
