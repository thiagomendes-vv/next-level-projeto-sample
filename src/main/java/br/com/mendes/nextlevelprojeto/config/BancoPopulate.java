package br.com.mendes.nextlevelprojeto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.mendes.nextlevelprojeto.model.Cliente;
import br.com.mendes.nextlevelprojeto.service.ClienteService;

@Configuration
public class BancoPopulate implements CommandLineRunner {

	@Autowired
	private ClienteService clienteService;
	
	@Override
	public void run(String... args) throws Exception {
		Cliente cliente1 = new Cliente(null, "John 1"); 
		Cliente cliente2 = new Cliente(null, "John 2"); 
		Cliente cliente3 = new Cliente(null, "John 3"); 
		Cliente cliente4 = new Cliente(null, "John 4"); 
		Cliente cliente5 = new Cliente(null, "John 5"); 
		Cliente cliente6 = new Cliente(null, "John 6");
		
		clienteService.addCliente(cliente1);
		clienteService.addCliente(cliente2);
		clienteService.addCliente(cliente3);
		clienteService.addCliente(cliente4);
		clienteService.addCliente(cliente5);
		clienteService.addCliente(cliente6);
	}

}
