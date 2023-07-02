package br.com.loja;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Sobe a aplicação em uma porta aleatória
class ClienteControllerIT {
	@LocalServerPort
	private int port;

	@Test()
	void deveRetornarStatus403_QuandoConsultarClientes() {
		RestAssured.given()
			.basePath("/api/clientes")
			.port(port)
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.FORBIDDEN.value());
	}

}
