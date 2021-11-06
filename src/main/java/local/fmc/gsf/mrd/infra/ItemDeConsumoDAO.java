package local.fmc.gsf.mrd.infra;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import local.fmc.gsf.mrd.dominio.ItemDeConsumo;
import local.fmc.gsf.mrd.dominio.ItemdeConsumo;

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

	public List<ItemdeConsumo> listar() {
		
		try {
			em.createQuery("SELECT i FROM ItemdeConsumo i", ItemdeConsumo.class).getResultList();
		} catch (Exception e) {
			System.out.println("Nâo foi possível abrir a lista de itens de consumo: " + e.getMessage());
		}
		

		return em.createQuery("SELECT i FROM ItemdeConsumo i", ItemdeConsumo.class).getResultList();
	}

}
