package local.fmc.gsf.mrd.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import local.fmc.gsf.mrd.dominio.ListaModelo;

@ManagedBean
@SessionScoped
public class ListaBean {

	private ListaModelo lista = new ListaModelo();

	public void salvarLista() {
		
		mensagemGlobal("Lista salva");
	}
	
	public void novaLista() {
		
		mensagemGlobal("Nova lista iniciada.");
		lista = new ListaModelo();
	}

	public String mensagemGlobal(String msg) {
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
		
		return null;
	}

	public ListaModelo getLista() {
		return lista;
	}

	public void setLista(ListaModelo lista) {
		this.lista = lista;
	}
}
