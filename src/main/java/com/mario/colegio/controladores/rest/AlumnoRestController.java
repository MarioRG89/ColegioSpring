package com.mario.colegio.controladores.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mario.colegio.daos.AlumnoDao;
import com.mario.colegio.dtos.Alumno;
import com.mario.colegio.entidades.AlumnoEntity;
import com.mario.colegio.repositories.AlumnoRepository;

@RestController
@RequestMapping(value="/v1")
public class AlumnoRestController {

	@Autowired
	private AlumnoRepository alumnorepository;
	@Autowired
	private AlumnoDao alumnoDao;
	
	@GetMapping(value="/alumnos")
	public Iterable<AlumnoEntity> listaTodosAlumnos(){
		return alumnorepository.findAll();
		
	}
	@GetMapping(value="/alumnos/{id}")
	public Optional<AlumnoEntity> buscarAlumnoPorId(@PathVariable("id") Integer id){
		return alumnorepository.findById(id);
	}
	
	@GetMapping(value="/alumnos/",params= {"id","nombre"})
	public List<Alumno> listarAlumnosPorIdNombre(@RequestParam("id")Integer id,@RequestParam("nombre")String nombre){
		return alumnoDao.obtenerAlumnosporIdyNombre(id, nombre);
	}
	
	@PutMapping(value="/alumnos")
	public ResponseEntity<String> actualizarAlumno(@RequestBody AlumnoEntity alumno){
		alumnorepository.save(alumno);
		
		return new ResponseEntity<>("Actualizacion Correcta",HttpStatus.OK) ;
	}
	
	
	@PostMapping(value="/alumnos")
	public ResponseEntity<String> insertarAlumno(@RequestBody AlumnoEntity alumno){
		
		alumnorepository.save(alumno);
		
		return new ResponseEntity<>("Insercion Correcta",HttpStatus.OK) ;
		
	}
	
	@DeleteMapping(value="/alumnos/{id}")
	public ResponseEntity<String> MostrarFormularioBorraAlumnos(@PathVariable("id")Integer id){
		alumnorepository.deleteById(id);
		return new ResponseEntity<>("Borrado con Exito",HttpStatus.OK) ;
	}
	
	
}
