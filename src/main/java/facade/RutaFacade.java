package facade;

import java.util.List;

import javax.ejb.Local;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;

import model.Ruta;

@Local
public interface RutaFacade{
  public void create(Ruta entity);

  public void edit(Ruta entity);

  public void remove(Ruta entity);

  public Ruta find(Object id);

  public List<Ruta> findAll();

  public List<Ruta> findRange(int[] range);

  public int count();
}
