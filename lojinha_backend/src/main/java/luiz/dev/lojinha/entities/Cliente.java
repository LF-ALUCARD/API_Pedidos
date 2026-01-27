package luiz.dev.lojinha.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import luiz.dev.lojinha.entities.enums.TipoCliente;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String documento;
	private Integer tipo;

	@OneToMany(mappedBy = "cliente")
	@JsonBackReference
	private List<Pedido> pedido = new ArrayList<>();

	@OneToMany(mappedBy = "cliente")
	@JsonManagedReference
	List<Endereco> enderecos = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "telefone", joinColumns = @JoinColumn(name = "id_cliente"))
	@Column(name = "numero")
	private Set<String> numero = new HashSet<>();

	public Cliente() {
	}

	public Cliente(Long id, String name, String email, String documento, TipoCliente tipo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.documento = documento;
		this.tipo = tipo.getCode();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public TipoCliente getTipo() {
		return TipoCliente.valueOf(tipo);
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCode();
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public Set<String> getNumero() {
		return numero;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

}
