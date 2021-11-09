package local.fmc.gsf.mrd.infra;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
		estaVazio();
	}

	public void atualizar(Dispensa dispensa) {
		em.merge(dispensa);
	}

	public Dispensa buscaPeloID(Integer id) {
		return em.find(Dispensa.class, id);
	}

	public List<Dispensa> listar() {

		try {
			em.createQuery("SELECT d FROM Dispensa d", Dispensa.class).getResultList();
		} catch (NoResultException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Nâo foi possível abrir a lista de dispensas: " + e.getMessage()));
			System.out.println("Nâo foi possível abrir a lista de dispensas: " + e.getMessage());
		}

		return em.createQuery("SELECT d FROM Dispensa d", Dispensa.class).getResultList();

	}

	public void excluir(Dispensa dispensa) {

		Dispensa find = em.find(Dispensa.class, dispensa.getId());
		em.remove(find);
		estaVazio();

	}

	public boolean estaVazio() {
		boolean empty = em.createQuery("SELECT d FROM Dispensa d", Dispensa.class).getResultList().isEmpty();
//		FacesContext.getCurrentInstance().addMessage(null,
//				new FacesMessage(FacesMessage.SEVERITY_INFO, "SGBD vazio?", String.valueOf(empty)));

		return empty;

	}

}
