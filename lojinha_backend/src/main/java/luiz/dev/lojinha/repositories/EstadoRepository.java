package luiz.dev.lojinha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import luiz.dev.lojinha.entities.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{

	boolean existsByName(String name);
}
