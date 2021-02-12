package com.mario.colegio.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.mario.colegio.daos.CombosDAO;

@Controller
public class AsignaturasController {
	
	@Autowired
	private CombosDAO combo;
	
	@GetMapping(value = "insertarasignaturas")
	public String formularioInsertarAsignaturas(ModelMap model) {
		model.addAttribute("comboAlumnos", combo.comboMunicipios());
		return "vistas/alumnos/insertarAsignaturas";
	}
}
