package com.mario.colegio.dtos;

public class Asignaturas {

	private Integer id;
	private String nombre;
	private Integer curso;
	private double tasa;
	
	public Asignaturas() {
		// TODO Auto-generated constructor stub
	}


	public Asignaturas(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}


	public Asignaturas(Integer id, String nombre, Integer curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
	}


	public Asignaturas(Integer id, String nombre, Integer curso, Double tasa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
		this.tasa = tasa;
	}


	public Double getTasa() {
		return tasa;
	}


	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getCurso() {
		return curso;
	}


	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	
	
}
