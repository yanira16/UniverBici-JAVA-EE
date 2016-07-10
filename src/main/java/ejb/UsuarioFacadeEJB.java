package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.Response;

import facade.AbstractFacade;
import facade.UsuarioFacade;
import model.Usuario;



@Stateless
public class UsuarioFacadeEJB extends AbstractFacade<Usuario> implements UsuarioFacade {
	
	
	@PersistenceContext(unitName = "mydbPU")
	private EntityManager em;
	
	public UsuarioFacadeEJB() {
		super(Usuario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
	
	@Override
	public List<Usuario> cercanos(float ubix,float ubiy){
		return em.createNativeQuery("SELECT  *, ( 3959 * acos( cos( radians("+ ubix +") ) "
				+ "* cos( radians( u.ubi_xUsuario ) ) *  cos( radians( u.ubi_yUsuario ) - radians("+ ubiy +") ) + "
				+ "sin( radians("+ ubix +") ) * sin( radians( u.ubi_xUsuario ) ) ) ) AS distance FROM usuario u  HAVING distance < 0.62  "
				, Usuario.class).getResultList();
		//return em.createNamedQuery("Usuario.cercanos", Usuario.class)
        //		.setParameter("usuarioX", ubix).setParameter("usuarioY", ubiy).getResultList();
	}

	@Override
	public Response login(JsonObject datos){
		JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
		String nickname = datos.getString("nickname");
		String password = datos.getString("password");
		try{
			Usuario user = em.createNamedQuery("Usuario.findByNickname", Usuario.class)
	        		.setParameter("nickname", nickname).getSingleResult();
			if(user.getPassword().equals(password)){
				jsonObjBuilder.add("INFO", "Loggeado")
					.add("usuarioId", user.getIdusuario())
					.add("nickname",user.getNickname())
					.add("email",user.getEmail());
			} else {
				jsonObjBuilder.add("INFO", "La password no corresponde, vuelva a intentarlo");
			}
			JsonObject jsonObj = jsonObjBuilder.build();
			return Response.status(Response.Status.OK).entity(jsonObj).build();
		} catch(Exception e){
			jsonObjBuilder.add("INFO", "No existe un usuario con ese username");
			JsonObject jsonObj = jsonObjBuilder.build();
			return Response.status(Response.Status.OK).entity(jsonObj).build();
		}
	}
	


}
