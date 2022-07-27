package br.com.mendes.nextlevelprojeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(value = FilialGeneratorPK.class)
public class FilialGenerator {

	@Id
	@Column(name = "CODIGO_EMPRESA")
	private Integer empresa;

	@Id
//	@GenericGenerator(name = "increment", strategy = "increment")
//	@GeneratedValue(generator = "increment")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FILIALGENERATOR_SEQ")
	@Column(name = "CODIGO_FILIAL")
	private Integer codigo;

	private Integer cnpj;
//	
//	@JsonIgnore
//	@ManyToMany
//	@JoinTable(
//			name = "PONTO_DE_ATIVIDADE_GENERATOR",
//			joinColumns = {
//					@JoinColumn(name = "CODIGO_EMPRESA", referencedColumnName = "CODIGO_EMPRESA"),
//					@JoinColumn(name = "CODIGO_FILIAL", referencedColumnName = "CODIGO_FILIAL")
//			}, 
//			inverseJoinColumns = @JoinColumn(name = "CODIGO_TIPO_ATIVIDADE")
//			)
//	private List<TipoDeAtividade> tiposDeAtividades = new ArrayList<>();

	public FilialGenerator() {

	}

	public FilialGenerator(Integer empresa, Integer codigo, Integer cnpj) {
		super();
		this.empresa = empresa;
		this.codigo = codigo;
		this.cnpj = cnpj;
	}

	public Integer getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCnpj() {
		return cnpj;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}

//	public List<TipoDeAtividade> getTiposDeAtividades() {
//		return tiposDeAtividades;
//	}
//
//	public void addTipoDeAtividade(TipoDeAtividade tipoDeAtividade) {
//		this.tiposDeAtividades.add(tipoDeAtividade);
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
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
		FilialGenerator other = (FilialGenerator) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		return true;
	}

}
