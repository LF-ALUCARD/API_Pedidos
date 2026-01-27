package luiz.dev.lojinha.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luiz.dev.lojinha.entities.Pedido;
import luiz.dev.lojinha.repositories.PedidoRepository;
import luiz.dev.lojinha.services.exceptions.BuscarException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repositor;

	/*------------------------------------------------*/
	public List<Pedido> findAll() {
		return repositor.findAll();
	}

	/*------------------------------------------------*/
	public Pedido findById(Long id) {
		return repositor.findById(id).orElseThrow(() -> new BuscarException("Pedido não encontrado"));
	}

	/*------------------------------------------------*/
	public Pedido insert(Pedido entitie) {
		return repositor.save(entitie);
	}

	/*------------------------------------------------*/
	public void delete(Long id) {
		repositor.deleteById(id);
	}
}
