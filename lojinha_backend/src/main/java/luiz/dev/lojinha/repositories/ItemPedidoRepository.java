package luiz.dev.lojinha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import luiz.dev.lojinha.entities.ItemPedido;
import luiz.dev.lojinha.entities.pk.ItemPedidoPK;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK>{
}
