package local.fmc.gsf.mrd.infra;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import local.fmc.gsf.mrd.dominio.ItemDaCasa;

@Stateless
public class ItemDaCasaDAO {

	@PersistenceContext
	protected EntityManager em;

	@PostConstruct
	public void daoCarregado() {
		System.out.println("[INFO] DAO para item da casa foi carregado.");
	}

	public void salvar(ItemDaCasa item) {
		em.persist(item);
	}

	public List<ItemDaCasa> listar() {

		return em.createQuery("SELECT i FROM ItemDaCasa i", ItemDaCasa.class).getResultList();
	}

}
