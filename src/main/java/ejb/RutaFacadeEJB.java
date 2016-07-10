package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import facade.AbstractFacade;
import facade.RutaFacade;
import model.Ruta;

@Stateless
public class RutaFacadeEJB extends AbstractFacade<Ruta> implements RutaFacade{

  @PersistenceContext(unitName="mydbPU")
  private EntityManager em;

  public RutaFacadeEJB(){
    super(Ruta.class);
  }

  @Override
  protected EntityManager getEntityManager(){
    return this.em;
  }
}
