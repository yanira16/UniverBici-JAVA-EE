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

import facade.RutaFacade;
import model.Ruta;

@Path("/rutas")
public class RutaService{

  @EJB
  RutaFacade rutaFacadeEJB;

  Logger logger = Logger.getLogger(RutaService.class.getName());

  @GET
    @Produces({"application/xml","application/json"})
    public List<Ruta> findAll(){
      return rutaFacadeEJB.findAll();
    }

  @GET
    @Path("{id}")
    @Produces({"application/xml","application/json"})
    public Ruta find(@PathParam("id") Integer id){
      return rutaFacadeEJB.find(id);
    }

  @POST
    @Consumes({"application/xml","application/json"})
    public void create(Ruta entity){
      rutaFacadeEJB.create(entity);
    }
  @PUT
    @Path("{id}")
    @Consumes({"application/xml","application/json"})
    public void edit(@PathParam("id")Integer id, Ruta entity){
      entity.setIdRuta(id.intValue());
      rutaFacadeEJB.edit(entity);
    }

}
