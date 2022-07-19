package br.com.mendes.nextlevelprojeto.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/teste")
public class TesteController {

	@Value("${spring.profiles.active}")
	private String perfil;
	
	@Value("${url.teste}")
	private String urlTeste;
	
	@GetMapping
	public String getPerfil() {
		return perfil + " - " + urlTeste;
	}
}
