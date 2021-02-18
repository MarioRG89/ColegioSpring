package com.mario.colegio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mario.colegio.dtos.Matriculas;
import com.mario.colegio.entidades.MatriculasEntity;

public interface MatriculacionesRepository extends CrudRepository<MatriculasEntity, Integer> {

	@Query(value="select new com.mario.colegio.dtos.Matriculas(m.id,asig.id,asig.nombre,a.id,a.nombre,m.activo,m.fecha) "
			+ "from com.mario.colegio.entidades.MatriculasEntity m join com.mario.colegio.entidades.AlumnoEntity a on a.id=m.alumnos.id "
			+ "join com.mario.colegio.entidades.AsignaturasEntity asig on asig.id=m.asignaturas.id "
			+ "where (a.id like concat('%',:idAlumno,'%') or :idAlumno is null) "
			+ "and a.nombre like concat('%',:nombreAlumno,'%') "
			+ "and asig.nombre like concat('%',:nombreAsignatura,'%') "
			+ "and (asig.id like concat('%',:idAsignatura,'%') or :idAsignatura is null) "
			+ "and m.fecha like concat ('%',:fecha,'%')")
   List<Matriculas>buscaMatriculas(@Param("idAlumno")Integer idAlumno,@Param("nombreAlumno")String nombreAlumno,@Param("nombreAsignatura")String nombreAsignatura,@Param("idAsignatura")Integer idAsignatura,@Param("fecha")String fecha) ;

}
