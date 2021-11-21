package local.fmc.gsf.mrd.dominio;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemDeConsumo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double quantidade;
	private BigDecimal preco;
	private String descricao;
	private String mercado;
	@ManyToOne
	@JoinColumn(name = "dispensa_id")
	private Dispensa dispensa;

	@ManyToOne
	@JoinColumn(name = "lista_id")
	private ListaModelo lista;

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public Dispensa getDispensa() {
		return dispensa;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public ListaModelo getLista() {
		return lista;
	}

	public void setLista(ListaModelo lista) {
		this.lista = lista;
	}

	public String getMercado() {
		return mercado;
	}

	public void setMercado(String mercado) {
		this.mercado = mercado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDeConsumo other = (ItemDeConsumo) obj;
		return Objects.equals(getId(), other.getId());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDispensa(Dispensa dispensa) {
		this.dispensa = dispensa;
	}

}
