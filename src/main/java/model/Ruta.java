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
@Table(name="ruta")
@NamedQueries({
  @NamedQuery(name="Ruta.findAll",query="SELECT a FROM Ruta a")
})

public class Ruta implements Serializable{
  private static final long serialVersionUID=1l;

  @Id
  @Column(name="idruta",unique=true,nullable=false)
  private int idruta;

  @Column(name="nombreRuta",nullable=false,length=45)
  private String nombreRuta;

  @Column(name="calificacion",nullable=false)
  private float calificacion;

  @Column(name="inicio_ubi_x",nullable=false)
  private float inicio_ubi_x;

  @Column(name="inicio_ubi_y",nullable=false)
  private float inicio_ubi_y;

  @Column(name="fin_ubi_x",nullable=false)
  private float fin_ubi_x;

  @Column(name="fin_ubi_y",nullable=false)
  private float fin_ubi_y;

  

  public  Ruta(){

  }

  public int getIdRuta(){
    return idruta;
  }
  public void setIdRuta(int idruta){
    this.idruta=idruta;
  }

  public String getNombreRuta(){
    return nombreRuta;
  }
  public void setNombreRuta(String nombreRuta){
    this.nombreRuta=nombreRuta;
  }

  public float getCalificacion(){
    return calificacion;
  }
  public void setCalificacion(float calificacion){
    this.calificacion=calificacion;
  }

  public float getInicio_ubi_x(){
    return inicio_ubi_x;
  }
  public void setInicio_ubi_x(float inicio_ubi_x){
    this.inicio_ubi_x=inicio_ubi_x;
  }
  public float getInicio_ubi_y(){
    return inicio_ubi_y;
  }
  public void setInicio_ubi_y(float inicio_ubi_y){
    this.inicio_ubi_y=inicio_ubi_y;
  }

  public float getFin_ubi_x(){
    return fin_ubi_x;
  }
  public void setFin_ubi_x(float fin_ubi_x){
    this.fin_ubi_x=fin_ubi_x;
  }

  public float getFin_ubi_y(){
    return fin_ubi_y;
  }
  public void setFin_ubi_y(float fin_ubi_y){
    this.fin_ubi_y=fin_ubi_y;
  }



}
