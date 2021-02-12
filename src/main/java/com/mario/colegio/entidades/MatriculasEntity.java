package com.mario.colegio.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="matriculaciones")
public class MatriculasEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(cascade=CascadeType.PERSIST,fetch = FetchType.LAZY)
	//@MapsId("id")
	@JoinColumn(name="id_alumno")
	private AlumnoEntity alumnos;
	
	@ManyToOne(cascade=CascadeType.PERSIST,fetch = FetchType.LAZY)
	//@MapsId("id")
	@JoinColumn(name="id_asignatura")
	private AsignaturasEntity asignaturas;
	
	@Column(name="fecha")
	private String fecha;
	
	@Column(name="activo")
	private int activo;
	

	
	public MatriculasEntity(AlumnoEntity alumnos, AsignaturasEntity asignaturas, String fecha, int activo) {
		super();
		this.alumnos = alumnos;
		this.asignaturas = asignaturas;
		this.fecha = fecha;
		this.activo = activo;
	}

	public MatriculasEntity() {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public AlumnoEntity getAlumnos() {
		return alumnos;
	}



	public void setAlumnos(AlumnoEntity alumnos) {
		this.alumnos = alumnos;
	}



	public AsignaturasEntity getAsignaturas() {
		return asignaturas;
	}



	public void setAsignaturas(AsignaturasEntity asignaturas) {
		this.asignaturas = asignaturas;
	}



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public int getActivo() {
		return activo;
	}



	public void setActivo(int activo) {
		this.activo = activo;
	}
	

}
