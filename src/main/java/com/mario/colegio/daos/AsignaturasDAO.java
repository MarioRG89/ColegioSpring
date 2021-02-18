package com.mario.colegio.daos;

import java.util.List;

import com.mario.colegio.dtos.Asignaturas;

public interface AsignaturasDAO {

	List<Asignaturas> obtenerTodasAsignaturas(Integer id, String nombre, Integer curso, Double tasa);
	Integer insertarAsignaturas(Integer id, String nombre, Integer curso, Double tasa);
	Integer actualizarAsignaturas(Integer id, String nombre, Integer curso, Double tasa);
	Integer borrarAsignatura(Integer id);
	double recuperarTasaAsignatura(Integer idAsignatura );
}
