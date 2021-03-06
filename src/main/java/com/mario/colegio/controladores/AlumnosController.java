package com.mario.colegio.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mario.colegio.daos.AlumnoDao;
import com.mario.colegio.daos.CombosDAO;

@Controller
public class AlumnosController {

	private static final Logger logger = LoggerFactory.getLogger(AlumnosController.class);

	@Autowired
	private CombosDAO combo;
	
	@Autowired
	private AlumnoDao alumno;
	
	@GetMapping(value = "listadoalumnos")
	public String Lista() {
		return "vistas/alumnos/listadoAlumnos";
	}

	@PostMapping(value = "listadoalumnos")
	public String ListadoAlumnos(@RequestParam(value = "id",required = false)Integer id,
			@RequestParam("nombre")String nombre,ModelMap model) {
		model.addAttribute("lista",alumno.obtenerAlumnosporIdyNombre(id, nombre));	
		return "vistas/alumnos/listadoAlumnos";
		
	}

	@GetMapping(value = "insertaralumno")
	public String formularioInsertarAlumnos(ModelMap model) {
		model.addAttribute("comboMunicipios", combo.comboMunicipios());
		return "vistas/alumnos/insertarAlumnos";
	}

	@PostMapping(value = "insertaralumno")
	public String InsertarAlumno(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre, @RequestParam(value = "municipios") Integer idMunicipio,
			@RequestParam(value = "familiaNumerosa") Integer familiaNumerosa, ModelMap model) {
		model.addAttribute("comboMunicipios", combo.comboMunicipios());
		alumno.insertarAlumnos(id, nombre, idMunicipio, familiaNumerosa);
		return "vistas/alumnos/insertarAlumnos";
	}
	@GetMapping(value="formularioborraralumnos")
	public String ListadoBorrar() {

		return "vistas/alumnos/borrarAlumnos";
		
	}
	@PostMapping(value="formularioborraralumnos")
	public String ListadoBorrar(@RequestParam(value = "id",required = false)Integer id,
			@RequestParam("nombre")String nombre,ModelMap model) {
		
		model.addAttribute("lista",alumno.obtenerAlumnosporIdyNombre(id, nombre));	
		return "vistas/alumnos/borrarAlumnos";
		
	}
	
	@PostMapping(value="borraralumno")
	public String borrarAlumno(@RequestParam(value = "id",required = false)Integer id) {
		
		return "vistas/alumnos/borrarAlumnos";
		
	}
	@GetMapping(value="formularioactualizaralumnos")
	public String ListadoActualizar() {
		
		return "vistas/alumnos/actualizarAlumnos";
		
	}
	@PostMapping(value="formularioactualizaralumnos")
	public String ListadoActualizarA(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre, ModelMap model) {
		
		model.addAttribute("lista",alumno.obtenerAlumnosporIdyNombre(id, nombre));
		model.addAttribute("listaMunicipios", combo.comboMunicipios());
		return "vistas/alumnos/actualizarAlumnos";
		
	}
	@PostMapping(value="actualizaralumno")
	public String ActualizarAlumno(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre, @RequestParam(value = "municipios") Integer idMunicipio,
			@RequestParam(value = "familiaNumerosa") Integer familiaNumerosa, ModelMap model) {
		
		alumno.actualizarAlumnos(id, nombre, idMunicipio, familiaNumerosa);
		model.addAttribute("listaMunicipios", combo.comboMunicipios());
		
		return "vistas/alumnos/actualizarAlumnos";
		
	}
	
	
	
	
	
}
