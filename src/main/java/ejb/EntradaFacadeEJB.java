package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import facade.AbstractFacade;
import facade.EntradaFacade;
import model.EntradaU;

@Stateless
public class EntradaFacadeEJB extends AbstractFacade<EntradaU> implements EntradaFacade {
	
	
	@PersistenceContext(unitName = "mydbPU")
	private EntityManager em;
	
	public EntradaFacadeEJB() {
		super(EntradaU.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
	
	
	
	

}
