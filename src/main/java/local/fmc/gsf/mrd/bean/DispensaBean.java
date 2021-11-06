package local.fmc.gsf.mrd.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import local.fmc.gsf.mrd.dominio.Dispensa;
import local.fmc.gsf.mrd.dominio.ItemDaCasa;
import local.fmc.gsf.mrd.dominio.ItemDeConsumo;
import local.fmc.gsf.mrd.infra.ItemDaCasaDAO;

@ManagedBean
@SessionScoped
public class DispensaBean {

	@EJB
	private ItemDaCasaDAO dao;
	private Dispensa dispensa;
	private ItemDeConsumo item = new ItemDeConsumo();
	private List<ItemDaCasa> dispensas;
	private int dispensaId;

	public void salvarDispensa() {
		dao.salvar(dispensa);
		mensagemGlobal("Dispensa salva!");
	}

	public String mensagemGlobal(String msg) {

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));

		return null;
	}

	public Dispensa getDispensa() {
		if (dispensa == null) {
			dispensa = new Dispensa();
		}
		return dispensa;
	}

	public void setDispensa(Dispensa dispensa) {
		this.dispensa = dispensa;
	}

	public ItemDeConsumo getItem() {
		return item;
	}

	public void setItem(ItemDeConsumo item) {
		this.item = item;
	}

	public List<ItemDaCasa> getDispensas() {
		if (dispensas == null) {
			dispensas = dao.listar(); 
		}
		return dispensas;
	}

	public int getDispensaId() {
		return dispensaId;
	}

	public void setDispensaId(int dispensaId) {
		this.dispensaId = dispensaId;
	}

}
