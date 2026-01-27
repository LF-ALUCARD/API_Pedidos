package luiz.dev.lojinha.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import luiz.dev.lojinha.entities.enums.EstadoPagamento;

@Entity
@Table(name = "pagamento_cartao")
public class PagamentoComCartao extends Pagamento {

	private Integer numeroParcelas;

	public PagamentoComCartao() {
	}

	public PagamentoComCartao(Long id, EstadoPagamento estado, Pedido pedido, Integer numeroParcelas) {
		super(id, estado, pedido);
		this.numeroParcelas = numeroParcelas;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

}
