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



import facade.Ruta_has_usuarioFacade;
import facade.RutaFacade;
import facade.UsuarioFacade;

import model.Ruta_has_usuario;
import model.Ruta;
import model.Usuario;

@Path("/rutasusuarios")
public class Ruta_has_usuarioService{


  @EJB
  Ruta_has_usuarioFacade Ruta_has_usuarioFacadeEJB;
  RutaFacade RutaFacadeEJB;
  UsuarioFacade UsuarioFacadeEJB;

  Logger logger = Logger.getLogger(Ruta_has_usuarioService.class.getName());

  @GET
  @Produces({"application/xml", "application/json"})
  public List<Ruta_has_usuario> findAll(){
		return Ruta_has_usuarioFacadeEJB.findAll();
  }

  @GET
  @Path("{id}")
  @Produces({"application/xml", "application/json"})
  public Ruta_has_usuario find(@PathParam("id") Integer id) {
      return Ruta_has_usuarioFacadeEJB.find(id);
  }
  
  @GET
  @Path("de/{id}")
  @Produces({"application/xml", "application/json"})
  public List<Ruta_has_usuario> rutasde(@PathParam("id") Integer id) {
      return Ruta_has_usuarioFacadeEJB.rutasde(id);
  }

	@POST
  @Consumes({"application/xml", "application/json"})
  public void create(Ruta_has_usuario entity) {
	Ruta_has_usuarioFacadeEJB.create(entity);
  }

  @PUT
  @Path("{id}")
  @Consumes({"application/xml", "application/json"})
  public void edit(@PathParam("id") Integer id, Ruta_has_usuario entity) {
  	entity.setIdRuta(id.intValue());
  	Ruta_has_usuarioFacadeEJB.edit(entity);
  }

}
