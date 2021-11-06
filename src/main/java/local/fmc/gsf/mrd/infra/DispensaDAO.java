package local.fmc.gsf.mrd.infra;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import local.fmc.gsf.mrd.dominio.Dispensa;
import local.fmc.gsf.mrd.dominio.ItemDaCasa;

@Stateless
public class DispensaDAO {

	@PersistenceContext
	private EntityManager em;
	
	@PostConstruct
	public void daoCarregado() {
		System.out.println("[INFO] DAO para dispensa foi carregado.");
	}

	public List<Dispensa> listar() {

		return em.createQuery("SELECT d FROM Dispensa d", Dispensa.class).getResultList();
	}

}
