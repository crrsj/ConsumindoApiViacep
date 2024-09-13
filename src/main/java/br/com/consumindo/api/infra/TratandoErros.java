package br.com.consumindo.api.infra;

import org.springframework.validation.FieldError;

public record TratandoErros(String campo,String mensagem) {
	public TratandoErros(FieldError erro) {
		this(erro.getField(),erro.getDefaultMessage());
	}
	
}