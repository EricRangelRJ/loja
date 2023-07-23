package br.com.loja.integracao.utils;

public class ClienteTestUtils {
    public static String montaClienteCadastro() {
        return new StringBuilder()
            .append("{ ")
            .append("\"nome\": \"teste2\",")
            .append("\"cpf\": \"12341233302\",")
            .append("\"dataNascimento\": \"2023-07-18T03:00:00.000Z\",")
            .append("\"email\": \"emailteste@gmail.com\",")
            .append("\"telefone1\": \"26977022\",")
            .append("\"telefone2\": \"11111111111\",")
            .append("\"logradouro\": \"Passagem Vinte e Cinco de Dezembro\",")
            .append("\"numero\": \"23\",")
            .append("\"complemento\": \"null\",")
            .append("\"condominio\": \"null\",")
            .append("\"bairro\": \"Curió-Utinga\",")
            .append("\"municipio\": \"Belém\",")
            .append("\"estado\": \"PA\",")
            .append("\"cep\": \"66610130\",")
            .append("\"observacao\": \"ewew\"")
            .append("}")
            .toString();
    }
}
