package com.lhMeta.warehouse.exceptions;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



// sera capturada a nivel de controller
@ControllerAdvice
public class ControllerExceptionsHandler {


	// resposta de status e resposta no formato JSON
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ValidateErrorDto exceptionHandler(MethodArgumentNotValidException ex) {

		Map<String, String> mapFieldsWithError = new HashMap<>();
				
		List<ObjectError> teste = ex.getBindingResult().getAllErrors();
		
		//System.out.println(teste.size());
		
		//teste.forEach((err)->{
		//	System.out.println(err.getDefaultMessage());
		//});
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			mapFieldsWithError.put(fieldName, errorMessage);
		});
		
		
		
		return new ValidateErrorDto(mapFieldsWithError);
	}
	
	// HttpServletRequest para ter acesso ao path da requisicao
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		@ResponseBody
		@ExceptionHandler(EntityNotFoundException.class)
		public ResponseEntity<StandardErrorDto> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {

			StandardErrorDto err = new StandardErrorDto();
			err.setTimestamp(Instant.now());
			err.setStatus(HttpStatus.NOT_FOUND.value());
			err.setError("Not found !");
			err.setMessage(e.getMessage());
			err.setPath(request.getRequestURI());

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

		}

	
	
	
	/*
	// resposta de status e resposta no formato JSON
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		@ResponseBody
		@ExceptionHandler(EntityNotFoundException.class)
		public String standardExceptionHandler(EntityNotFoundException ex) {
			return ex.getMessage();
		}
	*/
	
	// resposta de status e resposta no formato JSON
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(ArithmeticException.class)
	public ValidateErrorDto divisaoPorZero(ArithmeticException ex) {

			Map<String, String> mapFieldsWithError = new HashMap<>();
			mapFieldsWithError.put("erro", "divisao por zero");
			
			return new ValidateErrorDto(mapFieldsWithError);
	}
	
}
