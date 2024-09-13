package br.com.consumindo.api.infra;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



import br.com.consumindo.api.dto.TratarErros;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class TranamentoDeExcessoes {

	@ExceptionHandler(NoSuchElementException.class )
	public ResponseEntity<TratarErros>idNaoEncontrado(){
		var erro = new TratarErros(HttpStatus.NOT_FOUND, "ID não encontrado !");
		return new ResponseEntity<>(erro,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?>tratador400(MethodArgumentNotValidException ex){
		var erros = ex.getFieldErrors();
		return ResponseEntity.badRequest().body(erros.stream().map(TratandoErros::new).toList());		
	}
}
