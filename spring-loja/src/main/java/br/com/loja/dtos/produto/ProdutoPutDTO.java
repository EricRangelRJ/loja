package br.com.loja.dtos.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoPutDTO {
	
	@NotNull
	private Integer idProduto;
	
	@NotBlank(message = "{nome.not.blank}")
	private String nomeProduto;
//  private String codigo;  - NÃO PERMITIDO ALTERAR
	private String descricao;
//	private String dataCadastro; - NÃO PERMITIDO ALTERAR
	private Boolean ativo;
	private Double peso;
	private Double valorCusto;
	private Double valorVenda;
	
	@NotNull
	private Integer idFornecedor;

}