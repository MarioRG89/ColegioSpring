package com.mario.colegio.negocio;

import org.springframework.stereotype.Service;

@Service
public class Negocio implements NegocioIN {

	public Negocio() {

	}

	public double obtenerTasa(Integer idAlumno, Integer idAsignatura) {
		return 0;

		/*int numAsig = a.calcularNumeroAsignaturas(idAlumno);
		double tasa = a.recuperarTasaAsignatura(idAsignatura);
		boolean famNumerosa = al.alumnoFamiliaNumerosa(idAlumno);
		

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
*/
	}
}
