package local.fmc.gsf.mrd.infra;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import local.fmc.gsf.mrd.dominio.Dispensa;

@Stateless
public class DispensaDAO {

	@PersistenceContext
	private EntityManager em;

	@PostConstruct
	public void daoCarregado() {
		System.out.println("[INFO] DAO para dispensa foi carregado.");
	}

	public void salvar(Dispensa dispensa) {
		em.persist(dispensa);
	}

	public List<Dispensa> listar() {

		try {
			em.createQuery("SELECT d FROM Dispensa d", Dispensa.class).getResultList();
		} catch (RuntimeException e) {
			System.out.println("Nâo foi possível abrir a lista de dispensas: " + e.getMessage());
		}

		return em.createQuery("SELECT d FROM Dispensa d", Dispensa.class).getResultList();

	}

}
