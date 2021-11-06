package local.fmc.gsf.mrd.dominio;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ListaModelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "lista")
	private List<ItemDeConsumo> itens;

	public void setItens(List<ItemDeConsumo> itens) {
		this.itens = itens;
	}

	public List<ItemDeConsumo> getItens() {
		return itens;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		ListaModelo other = (ListaModelo) obj;
		return Objects.equals(id, other.id);
	}
	
}
