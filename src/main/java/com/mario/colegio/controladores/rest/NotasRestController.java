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

import com.mario.colegio.daos.NotasDAO;
import com.mario.colegio.dtos.Notas;
import com.mario.colegio.dtos.NotasRequestDTO;
import com.mario.colegio.entidades.NotasEntity;
import com.mario.colegio.repositories.NotasRepository;

@RestController
@RequestMapping(value="/v1")
public class NotasRestController {

	@Autowired
	private NotasRepository notasrepository;
	@Autowired
	private NotasDAO notasDao;
	
	/*@GetMapping(value="/notas")
	public Iterable<NotasEntity> listaTodosNotas(){
		return notasrepository.findAll();
		
	}*/
	@GetMapping(value = "/notas/{id}")
	public Optional<NotasEntity> buscarNotasId(@PathVariable("id") Integer id) {
		return notasrepository.findById(id);
	}
	@GetMapping(value = "/notas" )
	public List<Notas> listarNotas(@RequestParam(value = "idAlumno", required = false) Integer idAlumno,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "asignatura", required = false) String asignatura,
			@RequestParam(value = "nota", required = false) Integer nota,
			@RequestParam(value = "fecha", required = false) String fecha) {
		return notasDao.obtenerNotas(idAlumno, nombre, asignatura, nota, fecha);
	}
	@DeleteMapping(value = "/notas/{id}")
	public ResponseEntity<String> MostrarFormularioBorraAlumnos(@PathVariable("id") Integer id) {
		notasrepository.deleteById(id);
		return new ResponseEntity<>("Borrado con Exito", HttpStatus.OK);
	}
	@PostMapping(value="/notas")
	public ResponseEntity<String> insertarAlumno(@RequestBody NotasRequestDTO nota) {
		
		notasDao.insertarNotas(nota.getIdAsignatura(), nota.getIdAlumno(), nota.getNota(), nota.getFecha());

		return new ResponseEntity<>("Insercion Correcta", HttpStatus.OK);

	}
	@PutMapping(value="/notas")
	public ResponseEntity<String> actualizarAlumno(@RequestBody Notas nota) {
		
		notasDao.modificarNotas(nota.getId(), nota.getIdAlumno(), nota.getIdAsignatura(), nota.getNota(), nota.getFecha());

		return new ResponseEntity<>("Modificacion Correcta", HttpStatus.OK);

	}
}
