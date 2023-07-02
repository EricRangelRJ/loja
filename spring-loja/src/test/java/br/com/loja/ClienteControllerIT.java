package br.com.loja;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.loja.entities.Cliente;
import br.com.loja.services.ClienteService;
import br.com.loja.utils.DateUtils;

@SpringBootTest
class ClienteControllerIT {

	@Autowired
	private ClienteService service;

	@Test()
	void cadastrarClienteComSucesso() {
		// preparação
		Cliente cliente = new Cliente();
		cliente.setCpf("8888888888");
		cliente.setNome("houahouaho haouhaouhaou");
		cliente.setDataNascimento(DateUtils.toDate(null, "dd/MM/yyyy"));
		cliente.setEmail("emailTeste@teste.com");

		// ação

		// validações
	}

}
