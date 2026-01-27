package luiz.dev.lojinha.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import luiz.dev.lojinha.entities.enums.EstadoPagamento;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pagamento")
public class Pagamento {

	@Id
	private Long id;
	private Integer estado;

	@OneToOne
	@JoinColumn(name = "id_pedido")
	@MapsId
	@JsonIgnore
	private Pedido pedido;

	public Pagamento() {
	}

	public Pagamento(Long id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = estado.getCode();
		this.pedido = pedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.valueOf(estado);
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCode();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
