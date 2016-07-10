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

import facade.EntradaFacade;
import model.EntradaU;

@Path("/entradas")
public class EntradaService {
	
	@EJB 
	EntradaFacade entradaFacadeEJB;
	
	Logger logger = Logger.getLogger(EntradaService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<EntradaU> findAll(){
		return entradaFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public EntradaU find(@PathParam("id") Integer id) {
        return entradaFacadeEJB.find(id);
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(EntradaU entity) {
		entradaFacadeEJB.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, EntradaU entity) {
    	entity.setIdentradaU(id.intValue());
    	entradaFacadeEJB.edit(entity);
    }
	

}