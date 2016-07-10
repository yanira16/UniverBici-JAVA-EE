package facade;

import java.util.List;

import javax.ejb.Local;

import model.EntradaU;

@Local
public interface EntradaFacade {

	public void create(EntradaU entity);

	public void edit(EntradaU entity);

	public void remove(EntradaU entity);

	public EntradaU find(Object id);

	public List<EntradaU> findAll();

	public List<EntradaU> findRange(int[] range);

	public int count();

}