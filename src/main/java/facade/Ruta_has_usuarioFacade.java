package facade;

import java.util.List;

import javax.ejb.Local;

import model.Ruta_has_usuario;

@Local
public interface Ruta_has_usuarioFacade{

  public void create(Ruta_has_usuario entity);

  public void edit(Ruta_has_usuario entity);

  public void remove(Ruta_has_usuario entity);

  public Ruta_has_usuario  find(Object id);
  
  public List<Ruta_has_usuario>  rutasde(int id);

  public List<Ruta_has_usuario> findAll();

  public List<Ruta_has_usuario> findRange(int[] range);

  public int count();
}
