package luiz.dev.lojinha.entities.enums;

import luiz.dev.lojinha.services.exceptions.BuscarException;

public enum TipoCliente {

	PESSOA_FISICA(1),
	PESSOA_JURIDICA(2);
	
	private Integer code;
	
	private TipoCliente (Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return this.code;
	}
	
	public static TipoCliente valueOf(Integer code) {
		
		for (TipoCliente x : TipoCliente.values()) {
			if (x.getCode() == code) {
				return x;
			}
		}
		throw new BuscarException("Tipo de Cliente não encontrado");
		
	}
}
