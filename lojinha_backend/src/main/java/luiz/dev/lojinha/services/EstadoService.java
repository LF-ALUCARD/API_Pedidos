package luiz.dev.lojinha.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luiz.dev.lojinha.entities.Estado;
import luiz.dev.lojinha.repositories.EstadoRepository;
import luiz.dev.lojinha.services.exceptions.BuscarException;
import luiz.dev.lojinha.services.exceptions.InsertException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repositor;
	
	/*------------------------------------------------*/
	public List<Estado> findAll(){
		return repositor.findAll();
	}
	/*------------------------------------------------*/
	public Estado findById(Long id) {
		return repositor.findById(id).orElseThrow(() -> new BuscarException("Estado não encontrado"));
	}
	/*------------------------------------------------*/
	public Estado insert(Estado entitie) {
		
		if (repositor.existsByName(entitie.getName())) {
			throw new InsertException("Estado já cadastrada");
		}
		
		return repositor.save(entitie);
	}
	/*------------------------------------------------*/
	public Estado update(Long id, Estado entitie) {
		
		if (repositor.existsByName(entitie.getName())) {
			throw new InsertException("Estado já cadastrada");
		}
		
		Estado cat = repositor.findById(id).orElseThrow(() -> new BuscarException("Estado não encontrado"));
		cat.setName(entitie.getName());
		
		return repositor.save(cat);
	}
	/*------------------------------------------------*/
	public void delete(Long id) {
		repositor.deleteById(id);
	}
}
