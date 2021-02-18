package com.mario.colegio.daos;

import java.util.List;

import com.mario.colegio.dtos.Alumno;

public interface AlumnoDao {

	List<Alumno> obtenerTodosAlumnos();
	List<Alumno> obtenerAlumnosporIdyNombre(Integer id, String nombre);
	Integer insertarAlumnos(Integer id, String nombre, Integer idMunicipio, Integer familiaNumerosa);
	Integer actualizarAlumnos(Integer idOld, String nombre, Integer idMunicipio,
			Integer familiaNumerosa);
	Integer borrarAlumno(Integer id);
	boolean alumnoFamiliaNumerosa(Integer idAlumno );
;}
