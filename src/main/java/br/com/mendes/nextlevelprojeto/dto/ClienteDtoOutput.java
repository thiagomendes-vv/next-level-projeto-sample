package br.com.mendes.nextlevelprojeto.dto;

import br.com.mendes.nextlevelprojeto.model.Cliente;

public class ClienteDtoOutput {

	private Integer codigo;
	private String nome;
	
	public ClienteDtoOutput() {
		super();
	}

	public ClienteDtoOutput(Integer codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public ClienteDtoOutput(Cliente cliente) {
		this.codigo = cliente.getCodigo();
	    this.nome = cliente.getNome();
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
	
}
