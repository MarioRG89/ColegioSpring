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
@Table(name="notas")
public class NotasEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(cascade=CascadeType.PERSIST,fetch = FetchType.EAGER)
	//@MapsId("id")
	@JoinColumn(name="id_alumnos")
	private AlumnoEntity alumnos;
	
	@ManyToOne(cascade=CascadeType.PERSIST,fetch = FetchType.EAGER)
	//@MapsId("id")
	@JoinColumn(name="id_asignaturas")
	private AsignaturasEntity asignaturas;
	
	
	@Column(name="nota")
	private int nota;
	
	@Column(name="fecha")
	private String fecha;
	public NotasEntity( AlumnoEntity alumnos, AsignaturasEntity asignaturas, int nota, String fecha,int id) {
		super();
		this.alumnos = alumnos;
		this.asignaturas = asignaturas;
		this.nota = nota;
		this.fecha = fecha;
		this.id=id;
	}

	
	

	public NotasEntity(AlumnoEntity alumnos, AsignaturasEntity asignaturas, int nota, String fecha) {
		super();
		this.alumnos = alumnos;
		this.asignaturas = asignaturas;
		this.nota = nota;
		this.fecha = fecha;
	}




	public NotasEntity() {
		super();
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


	


	public double getNota() {
		return nota;
	}


	public void setNota(int nota) {
		this.nota = nota;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	

	
	
}
