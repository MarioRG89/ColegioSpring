package com.mario.colegio.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mario.colegio.daos.AlumnoDao;
import com.mario.colegio.daos.AsignaturasDAO;
import com.mario.colegio.daos.MatriculasDAO;

@Service
public class Negocio implements NegocioIN {

	public Negocio() {

	}
	@Autowired
	private MatriculasDAO matricula;
	@Autowired
	private AlumnoDao alumno;
	@Autowired
	private AsignaturasDAO asignatura;
	public double obtenerTasa(Integer idAlumno, Integer idAsignatura) {
		
		int numAsig = matricula.calcularNumeroAsignaturas(idAlumno);
		double tasa = asignatura.recuperarTasaAsignatura(idAsignatura);
		boolean famNumerosa = alumno.alumnoFamiliaNumerosa(idAlumno);
		

		if ((numAsig >= 3) && (numAsig <= 5)) {
			tasa = tasa * 0.7;
		}
		if (numAsig >= 6) {
			tasa = tasa * 0.5;
		}
		if (famNumerosa) {
			tasa = tasa * 0.5;
		}

		return tasa;

	}
}
