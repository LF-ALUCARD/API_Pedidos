package luiz.dev.lojinha.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import luiz.dev.lojinha.entities.Categoria;
import luiz.dev.lojinha.repositories.CategoriaRepository;
import luiz.dev.lojinha.services.exceptions.BuscarException;
import luiz.dev.lojinha.services.exceptions.InsertException;

public class CategoriaService {

	@Autowired
	private CategoriaRepository	repositor;
	
	/*------------------------------------------------*/
	public List<Categoria> findAll(){
		return repositor.findAll();
	}
	/*------------------------------------------------*/
	public Categoria findById(Long id) {
		return repositor.findById(id).orElseThrow(() -> new BuscarException("Usuário não encontrado"));
	}
	/*------------------------------------------------*/
	public Categoria insert(Categoria entitie) {
		
		if (repositor.existsByName(entitie.getName())) {
			throw new InsertException("Categoria já cadastrada");
		}
		
		return repositor.save(entitie);
	}
	/*------------------------------------------------*/
	public Categoria update(Long id, Categoria entitie) {
		
		if (repositor.existsByName(entitie.getName())) {
			throw new InsertException("Categoria já cadastrada");
		}
		
		Categoria cat = repositor.findById(id).orElseThrow(() -> new BuscarException("Usuário não encontrado"));
		cat.setName(entitie.getName());
		
		return repositor.save(cat);
	}
	/*------------------------------------------------*/
	public void delete(Long id) {
		repositor.deleteById(id);
	}
}
