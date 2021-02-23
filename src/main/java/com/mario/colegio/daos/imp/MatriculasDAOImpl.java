package com.mario.colegio.daos.imp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mario.colegio.daos.MatriculasDAO;
import com.mario.colegio.dtos.Matriculas;
import com.mario.colegio.entidades.AlumnoEntity;
import com.mario.colegio.entidades.AsignaturasEntity;
import com.mario.colegio.entidades.CajaEntity;
import com.mario.colegio.entidades.MatriculasEntity;
import com.mario.colegio.repositories.AlumnoRepository;
import com.mario.colegio.repositories.AsignaturaRepository;
import com.mario.colegio.repositories.CajaRepository;
import com.mario.colegio.repositories.MatriculacionesRepository;

@Service
public class MatriculasDAOImpl implements MatriculasDAO {
	
	@Autowired
	private MatriculacionesRepository matriculaRepo;
	@Autowired
	private AlumnoRepository alumno;
	@Autowired
	private AsignaturaRepository asignatura;
	@Autowired
	private CajaRepository cajaRepo;
	
	@Override
	public List<Matriculas> obtenerMatriculas(Integer idAsignatura, String nombreAsignatura,String nombreAlumno, Integer idAlumno,
			String fecha) {
		List<Matriculas> listaMatriculas = matriculaRepo.buscaMatriculas(idAlumno, nombreAlumno, nombreAsignatura, idAsignatura, fecha);
		return listaMatriculas;
	}

	@Override
	public Integer insertarMatriculas(Integer idAsignatura, Integer idAlumno, String fecha, Double tasa) {
		if (fecha == "") {
			Date fecha_Act = new Date();
			fecha = new SimpleDateFormat("yyyy-MM-dd").format(fecha_Act);
		}
		
		Optional<AlumnoEntity> optinalAlumno = alumno.findById(idAlumno);
		AlumnoEntity a = optinalAlumno.get();
		Optional<AsignaturasEntity> optinalAsignatura = asignatura.findById(idAsignatura);
		AsignaturasEntity asig = optinalAsignatura.get();
		MatriculasEntity m =new MatriculasEntity(a,asig,fecha,1);
		matriculaRepo.save(m);
		CajaEntity caja = new CajaEntity(m,tasa);
		cajaRepo.save(caja);
		return 1;
	}

	@Override
	public Integer borrarMatriculas(Integer id) {
		cajaRepo.deleteById(id);
		matriculaRepo.deleteById(id);
		return 1;
	}

	@Override
	public Integer calcularNumeroAsignaturas(Integer idAlumno) {
		
		return matriculaRepo.calculaNumAsignaturas(idAlumno);
	}



}
