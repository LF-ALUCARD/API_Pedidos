package luiz.dev.lojinha.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luiz.dev.lojinha.entities.Cliente;
import luiz.dev.lojinha.repositories.ClienteRepository;
import luiz.dev.lojinha.services.exceptions.BuscarException;
import luiz.dev.lojinha.services.exceptions.InsertException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repositor;
	
	/*------------------------------------------------*/
	public List<Cliente> findAll(){
		return repositor.findAll();
	}
	/*------------------------------------------------*/
	public Cliente findById(Long id) {
		return repositor.findById(id).orElseThrow(() -> new BuscarException("Cliente não encontrado"));
	}
	/*------------------------------------------------*/
	public Cliente insert(Cliente entitie) {
		
		if (repositor.existsByName(entitie.getName())) {
			throw new InsertException("Cliente já cadastrada");
		}
		
		return repositor.save(entitie);
	}
	/*------------------------------------------------*/
	public Cliente update(Long id, Cliente entitie) {
		
		if (repositor.existsByName(entitie.getName())) {
			throw new InsertException("Cliente já cadastrada");
		}
		
		Cliente cat = repositor.findById(id).orElseThrow(() -> new BuscarException("Cliente não encontrado"));
		cat.setName(entitie.getName());
		
		return repositor.save(cat);
	}
	/*------------------------------------------------*/
	public void delete(Long id) {
		repositor.deleteById(id);
	}
}
