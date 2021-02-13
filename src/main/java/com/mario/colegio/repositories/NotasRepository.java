package com.mario.colegio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mario.colegio.dtos.Notas;
import com.mario.colegio.entidades.NotasEntity;



public interface NotasRepository  extends CrudRepository<NotasEntity, Integer>{

	@Query(value = "select new com.mario.colegio.dtos.Notas (n.id, a.id, asig.id,n.nota,n.fecha,a.nombre, asig.nombre) "
			+ "FROM com.mario.colegio.entidades.NotasEntity n JOIN com.mario.colegio.entidades.AlumnoEntity a ON n.alumnos.id = a.id "
			+ "JOIN com.mario.colegio.entidades.AsignaturasEntity asig ON n.asignaturas.id = asig.id "
			+ "WHERE (a.id LIKE CONCAT('%',:idAlumno,'%') or :idAlumno is null) "
			+ "AND a.nombre LIKE CONCAT ('%',:nombre,'%') "
			+ "AND asig.nombre LIKE CONCAT ('%',:asignatura,'%') "
			+ "AND (n.nota LIKE CONCAT ('%',:nota,'%' ) or :nota is null ) "
			+ "AND n.fecha LIKE CONCAT ('%',:fecha,'%') or :fecha is null")
			  List<Notas> buscaNotas( @Param("idAlumno") Integer idAlumno,@Param("nota") Integer nota,@Param("fecha") String fecha,
					  @Param("nombre") String nombre, @Param("asignatura") String asignatura);
	
	@Query(value = "select new com.mario.colegio.dtos.Notas (n.id,a.id,asig.id,n.nota,n.fecha,a.nombre, asig.nombre) "
			+ "FROM com.mario.colegio.entidades.NotasEntity n JOIN com.mario.colegio.entidades.AlumnoEntity a ON n.alumnos.id = a.id "
			+ "JOIN com.mario.colegio.entidades.AsignaturasEntity asig ON n.asignaturas.id = asig.id where "
			+ "a.nombre LIKE CONCAT ('%',:nombre,'%') "
			+ "AND asig.nombre LIKE CONCAT ('%',:asignatura,'%') "
			+ "AND n.fecha LIKE CONCAT ('%',:fecha,'%') or :fecha is null")
			  List<Notas> buscaNotasAlumnoAsignatura( @Param("fecha") String fecha,
					  @Param("nombre") String nombre, @Param("asignatura") String asignatura);
}
