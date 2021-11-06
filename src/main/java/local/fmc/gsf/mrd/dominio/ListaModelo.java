package local.fmc.gsf.mrd.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class ListaModelo extends ItemDaCasa{

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "lista")
	private List<ItemDeConsumo> itens;

	public void setItens(List<ItemDeConsumo> itens) {
		this.itens = itens;
	}

	public List<ItemDeConsumo> getItens() {
		return itens;
	}
}
