package luiz.dev.lojinha.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luiz.dev.lojinha.entities.Cidade;
import luiz.dev.lojinha.repositories.CidadeRepository;
import luiz.dev.lojinha.services.exceptions.BuscarException;
import luiz.dev.lojinha.services.exceptions.InsertException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repositor;
	
	/*------------------------------------------------*/
	public List<Cidade> findAll(){
		return repositor.findAll();
	}
	/*------------------------------------------------*/
	public Cidade findById(Long id) {
		return repositor.findById(id).orElseThrow(() -> new BuscarException("Cidade não encontrado"));
	}
	/*------------------------------------------------*/
	public Cidade insert(Cidade entitie) {
		
		if (repositor.existsByName(entitie.getName())) {
			throw new InsertException("Cidade já cadastrada");
		}
		
		return repositor.save(entitie);
	}
	/*------------------------------------------------*/
	public Cidade update(Long id, Cidade entitie) {
		
		if (repositor.existsByName(entitie.getName())) {
			throw new InsertException("Cidade já cadastrada");
		}
		
		Cidade cat = repositor.findById(id).orElseThrow(() -> new BuscarException("Cidade não encontrado"));
		cat.setName(entitie.getName());
		
		return repositor.save(cat);
	}
	/*------------------------------------------------*/
	public void delete(Long id) {
		repositor.deleteById(id);
	}
}
