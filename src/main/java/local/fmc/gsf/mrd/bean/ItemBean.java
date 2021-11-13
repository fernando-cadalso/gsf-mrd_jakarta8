package local.fmc.gsf.mrd.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import local.fmc.gsf.mrd.dominio.Dispensa;
import local.fmc.gsf.mrd.dominio.ItemDeConsumo;
import local.fmc.gsf.mrd.infra.DispensaDAO;
import local.fmc.gsf.mrd.infra.ItemDeConsumoDAO;

@Named("bean")
@ViewScoped
public class ItemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ItemDeConsumoDAO dao;
	@EJB
	private DispensaDAO daoDispensa;
	// Recebe o ID do item selecionado na lista de dispensas
	@NotNull
	@Size(min = 1, message = "Selecione a dispensa desse item.")
	private Integer dispensaId;
	private List<Dispensa> dispensas = new ArrayList<>();
	private ItemDeConsumo item = new ItemDeConsumo();
	private List<ItemDeConsumo> itens = new ArrayList<ItemDeConsumo>();

	public ItemDeConsumo getItem() {

		return item;
	}

	public void setItem(ItemDeConsumo item) {
		this.item = item;
	}

	public String home() {

		return "home?faces-redirect=true";
	}

	public void salvar() {
		/*
		 * Verifica se o item já existe
		 */
		if (this.item.getId() == null) {
			dao.salvar(item);
			mensagemGlobal(new FacesMessage(FacesMessage.SEVERITY_INFO, ">> Info <<", "Item salvo."));	
		} else {
			dao.atualizar(item);
			mensagemGlobal(new FacesMessage(FacesMessage.SEVERITY_INFO, ">> Info <<", "Item atualizado."));
		}
		this.item = new ItemDeConsumo();
		getItens();
		
	}

	public List<Dispensa> getDispensas() {
		this.dispensas = daoDispensa.listar();
		return dispensas;
		
	}

	public void mensagemGlobal(FacesMessage msg) {

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void setDispensas(List<Dispensa> dispensas) {
		this.dispensas = dispensas;
	}

	public Integer getDispensaId() {
//		mensagemGlobal(new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","DispensaId carregado: " + this.dispensaId));
		return dispensaId;
	}

	public void setDispensaId(Integer dispensaId) {
//		mensagemGlobal(new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","DispensaId definido: " + this.dispensaId));		
		this.dispensaId = dispensaId;
	}

	public List<ItemDeConsumo> getItens() {
		this.itens = dao.listarTodos();
		return itens;
	}

	public void setItens(List<ItemDeConsumo> itens) {
		this.itens = itens;
	}
}
