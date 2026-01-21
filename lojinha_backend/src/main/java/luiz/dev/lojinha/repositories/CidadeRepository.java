package luiz.dev.lojinha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import luiz.dev.lojinha.entities.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

	boolean existsByName(String name);
}
