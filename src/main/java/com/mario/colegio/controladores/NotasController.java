package com.mario.colegio.controladores;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mario.colegio.daos.CombosDAO;
import com.mario.colegio.daos.NotasDAO;

@Controller
public class NotasController {

	@Autowired
	private CombosDAO combo;
	@Autowired
	private NotasDAO notas;

	@GetMapping(value = "insertarnota")
	public String insertarNotaGet(ModelMap model) {
		model.addAttribute("listaAlumnos", combo.comboAlumnos());
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		return "vistas/notas/insertarNotas";
	}

	@PostMapping(value = "insertarnota")
	public String insertarNota(@RequestParam("asignaturas") Integer idAsignatura,
			@RequestParam(value = "alumnos") Integer idAlumno, @RequestParam(value = "nota") Integer nota,
			@RequestParam(value = "fecha") String fecha, ModelMap model) {
		if (fecha == "") {
			Date fecha_Act = new Date();
			fecha = new SimpleDateFormat("yyyy-MM-dd").format(fecha_Act);
		}
		model.addAttribute("listaAlumnos", combo.comboAlumnos());
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		notas.insertarNotas(idAsignatura, idAlumno, nota, fecha);
		return "vistas/notas/insertarNotas";
	}

	@GetMapping(value = "listadonotas")
	public String listaNotasGet() {
		return "vistas/notas/listadoNotas";
	}

	@PostMapping(value = "listadonotas")
	public String listaNotas(@RequestParam(value = "id", required = false) Integer idAlumno,
			@RequestParam(value = "nombre", required = false) String nombreAlumno,
			@RequestParam(value = "asignatura", required = false) String nombreAsignatura,
			@RequestParam(value = "nota", required = false) Integer nota,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {
		
		model.addAttribute("lista", notas.obtenerNotas(idAlumno, nombreAlumno, nombreAsignatura, nota, fecha));
		return "vistas/notas/listadoNotas";
	}

	@GetMapping(value = "formularioborrarnota")
	public String borraNotasFormularioGet() {
		return "vistas/notas/borrarNotas";
	}

	@PostMapping(value = "formularioborrarnota")
	public String borraNotasForm(@RequestParam(value = "nombre", required = false) String nombreAlumno,
			@RequestParam(value = "asignatura", required = false) String nombreAsignatura,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {
		
		model.addAttribute("lista", notas.obtenerNotasPorAlumnoAsignaturaFecha(fecha, nombreAlumno, nombreAsignatura));
		return "vistas/notas/borrarNotas";
	}

	@PostMapping(value = "borrarnota")
	public String borraNota(@RequestParam(value = "idNota", required = false) Integer id) {
		notas.borrarNotas(id);
		return "vistas/notas/borrarNotas";
	}

	@GetMapping(value = "formularioactualizarnota")
	public String actualizarNotasFormularioGet() {
		return "vistas/notas/actualizarNotas";
	}

	@PostMapping(value = "formularioactualizarnota")
	public String actualizarNotasFormulario(@RequestParam(value = "nombre", required = false) String nombreAlumno,
			@RequestParam(value = "asignatura", required = false) String nombreAsignatura,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {
		model.addAttribute("listaAlumnos", combo.comboAlumnos());
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		model.addAttribute("lista", notas.obtenerNotasPorAlumnoAsignaturaFecha(fecha, nombreAlumno, nombreAsignatura));
		return "vistas/notas/actualizarNotas";
	}

	@PostMapping(value = "actualizarnota")
	public String actualizarNotas(@RequestParam(value = "idNota", required = false) Integer id,
			@RequestParam(value = "alumnos", required = false) Integer idAlumno,
			@RequestParam(value = "asignaturas", required = false) Integer idAsignatura,
			@RequestParam(value = "nota", required = false) Integer nota,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {
		model.addAttribute("listaAlumnos", combo.comboAlumnos());
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		notas.modificarNotas(id, idAlumno, idAsignatura, nota, fecha);
		return "vistas/notas/actualizarNotas";
	}

}
