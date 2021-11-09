package local.fmc.gsf.mrd.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import local.fmc.gsf.mrd.dominio.Dispensa;
import local.fmc.gsf.mrd.dominio.ItemDeConsumo;
import local.fmc.gsf.mrd.infra.DispensaDAO;

@Named
@ViewScoped
public class DispensaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private DispensaDAO dao;
	private Dispensa dispensa = new Dispensa();
	private List<Dispensa> dispensas;


	public void salvarDispensa() {

		/*
		 * Verifica se a dispensa que será salva é uma nova ou é uma que já existe
		 */
		if (this.dispensa.getId() == null) {
			dao.salvar(this.dispensa);
			mensagemGlobal(new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Dispensa salva!"));
		} else {
			dao.atualizar(this.dispensa);
			mensagemGlobal(new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Dispensa atualizada!"));
		}
		getDispensas();
		dispensa = new Dispensa();
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

		return this.dispensa;
	}

	public void adicionaItem(ItemDeConsumo item) {
		dispensa.adicionaItem(item);
	}

	public void setDispensa(Dispensa dispensa) {
		this.dispensa = dispensa;
	}

	public List<Dispensa> getDispensas() {
		if (dao.estaVazio()) {
			mensagemGlobal(new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Não há dispensas cadastradas."));
			dispensas = null;
		}
		dispensas = dao.listar();
		return dispensas;

	}

}
