package luiz.dev.lojinha.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import luiz.dev.lojinha.entities.Pedido;
import luiz.dev.lojinha.services.PedidoService;

@RestController
@RequestMapping("api/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService service;
	
	@GetMapping()
	public ResponseEntity<List<Pedido>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@PostMapping()
	public ResponseEntity<Pedido> insert(@RequestBody Pedido entidade){
		
		Pedido info = service.insert(entidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entidade.getId()).toUri();
		
		return ResponseEntity.created(uri).body(info);
	}
}
