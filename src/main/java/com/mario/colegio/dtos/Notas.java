package com.mario.colegio.dtos;

public class Notas {

	private Integer id;
	private Integer idAlumno;
	private Integer idAsignatura;
	private Integer nota;
	private String fecha;
	private String nombreAlumno;
	private String nombreAsignatura;
	
	
	
	
	public Notas(String nombreAlumno,String nombreAsignatura ,String fecha) {
		super();
		this.fecha = fecha;
		this.nombreAlumno = nombreAlumno;
		this.nombreAsignatura = nombreAsignatura;
	}




	public Notas(Integer idAlumno,String nombreAlumno,  String nombreAsignatura, Integer nota, String fecha,Integer id) {
		super();
		this.idAlumno = idAlumno;
		this.nota = nota;
		this.fecha = fecha;
		this.nombreAlumno = nombreAlumno;
		this.nombreAsignatura = nombreAsignatura;
		this.id= id;
	}
	


	public Notas(Integer idAlumno, Integer nota, String fecha, String nombreAlumno, String nombreAsignatura) {
		super();
		this.idAlumno = idAlumno;
		this.nota = nota;
		this.fecha = fecha;
		this.nombreAlumno = nombreAlumno;
		this.nombreAsignatura = nombreAsignatura;
	}




	public Notas(Integer id, Integer idAlumno, Integer idAsignatura, Integer nota, String fecha, String nombreAlumno,
			String nombreAsignatura) {
		super();
		this.id = id;
		this.idAlumno = idAlumno;
		this.idAsignatura = idAsignatura;
		this.nota = nota;
		this.fecha = fecha;
		this.nombreAlumno = nombreAlumno;
		this.nombreAsignatura = nombreAsignatura;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public Integer getIdAlumno() {
		return idAlumno;
	}




	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}




	public Integer getIdAsignatura() {
		return idAsignatura;
	}




	public void setIdAsignatura(Integer idAsignatura) {
		this.idAsignatura = idAsignatura;
	}




	public Integer getNota() {
		return nota;
	}




	public void setNota(Integer nota) {
		this.nota = nota;
	}




	public String getFecha() {
		return fecha;
	}




	public void setFecha(String fecha) {
		this.fecha = fecha;
	}




	public String getNombreAlumno() {
		return nombreAlumno;
	}




	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}




	public String getNombreAsignatura() {
		return nombreAsignatura;
	}




	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}




	public Notas() {
		// TODO Auto-generated constructor stub
	}



}
