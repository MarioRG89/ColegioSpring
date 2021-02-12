package com.mario.colegio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asignaturas")
public class AsignaturasEntity {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name = "curso")
	private int curso;
	
	@Column(name ="tasa")
	private Double tasa;

	public AsignaturasEntity() {
		super();
	}

	public AsignaturasEntity(int id, String nombre, int curso, double tasa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
		this.tasa = tasa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public Double getTasa() {
		return tasa;
	}

	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}
	
	
}
