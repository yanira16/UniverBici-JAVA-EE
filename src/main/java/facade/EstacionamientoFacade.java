package facade;

import java.util.List;

import javax.ejb.Local;

import model.Estacionamiento;

@Local
public interface EstacionamientoFacade {

	public void create(Estacionamiento entity);

	public void edit(Estacionamiento entity);

	public void remove(Estacionamiento entity);

	public Estacionamiento find(Object id);

	public List<Estacionamiento> findAll();

	public List<Estacionamiento> findRange(int[] range);

	public int count();

}