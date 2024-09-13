package br.com.consumindo.api.dto;

import br.com.consumindo.api.entidade.Pessoa;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {
	
	private Long id;
	@NotBlank(message = "Não pode estar em branco")
	private String nome;
	
	private String cep;
	
	private String logradouro;
	
	private String bairro;
	
	private String localidade;
	
	private String uf;
	
	private String estado;
	
	private String regiao;
	
	public PessoaDto(Pessoa cadastro) {
		this.id = cadastro.getId();
		this.nome = cadastro.getNome();
		this.cep = cadastro.getCep();
		this.logradouro = cadastro.getLogradouro();
		this.bairro = cadastro.getBairro();
		this.localidade = cadastro.getLocalidade();
		this.uf = cadastro.getUf();
		this.estado = cadastro.getEstado();
		this.regiao = cadastro.getRegiao();
	}
}
