package luiz.dev.lojinha.services.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BuscarException.class)
	public ResponseEntity<Map<String, Object>> BucarHandler(BuscarException exception){
		Map<String, Object> body = new HashMap<>();
		body.put("Mensagem: ", exception.getMessage());
		body.put("Erro: ", "NÃO ENCONTRADO");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}
	
	@ExceptionHandler(InsertException.class)
	public ResponseEntity<Map<String, Object>> InsertHandler(InsertException exception){
		Map<String, Object> body = new HashMap<>();
		body.put("Mensagem: ", exception.getMessage());
		body.put("Erro: ", "DUPLICIDADE");
		return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
	}
}
