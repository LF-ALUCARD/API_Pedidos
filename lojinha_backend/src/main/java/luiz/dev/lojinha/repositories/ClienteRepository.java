package luiz.dev.lojinha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import luiz.dev.lojinha.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	boolean existsByName(String name);
}
