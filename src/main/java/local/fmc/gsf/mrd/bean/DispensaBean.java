package local.fmc.gsf.mrd.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import local.fmc.gsf.mrd.dominio.Dispensa;
import local.fmc.gsf.mrd.dominio.ItemdeConsumo;
import local.fmc.gsf.mrd.dominio.ItemDeConsumo;
import local.fmc.gsf.mrd.infra.DispensaDAO;

@ManagedBean
@SessionScoped
public class DispensaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private DispensaDAO dao;
	private Dispensa dispensa;
	private ItemDeConsumo item = new ItemDeConsumo();
	private List<Dispensa> dispensas;
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

	public List<Dispensa> getDispensas() {
		if (dispensas == null) {
			if (dao.listar().isEmpty()) {
				mensagemGlobal("Não existem dispensas cadastradas.");
				return null;
			}
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
