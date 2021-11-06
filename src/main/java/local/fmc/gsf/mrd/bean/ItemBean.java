package local.fmc.gsf.mrd.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import local.fmc.gsf.mrd.dominio.ItemDeConsumo;
import local.fmc.gsf.mrd.infra.ItemDaCasaDAO;

@ManagedBean
@SessionScoped
public class ItemBean {

	@EJB
	private ItemDaCasaDAO dao;
	private ItemDeConsumo item;
	
	@PostConstruct
	public void itemInstanciado() {
		mensagemGlobal("Item de consumo instanciado.");
		System.out.println("Item de consumo instanciado.");
	}

	public ItemDeConsumo getItem() {
		if (item == null) {
			item = new ItemDeConsumo(); 	
		}
		return item;
	}

	public void setItem(ItemDeConsumo item) {
		this.item = item;
	}

	public String home() {
		
		return "home?faces-redirect=true";
	}
	
	public void salvar() {
		dao.salvar(item);
		mensagemGlobal("Item salvo");
	}
	
	public void novo() {
		
		mensagemGlobal("Novo item iniciado.");
	}

	public String mensagemGlobal(String msg) {
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
		
		return null;
		
	}
}
