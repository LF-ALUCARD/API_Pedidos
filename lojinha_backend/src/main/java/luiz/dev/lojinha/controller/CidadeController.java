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

import luiz.dev.lojinha.entities.Cidade;
import luiz.dev.lojinha.entities.dto.CidadeCreateDTO;
import luiz.dev.lojinha.services.CidadeService;

@RestController
@RequestMapping("api/cidades")
public class CidadeController {

	@Autowired
	private CidadeService service;
	
	@GetMapping()
	public ResponseEntity<List<Cidade>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Cidade> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@PostMapping()
	public ResponseEntity<Cidade> insert(@RequestBody CidadeCreateDTO entidade){
		
		Cidade info = service.insert(entidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(info.getId()).toUri();
		
		return ResponseEntity.created(uri).body(info);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Cidade> update(@PathVariable Long id ,@RequestBody CidadeCreateDTO entidade){
		return ResponseEntity.ok().body(service.update(id, entidade));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Cidade> delete(@PathVariable Long id){
		service.delete(id);		
		return ResponseEntity.noContent().build();
	}
}
