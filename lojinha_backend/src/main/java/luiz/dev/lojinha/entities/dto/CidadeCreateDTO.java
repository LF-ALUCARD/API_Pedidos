package luiz.dev.lojinha.entities.dto;

import java.io.Serializable;

public class CidadeCreateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private Long id_estado;

	public CidadeCreateDTO() {
	}

	public CidadeCreateDTO(String name, Long id_estado) {
		super();
		this.name = name;
		this.id_estado = id_estado;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId_estado() {
		return id_estado;
	}

	public void setId_estado(Long id_estado) {
		this.id_estado = id_estado;
	}

}
