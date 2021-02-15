package com.mario.colegio.daos.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mario.colegio.daos.NotasDAO;
import com.mario.colegio.dtos.Notas;
import com.mario.colegio.entidades.AlumnoEntity;
import com.mario.colegio.entidades.AsignaturasEntity;
import com.mario.colegio.entidades.NotasEntity;
import com.mario.colegio.repositories.AlumnoRepository;
import com.mario.colegio.repositories.AsignaturaRepository;
import com.mario.colegio.repositories.NotasRepository;

@Service
public class NotasDAOImpl implements NotasDAO {

	@Autowired
	private AlumnoRepository alumno;
	@Autowired
	private AsignaturaRepository asignatura;
	@Autowired
	private NotasRepository notasRepository;
	
	@Override
	public List<Notas> obtenerNotas(Integer idAlumno, String nombreAlumno, String nombreAsignatura, Integer nota,
			String fecha) {
		List<Notas> listaNotas = notasRepository.buscaNotas(idAlumno, nota, fecha, nombreAlumno, nombreAsignatura);
		return listaNotas;
	}

	@Override
	public List<Notas> obtenerNotasPorAlumnoAsignaturaFecha(String nombreAlumno,
			String nombreAsignatura, String fecha) {
		List<Notas> listaNotas = notasRepository.buscaNotasAlumnoAsignatura(fecha, nombreAlumno, nombreAsignatura);
		return listaNotas;
	}

	@Override
	public Integer insertarNotas(Integer idAsignatura, Integer idAlumno, Integer nota, String fecha) {
		Optional<AlumnoEntity> optinalAlumno = alumno.findById(idAlumno);
		AlumnoEntity a = optinalAlumno.get();
		Optional<AsignaturasEntity> optinalAsignatura = asignatura.findById(idAsignatura);
		AsignaturasEntity asig = optinalAsignatura.get();
		NotasEntity n = new NotasEntity(a, asig, nota, fecha);
		notasRepository.save(n);
		return 1;
	}

	@Override
	public Integer modificarNotas( Integer id, Integer idAlumno, Integer idAsignatura, Integer nota, String fecha) {
		
		Optional<AlumnoEntity> optinalAlumno = alumno.findById(idAlumno);
		AlumnoEntity a = optinalAlumno.get();
		Optional<AsignaturasEntity> optinalAsignatura = asignatura.findById(idAsignatura);
		AsignaturasEntity asig = optinalAsignatura.get();
		NotasEntity n = new NotasEntity(a, asig, nota, fecha,id);
		notasRepository.save(n);
		return 1;
	}

	@Override
	public Integer borrarNotas(Integer id) {
		notasRepository.deleteById(id);
		return null;
	}

}
