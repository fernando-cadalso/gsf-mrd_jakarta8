package local.fmc.gsf.mrd.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import local.fmc.gsf.mrd.dominio.Dispensa;
import local.fmc.gsf.mrd.dominio.ItemDeConsumo;
import local.fmc.gsf.mrd.infra.DispensaDAO;

@ManagedBean
@ViewScoped
public class DispensaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private DispensaDAO dao;
	private Dispensa dispensa;
	private ItemDeConsumo item = new ItemDeConsumo();
	private List<Dispensa> dispensas;
	private int dispensaId;

	@PostConstruct
	public void init() {
		getDispensas();
	}

	public void salvarDispensa() {
		dao.salvar(dispensa);
		dispensa = new Dispensa();
		getDispensas();
		mensagemGlobal(new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Dispensa salva!"));
	}

	public void excluir(Dispensa dispensa) {
		System.out.println("Aviso: Excluindo a dispensa " + dispensa.getNome());
		mensagemGlobal(
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Excluindo a dispensa " + dispensa.getNome()));
		dao.excluir(dispensa);
		getDispensas();
		mensagemGlobal(new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Dispensa excluída"));
	}

	public String mensagemGlobal(FacesMessage msg) {

		FacesContext.getCurrentInstance().addMessage(null, msg);

		return null;
	}

	public Dispensa getDispensa() {
		if (dispensa == null) {
			dispensa = new Dispensa();
		}
		return dispensa;
	}

	public void adicionaItem(ItemDeConsumo item) {
		dispensa.adicionaItem(item);
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
		if (dao.estaVazio()) {
			mensagemGlobal(new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Não há dispensas cadastradas."));
			dispensas = null;
		}
		dispensas = dao.listar();
		return dispensas;

	}

	public int getDispensaId() {
		return dispensaId;
	}

	public void setDispensaId(int dispensaId) {
		this.dispensaId = dispensaId;
	}

}
