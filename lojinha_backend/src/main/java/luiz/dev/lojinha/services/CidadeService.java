package luiz.dev.lojinha.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luiz.dev.lojinha.entities.Cidade;
import luiz.dev.lojinha.entities.Estado;
import luiz.dev.lojinha.entities.dto.CidadeCreateDTO;
import luiz.dev.lojinha.repositories.CidadeRepository;
import luiz.dev.lojinha.repositories.EstadoRepository;
import luiz.dev.lojinha.services.exceptions.BuscarException;
import luiz.dev.lojinha.services.exceptions.InsertException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repositor;
	
	@Autowired
	private EstadoRepository estadoRepositor;
	
	/*------------------------------------------------*/
	public List<Cidade> findAll(){
		return repositor.findAll();
	}
	/*------------------------------------------------*/
	public Cidade findById(Long id) {
		return repositor.findById(id).orElseThrow(() -> new BuscarException("Cidade não encontrado"));
	}
	/*------------------------------------------------*/
	public Cidade insert(CidadeCreateDTO dto) {
		
		if (repositor.existsByName(dto.getName())) {
			throw new InsertException("Cidade já cadastrada");
		}
		
		Estado estado = estadoRepositor.findById(dto.getId_estado()).orElseThrow(() -> new BuscarException("Estado não encontrado"));
		Cidade entitie = new Cidade(null, dto.getName(), estado);
		
		return repositor.save(entitie);
	}
	/*------------------------------------------------*/
	public Cidade update(Long id, CidadeCreateDTO entitie) {
		
		if (repositor.existsByName(entitie.getName())) {
			throw new InsertException("Cidade já cadastrada");
		}
		
		Cidade cat = repositor.findById(id).orElseThrow(() -> new BuscarException("Cidade não encontrado"));
		cat.setName(entitie.getName());
		cat.setEstado(estadoRepositor.findById(entitie.getId_estado()).orElseThrow(() -> new BuscarException("Estado não encontrado")));
		
		return repositor.save(cat);
	}
	/*------------------------------------------------*/
	public void delete(Long id) {
		repositor.deleteById(id);
	}
}
