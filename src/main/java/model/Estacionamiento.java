package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estacionamiento database table.
 * 
 */
@Entity
@Table(name="estacionamiento")
@NamedQuery(name="Estacionamiento.findAll", query="SELECT a FROM Estacionamiento a")
public class Estacionamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idestacionamiento", unique=true, nullable=false)
	private int idestacionamiento;

	@Column(name="nombreEstacionamiento", nullable=false, length=45)
	private String nombreEstacionamiento;

	@Column(name="capacidad", nullable=false)
	private int capacidad;
	
	@Column(name="ocupados", nullable=false)
	private int ocupados;
	
	@Column(name="ubi_x", nullable=false)
	private float ubi_x;
	
	@Column(name="ubi_y", nullable=false)
	private float ubi_y;
	
	public Estacionamiento() {
	}

	public int getIdestacionamiento() {
		return idestacionamiento;
	}

	public void setIdestacionamiento(int idestacionameinto) {
		this.idestacionamiento = idestacionameinto;
	}

	public String getNombreEstacionamiento() {
		return nombreEstacionamiento;
	}

	public void setNombreEstacionamiento(String nombreEstacionamiento) {
		this.nombreEstacionamiento = nombreEstacionamiento;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getOcupados() {
		return ocupados;
	}

	public void setOcupados(int ocupados) {
		this.ocupados = ocupados;
	}

	public float getUbi_x() {
		return ubi_x;
	}

	public void setUbi_x(float ubi_x) {
		this.ubi_x = ubi_x;
	}

	public float getUbi_y() {
		return ubi_y;
	}

	public void setUbi_y(float ubi_y) {
		this.ubi_y = ubi_y;
	}

	
	
	
	
}
