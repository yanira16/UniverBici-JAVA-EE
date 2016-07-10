package facade;

import java.util.List;

import javax.ejb.Local;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;

import model.Usuario;


@Local
public interface UsuarioFacade {

	public void create(Usuario entity);

	public void edit(Usuario entity);

	public void remove(Usuario entity);

	public Usuario find(Object id);

	public List<Usuario> findAll();

	public List<Usuario> findRange(int[] range);
	
	public List<Usuario> cercanos(float ubix, float ubiy);

	public Response login(JsonObject datos);

	public int count();

}