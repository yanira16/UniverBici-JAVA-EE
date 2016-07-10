package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EntradaU database table.
 * 
 */
@Entity
@Table(name="entradaU")
@NamedQuery(name="Entrada.findAll", query="SELECT a FROM EntradaU a")
public class EntradaU implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="identradaU", unique=true, nullable=false)
	private int identradaU;

	@Column(name="nombreEntrada", nullable=false, length=45)
	private String nombreEntrada;
	
	@Column(name="ubi_xEntrada", nullable=false)
	private float ubi_xEntrada;
	
	@Column(name="ubi_yEntrada", nullable=false)
	private float ubi_yEntrada;
	
	public EntradaU() {
	}

	public int getIdentradaU() {
		return identradaU;
	}

	public void setIdentradaU(int identradaU) {
		this.identradaU = identradaU;
	}

	public String getNombreEntrada() {
		return nombreEntrada;
	}

	public void setNombreEntrada(String nombreEntrada) {
		this.nombreEntrada = nombreEntrada;
	}

	public float getUbi_xEntrada() {
		return ubi_xEntrada;
	}

	public void setUbi_xEntrada(float ubi_xEntrada) {
		this.ubi_xEntrada = ubi_xEntrada;
	}

	public float getUbi_yEntrada() {
		return ubi_yEntrada;
	}

	public void setUbi_yEntrada(float ubi_yEntrada) {
		this.ubi_yEntrada = ubi_yEntrada;
	}

	
	
	
	
	
}
