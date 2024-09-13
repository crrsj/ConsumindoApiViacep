package br.com.consumindo.api.servico;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.consumindo.api.dto.PessoaDto;
import br.com.consumindo.api.entidade.Pessoa;
import br.com.consumindo.api.repositorio.PessoaRepositorio;

@Service
public class PessoaServico {
   @Autowired
	private PessoaRepositorio repositorio;
	
	public Pessoa cadastrar(PessoaDto pessoa) throws Exception {		
		var cadastro = new Pessoa(pessoa);
		URL url = new URL("https://viacep.com.br/ws/"+cadastro.getCep()+"/json/");
	    URLConnection conexao = url.openConnection();		
		InputStream input = conexao.getInputStream();
		BufferedReader bf = new BufferedReader(new InputStreamReader(input, "UTF-8"));
		String cep = "";
		StringBuilder sb = new StringBuilder();
		while((cep = bf.readLine()) != null){
			sb.append(cep);
			
		}
		
		var cadastroCep = new Gson().fromJson(sb.toString(),Pessoa.class);
		cadastro.setCep(cadastroCep.getCep());
		cadastro.setLogradouro(cadastroCep.getLogradouro());
		cadastro.setBairro(cadastroCep.getBairro());
		cadastro.setLocalidade(cadastroCep.getLocalidade());
		cadastro.setUf(cadastroCep.getUf());
		cadastro.setEstado(cadastroCep.getEstado());
		cadastro.setRegiao(cadastroCep.getRegiao());
		
		return repositorio.save(cadastro);
	}
	
	public List<PessoaDto>listarTodos(){
		return repositorio.findAll().stream().map(PessoaDto::new).toList();
		
	}
	
	public Pessoa buscarPorId(Long id) {
		Optional<Pessoa>buscar = repositorio.findById(id);
		return buscar.get();
	}
	
	public Pessoa atualizarPessoa(PessoaDto pessoa, Long id) {
		var atualizar = new Pessoa(pessoa);
		atualizar.setId(id);
		return repositorio.save(atualizar);
	}
	
	public void excluir(Long id) {
		repositorio.deleteById(id);
	}
}
