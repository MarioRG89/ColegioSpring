package com.mario.colegio.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mario.colegio.daos.CombosDAO;
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
			@RequestParam("nombre") String nombre, @RequestParam(value = "curso") Integer curso,
			@RequestParam(value = "tasa") Double tasa, ModelMap model) {
		AsignaturasEntity a= new AsignaturasEntity(id, nombre, curso, tasa);
		asignaturaRepository.save(a);
		return "vistas/asignaturas/insertarAsignaturas";
	}
	
	
}
