package local.fmc.gsf.mrd.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	//Recebe o ID do item selecionado na lista de dispensas
	@NotNull(message = "Selecione a dispensa desse item.")
	private Integer dispensaId;
	private List<Dispensa> dispensas = new ArrayList<>();
	private ItemDeConsumo item = new ItemDeConsumo();

	
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
		dao.salvar(item);
		mensagemGlobal(new FacesMessage(FacesMessage.SEVERITY_INFO,">> Info <<", "Item salvo"));
	}
	
	public List<Dispensa> getDispensas() {
		
		return daoDispensa.listar();
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
}
