package com.mario.colegio.dtos;

public class TasaDto {
	int idAlumno;
	int idAsignatura;
	
	
	
	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	public int getIdAsignatura() {
		return idAsignatura;
	}
	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}
	public TasaDto(int idAlumno, int idAsignatura) {
		super();
		this.idAlumno = idAlumno;
		this.idAsignatura = idAsignatura;
	}
	
	
	
}
