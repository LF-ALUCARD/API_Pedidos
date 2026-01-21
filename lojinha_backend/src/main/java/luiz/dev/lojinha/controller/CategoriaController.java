package luiz.dev.lojinha.controller;

import java.net.URI;
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

import luiz.dev.lojinha.entities.Categoria;
import luiz.dev.lojinha.services.CategoriaService;

@RestController
@RequestMapping("api/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@GetMapping()
	public ResponseEntity<List<Categoria>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@PostMapping()
	public ResponseEntity<Categoria> insert(@RequestBody Categoria entidade){
		
		Categoria info = service.insert(entidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entidade.getId()).toUri();
		
		return ResponseEntity.created(uri).body(info);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Categoria> update(@PathVariable Long id ,@RequestBody Categoria entidade){
		return ResponseEntity.ok().body(service.update(id, entidade));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Categoria> delete(@PathVariable Long id){
		service.delete(id);		
		return ResponseEntity.noContent().build();
	}
}
