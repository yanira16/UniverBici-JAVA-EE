package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.Ruta_has_usuarioFacade;
import model.Ruta;
import model.Usuario;
import model.Ruta_has_usuario;

@Stateless
public class Ruta_has_usuarioFacadeEJB extends AbstractFacade<Ruta_has_usuario> implements Ruta_has_usuarioFacade{

  @PersistenceContext(unitName="mydbPU")
  private EntityManager em;

  public Ruta_has_usuarioFacadeEJB(){
    super(Ruta_has_usuario.class);
  }
  
  @Override
	public List<Ruta_has_usuario> rutasde(int id){
		return em.createNativeQuery("SELECT  *  FROM ruta_has_usuario WHERE idusuario="+id
				, Ruta_has_usuario.class).getResultList();
		}

  @Override
  protected EntityManager getEntityManager(){
    return this.em;
  }
}
