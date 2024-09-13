package br.com.consumindo.api.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.consumindo.api.dto.PessoaDto;

import br.com.consumindo.api.servico.PessoaServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("pessoa")
public class PessoaControle {
	@Autowired
	private PessoaServico servico;
	
	@PostMapping
	@Operation(summary = "Rota responsável pelo cadastro de pessoas") 
    @ApiResponse(responseCode = "201",description = "voluntário cadastrado com sucesso",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class)) 
   		})          
	public ResponseEntity<PessoaDto>cadastrarpessoa(@RequestBody @Valid PessoaDto pessoa) throws Exception{		
		var cadastro = servico.cadastrar(pessoa);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").
		buildAndExpand(cadastro.getId()).toUri();
		return ResponseEntity.created(uri).body(new PessoaDto(cadastro));
	}

	@GetMapping
	@Operation(summary = "Rota responsável pela busca de todas as pessoas")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<List<PessoaDto>>listarTodos(){
		var pessoas = servico.listarTodos();
		return ResponseEntity.ok(pessoas);
	}
	
	@GetMapping("{id}")
	@Operation(summary = "Rota responsável pela busca de uma pessoa pelo id")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<PessoaDto>buscarPorId(@PathVariable Long id){
		var buscar = servico.buscarPorId(id);
		return ResponseEntity.ok().body(new PessoaDto(buscar));
	}
	@PutMapping("{id}")
	@Operation(summary = "Rota responsável por atualizar uma pessoa pelo id")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<PessoaDto>atualizarPessoa(@RequestBody @Valid PessoaDto pessoa, @PathVariable Long id){
		var atualizando = servico.atualizarPessoa(pessoa, id);
		return ResponseEntity.ok().body(new PessoaDto(atualizando));
	}
	
	@DeleteMapping("{id}")
	@Operation(summary = "Rota responsável por deletar uma pessoa pelo id")
	@ApiResponse(responseCode = "204",description = " sem conteúdo",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	    })           
	public ResponseEntity<Void>excluirPessoa(@PathVariable Long id){
		servico.excluir(id);
		return ResponseEntity.noContent().build();
	}
}
