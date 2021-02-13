package com.mario.colegio.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mario.colegio.daos.CombosDAO;
import com.mario.colegio.dtos.Asignaturas;
import com.mario.colegio.entidades.AsignaturasEntity;
import com.mario.colegio.repositories.AsignaturaRepository;

@Controller
public class AsignaturasController {
	
	@Autowired
	private CombosDAO combo;
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@GetMapping(value = "insertarasignaturas")
	public String formularioInsertarAsignaturas() {
		
		return "vistas/asignaturas/insertarAsignaturas";
	}
	
	@PostMapping(value = "insertarasignaturas")
	public String InsertarAsignaturas(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre, @RequestParam(value = "curso",required = false) Integer curso,
			@RequestParam(value = "tasa") Double tasa, ModelMap model) {
		AsignaturasEntity a= new AsignaturasEntity(id, nombre, curso, tasa);
		asignaturaRepository.save(a);
		return "vistas/asignaturas/insertarAsignaturas";
	}
	@GetMapping(value = "listadoasignaturas")
	public String formularioListarAsignaturas() {
		
		return "vistas/asignaturas/listadoAsignaturas";
	}
	@PostMapping(value="listadoasignaturas")
	public String listarAsignaturas(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre, @RequestParam(value = "curso", required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Double tasa, ModelMap model) {
		
		List<Asignaturas> listaAsignaturas=asignaturaRepository.buscaAsignaturas(id, nombre,curso,tasa);
		model.addAttribute("lista",listaAsignaturas);
		return "vistas/asignaturas/listadoAsignaturas";
	}
	@GetMapping(value = "formularioborrarasignatura")
	public String formularioBorrarAsignaturas() {
		
		return "vistas/asignaturas/borrarAsignaturas";
	}
	@PostMapping(value = "formularioborrarasignatura")
	public String formularioListarBorrarAsignaturas(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre, @RequestParam(value = "curso", required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Double tasa, ModelMap model) {

		List<Asignaturas> listaAsignaturas=asignaturaRepository.buscaAsignaturas(id, nombre,curso,tasa);
		model.addAttribute("lista",listaAsignaturas);
		return "vistas/asignaturas/borrarAsignaturas";
	}
	@PostMapping(value="borrarasignatura")
	public String borrarAsignatura(@RequestParam(value = "id",required = false)Integer id) {
		asignaturaRepository.deleteById(id);
		return "vistas/asignaturas/borrarAsignaturas";
	}
	
	@GetMapping(value="formularioactualizarasignatura")
	public String formularioActualizarasignatura() {
		return "vistas/asignaturas/actualizarAsignaturas";
	}
	@PostMapping(value="formularioactualizarasignatura")
	public String formularioListarActualizarasignatura(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre, @RequestParam(value = "curso", required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Double tasa, ModelMap model) {
		List<Asignaturas> listaAsignaturas=asignaturaRepository.buscaAsignaturas(id, nombre,curso,tasa);
		model.addAttribute("lista",listaAsignaturas);
		return "vistas/asignaturas/actualizarAsignaturas";
	}
	@PostMapping(value="actualizarasignatura")
	public String actualizaAsignatura(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre, @RequestParam(value = "curso", required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Double tasa, ModelMap model) {
		AsignaturasEntity asig = new AsignaturasEntity(id,nombre,curso,tasa);
		asignaturaRepository.save(asig);
		
		return "vistas/asignaturas/actualizarAsignaturas";
	}
}
