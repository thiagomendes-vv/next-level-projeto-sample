package br.com.mendes.nextlevelprojeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class RotaDeEntrega {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROTADEENTREGA_SEQ")
	private Integer id;
	
	@ManyToOne
	@JoinColumns(value = {
			@JoinColumn(name = "CODIGO_EMPRESA", referencedColumnName = "CODIGO_EMPRESA"),
			@JoinColumn(name = "CODIGO_FILIAL", referencedColumnName = "CODIGO_FILIAL")
			
	})
	private Filial filial;

	public RotaDeEntrega() {
		
	}
	
	public RotaDeEntrega(Integer id, Filial filial) {
		super();
		this.id = id;
		this.filial = filial;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
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
		RotaDeEntrega other = (RotaDeEntrega) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}
