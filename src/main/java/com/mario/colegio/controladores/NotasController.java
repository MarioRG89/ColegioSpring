package com.mario.colegio.controladores;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mario.colegio.daos.CombosDAO;
import com.mario.colegio.dtos.Notas;
import com.mario.colegio.entidades.AlumnoEntity;
import com.mario.colegio.entidades.AsignaturasEntity;
import com.mario.colegio.entidades.NotasEntity;
import com.mario.colegio.repositories.AlumnoRepository;
import com.mario.colegio.repositories.AsignaturaRepository;
import com.mario.colegio.repositories.NotasRepository;

@Controller
public class NotasController {
	
	@Autowired
	private CombosDAO combo;
	@Autowired
	private AlumnoRepository alumno;
	@Autowired
	private AsignaturaRepository asignatura;
	@Autowired
	private NotasRepository notasRepository;
	
	
	@GetMapping(value="insertarnota")
	public String insertarNotaGet( ModelMap model) {
		model.addAttribute("listaAlumnos", combo.comboAlumnos());
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		return "vistas/notas/insertarNotas";
	}
	@PostMapping(value="insertarnota")
	public String insertarNota(@RequestParam("asignaturas") Integer idAsignatura, @RequestParam(value = "alumnos") Integer idAlumno,
			@RequestParam(value = "nota") Integer nota,@RequestParam(value="fecha")String fecha ,ModelMap model) {
		if (fecha == "") {
			Date fecha_Act = new Date();
			fecha = new SimpleDateFormat("yyyy-MM-dd").format(fecha_Act);
		}
		model.addAttribute("listaAlumnos", combo.comboAlumnos());
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		Optional<AlumnoEntity> optinalAlumno= alumno.findById(idAlumno);
		AlumnoEntity a = optinalAlumno.get();
		Optional<AsignaturasEntity> optinalAsignatura= asignatura.findById(idAsignatura);
		AsignaturasEntity asig = optinalAsignatura.get();
		NotasEntity n = new NotasEntity(a, asig, nota, fecha);
		notasRepository.save(n);
		return "vistas/notas/insertarNotas";
	}
	@GetMapping(value="listadonotas")
	public String listaNotasGet() {
		return "vistas/notas/listadoNotas";
	}
	@PostMapping(value="listadonotas")
	public String listaNotas(@RequestParam(value="id",required=false) Integer idAlumno, @RequestParam(value = "nombre",required = false) String nombreAlumno,
			@RequestParam(value = "asignatura",required = false) String nombreAsignatura,@RequestParam(value = "nota",required=false) Integer nota,@RequestParam(value="fecha",required = false)String fecha ,ModelMap model) {
		List<Notas> listaNotas=notasRepository.buscaNotas(idAlumno, nota, fecha, nombreAlumno, nombreAsignatura);
		model.addAttribute("lista",listaNotas);
		return "vistas/notas/listadoNotas";
	}
	
	@GetMapping(value="formularioborrarnota")
	public String borraNotasFormularioGet() {
		 return "vistas/notas/borrarNotas";
	}
	@PostMapping(value="formularioborrarnota")
	public String borraNotasForm( @RequestParam(value = "nombre",required = false) String nombreAlumno,
			@RequestParam(value = "asignatura",required = false) String nombreAsignatura,@RequestParam(value="fecha",required = false)String fecha ,ModelMap model) {
		 List<Notas> listaNotas=notasRepository.buscaNotasAlumnoAsignatura(fecha, nombreAlumno, nombreAsignatura);
		 model.addAttribute("lista",listaNotas);
		 return "vistas/notas/borrarNotas";
	}
	@PostMapping(value="borrarnota")
	public String borraNota( @RequestParam(value = "idNota",required = false) Integer id) {
		 notasRepository.deleteById(id);
		 return "vistas/notas/borrarNotas";
	}
}
