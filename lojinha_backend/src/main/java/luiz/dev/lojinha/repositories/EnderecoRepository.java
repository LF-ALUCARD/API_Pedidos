package luiz.dev.lojinha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import luiz.dev.lojinha.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
}
