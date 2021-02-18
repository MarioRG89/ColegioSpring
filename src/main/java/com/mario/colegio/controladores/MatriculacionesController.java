package com.mario.colegio.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mario.colegio.daos.CombosDAO;
import com.mario.colegio.daos.MatriculasDAO;
import com.mario.colegio.negocio.Negocio;

@Controller
public class MatriculacionesController {
	@Autowired
	private Negocio nego;
	@Autowired
	private MatriculasDAO matriculas;

	@Autowired
	private CombosDAO combo;

	@GetMapping(value = "listadomatriculaciones")
	public String Lista() {
		return "vistas/matriculaciones/listadoMatriculaciones";
	}

	@PostMapping(value = "listadomatriculaciones")
	public String Listamatriculas(@RequestParam(value = "idAsig", required = false) Integer idAsignatura,
			@RequestParam(value = "nombreAsig", required = false) String nombreAsignatura,
			@RequestParam(value = "idAlum", required = false) Integer idAlumno,
			@RequestParam(value = "nombreAlum") String nombreAlumno, @RequestParam(value = "fecha") String fecha,
			ModelMap model) {
		model.addAttribute("lista",
				matriculas.obtenerMatriculas(idAsignatura, nombreAsignatura, nombreAlumno, idAlumno, fecha));
		return "vistas/matriculaciones/listadoMatriculaciones";
	}

	@GetMapping(value = "insertarmatriculacion")
	public String InsertarGet(ModelMap model) {
		model.addAttribute("listaAlumnos", combo.comboAlumnos());
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		return "vistas/matriculaciones/insertarMatriculaciones";
	}

	@PostMapping(value = "insertarmatriculacion")
	public String InsertarPost(@RequestParam(value = "asignaturas", required = false) Integer idAsignatura,
			@RequestParam(value = "alumnos", required = false) Integer idAlumno,
			@RequestParam(value = "tasa") Double tasa, @RequestParam(value = "fecha") String fecha, ModelMap model) {
		model.addAttribute("listaAlumnos", combo.comboAlumnos());
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		matriculas.insertarMatriculas(idAsignatura, idAlumno, fecha, tasa);

		return "vistas/matriculaciones/insertarMatriculaciones";
	}

	@GetMapping(value = "formularioborrarmatriculaciones")
	public String FormularioBorrarMatriculas() {
		return "vistas/matriculaciones/borrarMatriculaciones";
	}

	@PostMapping(value = "formularioborrarmatriculaciones")
	public String FormularioBorrarMatriculasPost(@RequestParam(value = "idAsig", required = false) Integer idAsignatura,
			@RequestParam(value = "nombreAsig", required = false) String nombreAsignatura,
			@RequestParam(value = "idAlum", required = false) Integer idAlumno,
			@RequestParam(value = "nombreAlum") String nombreAlumno, @RequestParam(value = "fecha") String fecha,
			ModelMap model) {
		model.addAttribute("lista",
				matriculas.obtenerMatriculas(idAsignatura, nombreAsignatura, nombreAlumno, idAlumno, fecha));
		return "vistas/matriculaciones/borrarMatriculaciones";
	}

	@PostMapping(value = "borrarmatriculaciones")
	public String borraAsignatura(@RequestParam(value = "idMatricula") Integer id) {
		matriculas.borrarMatriculas(id);
		return "vistas/matriculaciones/borrarMatriculaciones";
	}

	@PostMapping(value = "tasa")
	@ResponseBody
	public Double calculaTasa(@RequestParam(value = "asignaturas", required = false) Integer idAsignatura,
			@RequestParam(value = "alumnos", required = false) Integer idAlumno) {
	
		Double tasa = nego.obtenerTasa(idAlumno, idAsignatura);
		return tasa;

	}
}
