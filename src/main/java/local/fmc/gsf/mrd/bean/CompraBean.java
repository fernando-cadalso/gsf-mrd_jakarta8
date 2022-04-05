package local.fmc.gsf.mrd.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import local.fmc.gsf.mrd.dominio.ItemDeConsumo;
import local.fmc.gsf.mrd.dominio.ListaDeCompra;
import local.fmc.gsf.mrd.dominio.ListaModelo;
import local.fmc.gsf.mrd.infra.DispensaDAO;
import local.fmc.gsf.mrd.infra.ListaDeCompraDAO;
import local.fmc.gsf.mrd.infra.ListaModeloDAO;

@ViewScoped
@Named(value = "beanC")
public class CompraBean implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	 * ################################## INJEÇÕES DE DEPENDÊNCIAS#################
	 * ##################################
	 */
	@EJB
	private DispensaDAO daoDispensa;
	@EJB
	private ListaModeloDAO daoListaModelo;
	@EJB
	private ListaDeCompraDAO dao;
	/*
	 * ################################## ATRIBUTOS DO BEAN#################
	 * ##################################
	 */
	private List<ListaModelo> listasModelo;
	private Integer listaSelecionada;
	private Integer itemSelecionado;
	private List<ItemDeConsumo> itens = new ArrayList<>();
	private ListaModelo listaModelo = new ListaModelo();
	private ListaDeCompra listaDeCompra = new ListaDeCompra();
	private List<ListaDeCompra> compras = new ArrayList<ListaDeCompra>();
	private ItemDeConsumo item = new ItemDeConsumo();

	public CompraBean() {
	}

	@PostConstruct
	public void carregaListas() {
		this.setListasModelo(daoListaModelo.listar());

	}

	/*
	 * ################################## OPERAÇÕES CRUD####################
	 * ##################################
	 */
	public void salvar() {
		dao.salvar(this.getListaDeCompra());
		mensagemGlobal(TipoSeveridade.INFO.tipo(), "Lista de compra salva com sucesso.");
	}

	public void excluir(ListaDeCompra compra) {
		dao.excluir(compra);
		mensagemGlobal(TipoSeveridade.AVISO.tipo(), "Lista de compra apagada com sucesso.");

	}

	public void mensagemGlobal(Severity tipo, String msg) {

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, null, msg));
	}

	/*
	 * ################################## GETTERS e SETTERS#################
	 * ##################################
	 */
	public ListaDeCompra getListaDeCompra() {
		return listaDeCompra;
	}

	public void setListaDeCompra(ListaDeCompra listaDeCompra) {
		this.listaDeCompra = listaDeCompra;
	}

	public List<ListaDeCompra> getCompras() {
		return compras;
	}

	public void setCompras(List<ListaDeCompra> compras) {
		this.compras = dao.listar();
	}

	public List<ListaModelo> getListasModelo() {
		return listasModelo;
	}

	public void setListasModelo(List<ListaModelo> listasModelo) {
		this.listasModelo = listasModelo;
	}

	public void setListaModelo(ListaModelo listaModelo) {
		this.listaModelo = listaModelo;
	}

	public ListaModelo getListaModelo() {
		return listaModelo;
	}

	public Integer getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(Integer itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public List<ItemDeConsumo> getItens() {
		return itens;
	}

	public void setItens(List<ItemDeConsumo> itens) {
		this.itens = itens;
	}

	public Integer getListaSelecionada() {
		return listaSelecionada;
	}

	public void setListaSelecionada(Integer listaSelecionada) {
		this.listaSelecionada = listaSelecionada;
		System.out.println("Configurei id: " + this.listaSelecionada);
	}

	public ItemDeConsumo getItem() {
		return item;
	}

	public void setItem(ItemDeConsumo item) {
		this.item = item;
	}

	public void defineListaSelecionada() {
		this.setItens(daoListaModelo.listarItens(listaSelecionada));
//		daoListaModelo.listarItens(listaSelecionada).forEach(item -> System.out.println("Item: " + item.getNome()));
		itens.forEach(item -> System.out.println("Item: " + item.getNome()));
		
	}
}
