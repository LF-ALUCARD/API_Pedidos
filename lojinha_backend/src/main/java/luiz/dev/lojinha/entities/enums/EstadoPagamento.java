package luiz.dev.lojinha.entities.enums;

import luiz.dev.lojinha.services.exceptions.BuscarException;

public enum EstadoPagamento {

	PEDENTE(1),
	QUITADO(2),
	CANCELADO(3);
	
	private Integer code;
	
	private EstadoPagamento(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return this.code;
	}
	
	public static EstadoPagamento valueOf(Integer code) {
		
		for(EstadoPagamento x : EstadoPagamento.values()) {
			if(x.getCode().equals(code)) {
				return x;
			}
		}
		
		throw new BuscarException("Estado de pagamento inexistente");	
	}
}
