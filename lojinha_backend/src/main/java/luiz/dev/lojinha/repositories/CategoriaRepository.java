package luiz.dev.lojinha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import luiz.dev.lojinha.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	boolean existsByName(String name);
}
