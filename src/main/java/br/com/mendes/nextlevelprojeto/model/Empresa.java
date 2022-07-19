package br.com.mendes.nextlevelprojeto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String razaoSocial;
	private Integer raizCnpj;
	
//	@JsonIgnore
	@OneToMany(mappedBy = "id.empresa", fetch = FetchType.LAZY)
	private List<Filial> filiais = new ArrayList<>();
	
	public Empresa() {
	}
	
	public Empresa(Integer codigo, String razaoSocial, Integer raizCnpj) {
		super();
		this.codigo = codigo;
		this.razaoSocial = razaoSocial;
		this.raizCnpj = raizCnpj;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Integer getRaizCNPJ() {
		return raizCnpj;
	}

	public void setRaizCNPJ(Integer raizCnpj) {
		this.raizCnpj = raizCnpj;
	}
	
	public List<Filial> getFiliais() {
		return filiais;
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
		Empresa other = (Empresa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
