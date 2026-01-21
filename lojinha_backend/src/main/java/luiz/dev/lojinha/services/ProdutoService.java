package luiz.dev.lojinha.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luiz.dev.lojinha.entities.Produto;
import luiz.dev.lojinha.repositories.ProdutoRepository;
import luiz.dev.lojinha.services.exceptions.BuscarException;
import luiz.dev.lojinha.services.exceptions.InsertException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repositor;
	
	/*------------------------------------------------*/
	public List<Produto> findAll(){
		return repositor.findAll();
	}
	/*------------------------------------------------*/
	public Produto findById(Long id) {
		return repositor.findById(id).orElseThrow(() -> new BuscarException("Produto não encontrado"));
	}
	/*------------------------------------------------*/
	public Produto insert(Produto entitie) {
		
		if (repositor.existsByName(entitie.getName())) {
			throw new InsertException("Produto já cadastrada");
		}
		
		return repositor.save(entitie);
	}
	/*------------------------------------------------*/
	public Produto update(Long id, Produto entitie) {
		
		if (repositor.existsByName(entitie.getName())) {
			throw new InsertException("Produto já cadastrada");
		}
		
		Produto cat = repositor.findById(id).orElseThrow(() -> new BuscarException("Produto não encontrado"));
		cat.setName(entitie.getName());
		
		return repositor.save(cat);
	}
	/*------------------------------------------------*/
	public void delete(Long id) {
		repositor.deleteById(id);
	}
}
