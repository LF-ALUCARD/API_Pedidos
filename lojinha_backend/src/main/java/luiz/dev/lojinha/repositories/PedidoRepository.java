package luiz.dev.lojinha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import luiz.dev.lojinha.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
