package br.com.mendes.nextlevelprojeto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(value = RotaDeEntregaPK.class)
public class RotaDeEntrega implements Serializable {

	private static final long serialVersionUID = 1L;

	// chave primaria composta
	@Id
	@Column(name = "estado")
	private String siglaDoEstado;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROTA_DE_ENTREGA_SEQ")
	private Integer codigo;
	
	// atributos
	private String nome;
	private String status;
//	private Integer filial;
	private Integer prazoExpedicao;
	
	public RotaDeEntrega() {

	}

	public RotaDeEntrega(String siglaDoEstado, Integer codigo, String nome, String status, Filial filial,
			Integer prazoExpedicao) {
		super();
		this.siglaDoEstado = siglaDoEstado;
		this.codigo = codigo;
		this.nome = nome;
		this.status = status;
//		this.filial = filial;
		this.prazoExpedicao = prazoExpedicao;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public Filial getFilial() {
//		return filial;
//	}
//
//	public void setFilial(Filial filial) {
//		this.filial = filial;
//	}

	public Integer getPrazoExpedicao() {
		return prazoExpedicao;
	}

	public void setPrazoExpedicao(Integer prazoExpedicao) {
		this.prazoExpedicao = prazoExpedicao;
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
		RotaDeEntrega other = (RotaDeEntrega) obj;
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
