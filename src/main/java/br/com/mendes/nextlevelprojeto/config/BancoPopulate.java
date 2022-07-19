package br.com.mendes.nextlevelprojeto.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.mendes.nextlevelprojeto.model.Cliente;
import br.com.mendes.nextlevelprojeto.model.Empresa;
import br.com.mendes.nextlevelprojeto.model.Filial;
import br.com.mendes.nextlevelprojeto.model.FilialPK;
import br.com.mendes.nextlevelprojeto.repository.ClienteRepository;
import br.com.mendes.nextlevelprojeto.repository.EmpresaRepository;
import br.com.mendes.nextlevelprojeto.repository.FilialRepository;

@Configuration
public class BancoPopulate implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private FilialRepository filialRepository;
	
	@Override
	public void run(String... args) throws Exception {
//		Cliente cliente1 = new Cliente(null, "John 1", "12345678910"); 
//		Cliente cliente2 = new Cliente(null, "John 2", "12345678911"); 
//		Cliente cliente3 = new Cliente(null, "John 3", "12345678912"); 
//		Cliente cliente4 = new Cliente(null, "John 4", "12345678913"); 
//		Cliente cliente5 = new Cliente(null, "John 5", "12345678914"); 
//		Cliente cliente6 = new Cliente(null, "John 6", "12345678915");
//		
//		clienteRepository.save(cliente1);
//		clienteRepository.save(cliente2);
//		clienteRepository.save(cliente3);
//		clienteRepository.save(cliente4);
//		clienteRepository.save(cliente5);
//		clienteRepository.save(cliente6);
		
		Empresa empresa1 = new Empresa(null, "Via", 33041260);
		Empresa empresa2 = new Empresa(null, "Pontofrio", 33041261);
		Empresa empresa3 = new Empresa(null, "Casas Bahia", 33041262);
		Empresa empresa4 = new Empresa(null, "Extra", 33041263);
		empresaRepository.saveAll(Arrays.asList(empresa1, empresa2, empresa3, empresa4));
		
		FilialPK filial1pk = new FilialPK(empresa1, 1);
		Filial filial1 = new Filial(filial1pk, 330412601);
		Filial filial2 = new Filial(new FilialPK(empresa1, 2), 330412602);
		filialRepository.saveAll(Arrays.asList(filial1, filial2));
		
		int fimDoCpf = 0;
		for (int i = 1; i < 50; i++) {
			clienteRepository.save(
					new Cliente(null, "Cliente " + i, 
							"123456789" + (fimDoCpf + i)));
		}
		
	}

}
