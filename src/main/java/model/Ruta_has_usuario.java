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

@Entity
@Table(name="ruta_has_usuario")
@NamedQuery(name="Ruta_has_usuario.findAll",query="SELECT a FROM Ruta_has_usuario a")
public class Ruta_has_usuario implements Serializable{
  private static final long serialVersionUID=1L;

  @Id
  @Column(name="idruta",unique=true,nullable=false)
  private int idruta;

  @Id
  @Column(name="idusuario",unique=true,nullable=false)
  private int idusuario;

  @Column(name="pertenencia",nullable=false)
  private int pertenencia;

  @ManyToOne
  @PrimaryKeyJoinColumn(name="idruta",referencedColumnName="idruta")
  private Ruta ruta;

  @ManyToOne
  @PrimaryKeyJoinColumn(name="idusuario",referencedColumnName="idusuario")
  private Usuario usuario;

  public Ruta_has_usuario(){
  }

  public Ruta getRuta(){
    return this.ruta;
  }

  public Usuario getUsuario(){
    return this.usuario;
  }

  public int getRutaId(){
    return this.idruta;
  }

  public int getUsuarioId(){
    return this.idusuario;
  }

  public void setIdRuta(int idruta){
    this.idruta=idruta;
  }

  public void setIdUsuario(int idusuario){
    this.idusuario=idusuario;
  }

  public void setRuta(Ruta ruta){
    this.ruta=ruta;
  }
  public void setUsuario(Usuario usuario){
    this.usuario=usuario;
  }

  public int getPertenencia(){
    return this.pertenencia;
  }
  public void setPertenencia(int pertenencia){
    this.pertenencia=pertenencia;
  }
}
