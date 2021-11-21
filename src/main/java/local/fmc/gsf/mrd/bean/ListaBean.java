package local.fmc.gsf.mrd.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import local.fmc.gsf.mrd.dominio.ListaModelo;
import local.fmc.gsf.mrd.infra.ListaModeloDAO;

@Named(value = "beanLM")
@ViewScoped
public class ListaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	 * ################################## INJEÇÕES DE DEPENDÊNCIAS#################
	 * ##################################
	 */
	@EJB
	private ListaModeloDAO dao;
	/*
	 * ################################## ATRIBUTOS DO BEAN#################
	 * ##################################
	 */
	private List<ListaModelo> listas;
	private ListaModelo lista = new ListaModelo();

	/*
	 * ################################## OPERAÇÕES CRUD####################
	 * ##################################
	 */
	public List<ListaModelo> salvar() {
		if (this.lista.getId() == null) {
			dao.salvar(lista);
			mensagemGlobal(TipoSeveridade.INFO.tipo(), "Lista " + lista.getNome() + " salva.");
		} else {
			dao.atualizar(lista);
			mensagemGlobal(TipoSeveridade.INFO.tipo(), "Lista  " + lista.getNome() + " atualizada.");
		}
		lista = new ListaModelo();
		return getListas();
		
	}

	public List<ListaModelo> excluir(ListaModelo lista) {
		dao.excluir(lista);
		mensagemGlobal(TipoSeveridade.AVISO.tipo(), "Lista " + lista.getNome() + " excluída.");
		
		return getListas();
	}

	public void mensagemGlobal(Severity tipo, String msg) {

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, "",msg));
	}

	/*
	 * ################################## GETTERS e SETTERS#################
	 * ##################################
	 */
	public ListaModelo getLista() {
		return lista;
	}

	public void setLista(ListaModelo lista) {
		this.lista = lista;
	}

	public List<ListaModelo> getListas() {
		return listas = dao.listar();
	}

	public void setListas(List<ListaModelo> listas) {
		this.listas = listas;
	}
}
