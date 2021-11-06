package local.fmc.gsf.mrd.dominio;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ItemDeConsumo extends ItemDaCasa {

	private Double quantidade;
	private BigDecimal preco;
	private String descricao;
	private String mercado;

	@OneToOne
	private Dispensa dispensa;

	@ManyToOne
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
}
