package local.fmc.gsf.mrd.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Dispensa{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "dispensa")
	private List<ItemDeConsumo> itens = new ArrayList<>();
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<ItemDeConsumo> getItens() {
		return itens;
	}


	public void setItens(List<ItemDeConsumo> itens) {
		this.itens = itens;
	}


	public void adicionaItem(ItemDeConsumo item){
		this.itens.add(item);
		System.out.println("Item " + item.getNome() + " adicionado na dispensa.");
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
		Dispensa other = (Dispensa) obj;
		return Objects.equals(id, other.id);
	}
	
}
