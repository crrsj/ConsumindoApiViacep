package br.com.consumindo.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.consumindo.api.entidade.Pessoa;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {

}
