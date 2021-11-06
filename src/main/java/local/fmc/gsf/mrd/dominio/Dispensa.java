package local.fmc.gsf.mrd.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Dispensa extends ItemDaCasa {
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "dispensa")
	private List<ItemDeConsumo> itens = new ArrayList<>();
	
	public void adicionaItem(ItemDeConsumo item){
		this.itens.add(item);
		System.out.println("Item " + item.getNome() + " adicionado na dispensa.");
	}
}
