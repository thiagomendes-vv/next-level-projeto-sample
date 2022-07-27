package br.com.mendes.nextlevelprojeto.model;

import java.io.Serializable;

public class RotaDeEntregaPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String siglaDoEstado;
	private Integer codigo;
	
	public RotaDeEntregaPK() {
	
	}

	public RotaDeEntregaPK(String siglaDoEstado, Integer codigo) {
		super();
		this.siglaDoEstado = siglaDoEstado;
		this.codigo = codigo;
	}

	public String getSiglaDoEstado() {
		return siglaDoEstado;
	}

	public void setSiglaDoEstado(String siglaDoEstado) {
		this.siglaDoEstado = siglaDoEstado;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((siglaDoEstado == null) ? 0 : siglaDoEstado.hashCode());
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
		RotaDeEntregaPK other = (RotaDeEntregaPK) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (siglaDoEstado == null) {
			if (other.siglaDoEstado != null)
				return false;
		} else if (!siglaDoEstado.equals(other.siglaDoEstado))
			return false;
		return true;
	}
	
}
