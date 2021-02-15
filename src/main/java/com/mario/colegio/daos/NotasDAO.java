package com.mario.colegio.daos;

import java.util.List;

import com.mario.colegio.dtos.Notas;

public interface NotasDAO {

	List<Notas> obtenerNotas(Integer idAlumno, String nombreAlumno, String nombreAsignatura, Integer nota,
			String fecha);

	List<Notas> obtenerNotasPorAlumnoAsignaturaFecha(String nombreAlumno,
			String nombreAsignatura, String fecha);

	Integer insertarNotas(Integer idAsignatura, Integer idAlumno, Integer nota, String fecha);

	Integer modificarNotas(Integer id, Integer idAlumno, Integer idAsignatura, Integer nota, String fecha);

	Integer borrarNotas(Integer id);
}
