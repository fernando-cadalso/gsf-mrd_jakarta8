package local.fmc.gsf.mrd.infra;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import local.fmc.gsf.mrd.dominio.ListaDeCompra;

@Stateless
public class ListaDeCompraDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void salvar(ListaDeCompra lista) {
		em.persist(lista);
	}
	
	public void atualizar(ListaDeCompra lista) {
		em.merge(lista);
	}
	
	public void excluir(ListaDeCompra lista) {
		em.remove(lista);
	}
	
	public ListaDeCompra buscarPeloId(Integer id) {
		return em.find(ListaDeCompra.class, id);
	}
	
	public List<ListaDeCompra> listar(){
		return em.createQuery("SELECT lm FROM ListaDeCompra lm", ListaDeCompra.class).getResultList();
	}
}
