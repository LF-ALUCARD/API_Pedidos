package luiz.dev.lojinha.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luiz.dev.lojinha.entities.Pagamento;
import luiz.dev.lojinha.repositories.PagamentoRepository;
import luiz.dev.lojinha.services.exceptions.BuscarException;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository repositor;
	
	/*------------------------------------------------*/
	public List<Pagamento> findAll(){
		return repositor.findAll();
	}
	/*------------------------------------------------*/
	public Pagamento findById(Long id) {
		return repositor.findById(id).orElseThrow(() -> new BuscarException("Pagamento não encontrado"));
	}
	/*------------------------------------------------*/
	public Pagamento insert(Pagamento entitie) {
		return repositor.save(entitie);
	}
	/*------------------------------------------------*/
	public void delete(Long id) {
		repositor.deleteById(id);
	}
}
