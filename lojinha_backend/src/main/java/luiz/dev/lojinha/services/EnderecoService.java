package luiz.dev.lojinha.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luiz.dev.lojinha.entities.Cidade;
import luiz.dev.lojinha.entities.Cliente;
import luiz.dev.lojinha.entities.Endereco;
import luiz.dev.lojinha.entities.dto.EnderecoCreateDTO;
import luiz.dev.lojinha.repositories.CidadeRepository;
import luiz.dev.lojinha.repositories.ClienteRepository;
import luiz.dev.lojinha.repositories.EnderecoRepository;
import luiz.dev.lojinha.services.exceptions.BuscarException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repositor;
	@Autowired
	private ClienteRepository clienteRepositor;
	@Autowired
	private CidadeRepository cidadeRepositor;

	/*------------------------------------------------*/
	public List<Endereco> findAll() {
		return repositor.findAll();
	}

	/*------------------------------------------------*/
	public Endereco findById(Long id) {
		return repositor.findById(id).orElseThrow(() -> new BuscarException("Endereço não encontrado"));
	}

	/*------------------------------------------------*/
	public Endereco insert(EnderecoCreateDTO entitie) {

		Cidade cidade = cidadeRepositor.findById(entitie.getId_cidade())
				.orElseThrow(() -> new BuscarException("Cidade não encontrada"));
		Cliente cliente = clienteRepositor.findById(entitie.getId_cliente())
				.orElseThrow(() -> new BuscarException("Cliente não encontrado"));

		Endereco info = new Endereco(null, entitie.getLogradouro(), entitie.getNumero(), entitie.getComplemento(),
				entitie.getBairro(), entitie.getCep(), cliente, cidade);

		return repositor.save(info);
	}

	/*------------------------------------------------*/
	public Endereco update(Long id, EnderecoCreateDTO entitie) {

		Endereco end = repositor.findById(id).orElseThrow(() -> new BuscarException("Endereco não encontrado"));
		end.setLogradouro(entitie.getLogradouro());
		end.setNumero(entitie.getNumero());
		end.setComplemento(entitie.getComplemento());
		end.setBairro(entitie.getBairro());
		end.setCep(entitie.getCep());

		end.setCliente(clienteRepositor.findById(id).orElseThrow(() -> new BuscarException("Cliente não encontrado")));
		end.setCidade(cidadeRepositor.findById(id).orElseThrow(() -> new BuscarException("Cidade não encontrada")));

		return repositor.save(end);
	}

	/*------------------------------------------------*/
	public void delete(Long id) {
		repositor.deleteById(id);
	}
}
