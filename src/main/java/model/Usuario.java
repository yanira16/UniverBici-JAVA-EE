package model;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Date;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQueries({
	@NamedQuery(name="Usuario.findAll", query="SELECT a FROM Usuario a"),
	@NamedQuery(name="Usuario.findById", query="SELECT a FROM Usuario a WHERE a.idusuario = :idusuario"),
	@NamedQuery(name="Usuario.findByNickname", query="SELECT a FROM Usuario a WHERE a.nickname = :nickname"),
	@NamedQuery(name="Usuario.findByEmail", query="SELECT a FROM Usuario a WHERE a.email = :email"),

})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idusuario", unique=true, nullable=false)
	private int idusuario;

	@Column(name="nombre", nullable=false, length=45)
	private String nombre;

	@Column(name="apellido", nullable=false, length=45)
	private String apellido;

	@Column(name="password", nullable=false, length=45)
	private String password;
	
	@Column(name="nickname", nullable=false, length=45)
	private String nickname;
	
	@Column(name="email", nullable=false, length=100)
	private String email;
	
	@Column(name="direccion", nullable=false, length=200)
	private String direccion;
	
	@Column(name="estacionamiento_idestacionamiento", unique=true, nullable=false)
	private int estacionamiento_idestacionamiento;
	
	@Column(name="telefono", nullable=false, length=20)
	private String telefono;
	
	@Column(name="sexo", nullable=false)
	private int sexo;
	
	@Column(name="fechaNacimiento",  nullable=false)
	private Date fechaNacimiento;
	
	@Column(name="ubi_xUsuario", nullable=true)
	private float ubi_xUsuario;
	
	@Column(name="ubi_yUsuario", nullable=true)
	private float ubi_yUsuario;
	
	public Usuario() {
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEstacionamiento_idestacionamiento() {
		return estacionamiento_idestacionamiento;
	}

	public void setEstacionamiento_idestacionamiento(int estacionamiento_idestacionamiento) {
		this.estacionamiento_idestacionamiento = estacionamiento_idestacionamiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public float getUbi_xUsuario() {
		return ubi_xUsuario;
	}

	public void setUbi_xUsuario(float ubi_xUsuario) {
		this.ubi_xUsuario = ubi_xUsuario;
	}

	public float getUbi_yUsuario() {
		return ubi_yUsuario;
	}

	public void setUbi_yUsuario(float ubi_yUsuario) {
		this.ubi_yUsuario = ubi_yUsuario;
	}

	

}