package local.fmc.gsf.mrd.infra;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import local.fmc.gsf.mrd.dominio.ItemDeConsumo;
import local.fmc.gsf.mrd.dominio.ListaModelo;

@Stateless
public class ListaModeloDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void salvar(ListaModelo lista) {
		em.persist(lista);
	}
	
	public void atualizar(ListaModelo lista) {
		em.merge(lista);
	}
	
	public void excluir(ListaModelo lista) {
		ListaModelo listaExcluida = em.find(ListaModelo.class, lista.getId());
		em.remove(listaExcluida);
	}
	
	public ListaModelo buscarPeloId(Integer id) {
		return em.find(ListaModelo.class, id);
	}
	
	public List<ListaModelo> listar(){
		return em.createQuery("SELECT lm FROM ListaModelo lm", ListaModelo.class).getResultList();
	}
	
	public List<ItemDeConsumo> listarItens(Integer listaId) {
		return em.find(ListaModelo.class, listaId).getItens();
	}
}
