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

import facade.EstacionamientoFacade;
import model.Estacionamiento;

@Path("/estacionamientos")
public class EstacionamientoService {
	
	@EJB 
	EstacionamientoFacade estacionamientoFacadeEJB;
	
	Logger logger = Logger.getLogger(EstacionamientoService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Estacionamiento> findAll(){
		return estacionamientoFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Estacionamiento find(@PathParam("id") Integer id) {
        return estacionamientoFacadeEJB.find(id);
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(Estacionamiento entity) {
		estacionamientoFacadeEJB.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Estacionamiento entity) {
    	entity.setIdestacionamiento(id.intValue());
    	estacionamientoFacadeEJB.edit(entity);
    }
	

}