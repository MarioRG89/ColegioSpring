package com.mario.colegio.negocio;

import com.mario.colegio.daos.AsignaturasDAO;

public class Negocio implements NegocioIN {

	public Negocio() {

	}

	public double obtenerTasa(String idAlumno, String idAsignatura) {
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
