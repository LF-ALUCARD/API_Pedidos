package luiz.dev.lojinha.entities.pk;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import luiz.dev.lojinha.entities.Pedido;
import luiz.dev.lojinha.entities.Produto;

@Embeddable
public class ItemPedidoPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	@JsonBackReference
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "id_produto")
	@JsonManagedReference
	private Produto produto;

	public ItemPedidoPK() {
	}

	public ItemPedidoPK(Pedido pedido, Produto produto) {
		super();
		this.pedido = pedido;
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto id_produto) {
		this.produto = id_produto;
	}

}
