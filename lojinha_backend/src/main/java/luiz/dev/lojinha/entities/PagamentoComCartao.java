package luiz.dev.lojinha.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import luiz.dev.lojinha.entities.enums.EstadoPagamento;

@Entity
@Table(name = "pagamento_cartao")
public class PagamentoComCartao extends Pagamento {

	private Integer numeroParcela;

	public PagamentoComCartao() {
	}

	public PagamentoComCartao(Long id, EstadoPagamento estado, Pedido pedido, Integer numeroParcela) {
		super(id, estado, pedido);
		this.numeroParcela = numeroParcela;
	}

	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcelas(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

}
