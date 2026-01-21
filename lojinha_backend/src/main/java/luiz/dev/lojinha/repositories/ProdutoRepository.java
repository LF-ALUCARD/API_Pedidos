package luiz.dev.lojinha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import luiz.dev.lojinha.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	boolean existsByName(String name);
}
