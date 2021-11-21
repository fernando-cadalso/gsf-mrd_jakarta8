package local.fmc.gsf.mrd.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import local.fmc.gsf.mrd.dominio.Dispensa;
import local.fmc.gsf.mrd.dominio.ItemDeConsumo;
import local.fmc.gsf.mrd.dominio.ListaModelo;
import local.fmc.gsf.mrd.infra.DispensaDAO;
import local.fmc.gsf.mrd.infra.ItemDeConsumoDAO;
import local.fmc.gsf.mrd.infra.ListaModeloDAO;

@Named("bean")
@ViewScoped
public class ItemBean implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	 * ################################## INJEÇÕES DE DEPENDÊNCIAS#################
	 * ##################################
	 */
	@EJB
	private ItemDeConsumoDAO dao;
	@EJB
	private DispensaDAO daoDispensa;
	@EJB
	private ListaModeloDAO daoListaModelo;
	/*
	 * ################################## ATRIBUTOS DO BEAN#################
	 * ##################################
	 */
	@NotNull(message = "Selecione a dispensa desse item.")
	private Dispensa dispensa = new Dispensa();
	private Integer dispensaSelecionada;
	private Integer listaModeloSelecionada;
	private List<Dispensa> dispensas = new ArrayList<>();
	@NotNull(message = "Selecione a lista modelo desse item.")
	private ListaModelo listaModelo = new ListaModelo();
	private List<ListaModelo> listasModelo = new ArrayList<ListaModelo>();
	private ItemDeConsumo item = new ItemDeConsumo();
	private List<ItemDeConsumo> itens = new ArrayList<ItemDeConsumo>();

	public String home() {

		return "home?faces-redirect=true";
	}

	/*
	 * ################################## OPERAÇÕES CRUD####################
	 * ##################################
	 */
	public void salvar() {
		/*
		 * Independente do estado do registro do item, faz a busca pela dispensa e a
		 * lista que o usuário selecionou
		 */
		this.item.setDispensa(daoDispensa.buscaPeloID(dispensaSelecionada));
		this.item.setLista(daoListaModelo.buscarPeloId(listaModeloSelecionada));
		/*
		 * Verifica se o item já existe
		 */
		if (this.item.getId() == null) {
			dao.salvar(item);
			mensagemGlobal(TipoSeveridade.INFO.tipo(), "Item salvo.");
		} else {
			dao.atualizar(item);
			mensagemGlobal(TipoSeveridade.INFO.tipo(), "Item atualizado.");
		}
		this.item = new ItemDeConsumo();
		this.itens = getItens();

	}

	public void excluir(ItemDeConsumo item) {
		dao.excluir(item);
		mensagemGlobal(TipoSeveridade.AVISO.tipo(), "Item apagado.");
	}

	public void mensagemGlobal(Severity tipo, String msg) {

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, null, msg));
	}

	/*
	 * ################################## GETTERS e SETTERS#################
	 * ##################################
	 */
	public ItemDeConsumo getItem() {

		return item;
	}

	public void setItem(ItemDeConsumo item) {
		this.item = item;
	}

	public List<Dispensa> getDispensas() {
		this.dispensas = daoDispensa.listar();
		return dispensas;

	}

	public void setDispensas(List<Dispensa> dispensas) {
		this.dispensas = dispensas;
	}

	public List<ItemDeConsumo> getItens() {
		this.itens = dao.listarTodos();
		return itens;
	}

	public void setItens(List<ItemDeConsumo> itens) {
		this.itens = itens;
	}

	public Dispensa getDispensa() {
		return dispensa;
	}

	public void setDispensa(Dispensa dispensa) {
		this.dispensa = dispensa;
	}

	public ListaModelo getListaModelo() {
		return listaModelo;
	}

	public void setListaModelo(ListaModelo listaModelo) {
		this.listaModelo = listaModelo;
	}

	public List<ListaModelo> getListasModelo() {
		return listasModelo = daoListaModelo.listar();
	}

	public void setListasModelo(List<ListaModelo> listasModelo) {
		this.listasModelo = listasModelo;
	}

	public Integer getDispensaSelecionada() {
		return dispensaSelecionada;
	}

	public void setDispensaSelecionada(Integer dispensaSelecionada) {
		this.dispensaSelecionada = dispensaSelecionada;
	}

	public Integer getListaModeloSelecionada() {
		return listaModeloSelecionada;
	}

	public void setListaModeloSelecionada(Integer listaModeloSelecionada) {
		this.listaModeloSelecionada = listaModeloSelecionada;
	}
}
