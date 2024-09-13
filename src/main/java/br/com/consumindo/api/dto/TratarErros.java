package br.com.consumindo.api.dto;

import org.springframework.http.HttpStatus;

public record TratarErros(HttpStatus status,String mensagem) {

}
