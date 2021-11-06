package local.fmc.gsf.mrd.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import local.fmc.gsf.mrd.dominio.ItemDeConsumo;
import local.fmc.gsf.mrd.infra.ItemDeConsumoDAO;

@ManagedBean
@ViewScoped
public class ItemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ItemDeConsumoDAO dao;
	private ItemDeConsumo item;

	public ItemDeConsumo getItem() {
		if (item == null) {
			item = new ItemDeConsumo();
			mensagemGlobal("Item de consumo instanciado.");
			System.out.println("Item de consumo instanciado.");
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
