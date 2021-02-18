package com.mario.colegio.daos.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mario.colegio.daos.AlumnoDao;
import com.mario.colegio.dtos.Alumno;
import com.mario.colegio.entidades.AlumnoEntity;
import com.mario.colegio.repositories.AlumnoRepository;


@Service
public class AlumnoDAOImpl implements AlumnoDao {

	@Autowired
	private AlumnoRepository alumnoRepository; 
	
	@Override
	public List<Alumno> obtenerTodosAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> obtenerAlumnosporIdyNombre(Integer id, String nombre) {
		List<Alumno> listaAlumnos= alumnoRepository.buscaAlumnoporIdyNombre(id, nombre);
		return listaAlumnos;
	}

	@Override
	public Integer insertarAlumnos(Integer id, String nombre, Integer idMunicipio, Integer familiaNumerosa) {
		familiaNumerosa = (familiaNumerosa == null) ? 0 : 1;
		AlumnoEntity a = new AlumnoEntity(id, nombre, idMunicipio, familiaNumerosa);
		alumnoRepository.save(a);
		return 1;
	}

	@Override
	public Integer actualizarAlumnos(Integer idOld, String nombre, Integer idMunicipio,
			Integer familiaNumerosa) {
		familiaNumerosa = (familiaNumerosa == null) ? 0 : 1;
		AlumnoEntity alumno=new AlumnoEntity(idOld,nombre,idMunicipio,familiaNumerosa);
		alumnoRepository.save(alumno);
		return 1;
	}

	@Override
	public Integer borrarAlumno(Integer id) {
		alumnoRepository.deleteById(id);
		return 1;
	}

	@Override
	public boolean alumnoFamiliaNumerosa(Integer idAlumno) {
		Optional<AlumnoEntity> optinalAlumno = alumnoRepository.findById(idAlumno);
		AlumnoEntity a = optinalAlumno.get();
		boolean famNum = (a.getFamNumerosa() == 1) ? true : false;
		return famNum;
	}

}
