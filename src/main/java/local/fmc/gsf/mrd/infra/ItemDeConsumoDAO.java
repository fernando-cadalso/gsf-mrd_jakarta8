package local.fmc.gsf.mrd.infra;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import local.fmc.gsf.mrd.dominio.ItemDeConsumo;

@Stateless
public class ItemDeConsumoDAO {

	@PersistenceContext
	protected EntityManager em;

	@PostConstruct
	public void daoCarregado() {
		System.out.println("[INFO] DAO para item de consumo foi carregado.");
	}

	public void salvar(ItemDeConsumo item) {
		em.persist(item);
	}

	public void atualizar(ItemDeConsumo item) {

		em.merge(item);
	}

	public List<ItemDeConsumo> listarTodos() {

		try {
			em.createQuery("SELECT i FROM ItemDeConsumo i", ItemDeConsumo.class).getResultList();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Nâo foi possível abrir a lista de itens de consumo: " + e.getMessage()));
			System.out.println("Nâo foi possível abrir a lista de itens de consumo: " + e.getMessage());
		}

		return em.createQuery("SELECT i FROM ItemDeConsumo i", ItemDeConsumo.class).getResultList();
	}

	public ItemDeConsumo consultar(Integer id) {
		return em.find(ItemDeConsumo.class, id);
	}

}
