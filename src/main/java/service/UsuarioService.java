package service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

import facade.UsuarioFacade;
import model.Usuario;


@Path("/usuarios")
public class UsuarioService {
	
	@EJB 
	UsuarioFacade usuarioFacadeEJB;
	
	Logger logger = Logger.getLogger(UsuarioService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Usuario> findAll(){
		return usuarioFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Usuario find(@PathParam("id") Integer id) {
        return usuarioFacadeEJB.find(id);
    }
	
	
	@GET
    @Path("{id}/cercanos") 
    @Produces({"application/xml", "application/json"})
    public List<Usuario> cercanos(@PathParam("id") Integer id) {
		Usuario user = usuarioFacadeEJB.find(id);
        return usuarioFacadeEJB.cercanos(user.getUbi_xUsuario(), user.getUbi_yUsuario());
    }
	
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(Usuario entity) {
		usuarioFacadeEJB.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Usuario entity) {
    	entity.setIdusuario(id.intValue());
    	usuarioFacadeEJB.edit(entity);
    }
	
    @POST
	@Path("login")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response registro(JsonObject entrada){
		if(entrada.getString("nickname").matches("[a-zA-z0-9_]+[a-zA-z0-9_.]*")){
			return usuarioFacadeEJB.login(entrada);
		} else {
			JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
			jsonObjBuilder.add("ERROR", "El nickname posee caracteres invalidos");
			JsonObject jsonObj = jsonObjBuilder.build();
			return Response.status(Response.Status.OK).entity(jsonObj).build();
		}
		
	}

}