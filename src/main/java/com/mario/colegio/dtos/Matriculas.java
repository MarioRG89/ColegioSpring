package com.mario.colegio.dtos;

public class Matriculas {
	private int id;
	private int idAsignatura;
	private String nombreAsignatura;
	private int idAlumno;
	private String nombreAlumno;
	private int activo;
	private String fecha;
	
	
	
	public Matriculas(int id, int idAsignatura, String nombreAsignatura, int idAlumno, String nombreAlumno, int activo,
			String fecha) {
		super();
		this.id = id;
		this.idAsignatura = idAsignatura;
		this.nombreAsignatura = nombreAsignatura;
		this.idAlumno = idAlumno;
		this.nombreAlumno = nombreAlumno;
		this.activo = activo;
		this.fecha = fecha;
	}

	public Matriculas() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAsignatura() {
		return idAsignatura;
	}
	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}
	public String getNombreAsignatura() {
		return nombreAsignatura;
	}
	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}
	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	public String getNombreAlumno() {
		return nombreAlumno;
	}
	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
}
