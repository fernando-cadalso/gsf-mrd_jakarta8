package local.fmc.gsf.mrd.dominio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ListaDeCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime data;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "listaDeCompras" )
	private List<ListaModelo> listasModelo;

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime dataCompra) {
		this.data = dataCompra;
	}

	public Long getId() {
		return id;
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
		ListaDeCompra other = (ListaDeCompra) obj;
		return Objects.equals(id, other.id);
	}

	public List<ListaModelo> getListasModelo() {
		return listasModelo;
	}

	public void setListasModelo(List<ListaModelo> listasModelo) {
		this.listasModelo = listasModelo;
	}

}
