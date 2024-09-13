package br.com.consumindo.api.entidade;

import br.com.consumindo.api.dto.PessoaDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pessoas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	
	private String cep;
	
	private String logradouro;
	
	private String bairro;
	
	private String localidade;
	
	private String uf;
	
	private String estado;
	
	private String regiao;
	
	public Pessoa(PessoaDto pessoa) {
		this.id = pessoa.getId();
		this.cep = pessoa.getCep();
		this.logradouro = pessoa.getLogradouro();
		this.bairro = pessoa.getBairro();
		this.localidade = pessoa.getLocalidade();
		this.uf = pessoa.getUf();
		this.estado = pessoa.getEstado();
		this.regiao = pessoa.getRegiao();
		this.nome = pessoa.getNome();
	}
	

}
