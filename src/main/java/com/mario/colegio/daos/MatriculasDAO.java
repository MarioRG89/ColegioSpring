package com.mario.colegio.daos;

import java.util.List;

import com.mario.colegio.dtos.Matriculas;

public interface MatriculasDAO {
	List<Matriculas> obtenerMatriculas(Integer idAsignatura, String nombreAsignatura,String nombreAlumno, Integer idAlumno,
			String fecha);
	Integer insertarMatriculas(Integer idAsignatura, Integer idAlumno, String fecha, Double importe);
	Integer borrarMatriculas(Integer id);
	Integer calcularNumeroAsignaturas(Integer idAlumno);
}
