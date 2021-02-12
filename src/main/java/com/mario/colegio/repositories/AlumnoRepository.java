package com.mario.colegio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mario.colegio.dtos.Alumno;
import com.mario.colegio.entidades.AlumnoEntity;

public interface AlumnoRepository extends CrudRepository<AlumnoEntity, Integer> {
	
	@Query(value = "select new com.mario.colegio.dtos.Alumno (a.id, a.nombre, m.nombre, m.idMunicipio, a.famNumerosa) "
			+ "FROM com.mario.colegio.entidades.AlumnoEntity a, com.mario.colegio.entidades.MunicipiosEntity  m "
			+ "WHERE a.idMunicipio = m.idMunicipio "
			+ "AND (a.id LIKE CONCAT('%',:id,'%') or :id is null) "
			+ "AND a.nombre LIKE CONCAT ('%',:nombre,'%') ")
	List<Alumno>buscaAlumnoporIdyNombre(@Param("id")Integer id,@Param("nombre")String nombre);
}

