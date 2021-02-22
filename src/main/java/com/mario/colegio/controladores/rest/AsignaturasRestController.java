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

import com.mario.colegio.daos.AsignaturasDAO;
import com.mario.colegio.dtos.Asignaturas;
import com.mario.colegio.entidades.AlumnoEntity;
import com.mario.colegio.entidades.AsignaturasEntity;
import com.mario.colegio.repositories.AsignaturaRepository;

@RestController
@RequestMapping(value = "/v1")
public class AsignaturasRestController {

	@Autowired
	private AsignaturaRepository asignaturarepository;
	@Autowired
	private AsignaturasDAO asignaturaDao;

	@GetMapping(value="/asignaturas")
	public Iterable<AsignaturasEntity> listaTodosAlumnos(){
		return asignaturarepository.findAll();
		
	}

	@GetMapping(value = "/asignaturas/{id}")
	public Optional<AsignaturasEntity> buscarAlumnoPorId(@PathVariable("id") Integer id) {
		return asignaturarepository.findById(id);
	}

	@GetMapping(value = "/asignaturas/" )
	public List<Asignaturas> listarAlumnosPorIdNombre(@RequestParam(value="id",required=false) Integer id,
													@RequestParam(value="nombre",required=false) String nombre, 
													@RequestParam(value="curso",required=false) Integer curso, 
													@RequestParam(value="tasa",required=false) Double tasa) {
		return asignaturaDao.obtenerTodasAsignaturas(id, nombre, curso, tasa);
	}

	@PutMapping(value = "/asignaturas")
	public ResponseEntity<String> actualizarAlumno(@RequestBody AsignaturasEntity asignatura) {
		asignaturarepository.save(asignatura);

		return new ResponseEntity<>("Actualizacion Correcta", HttpStatus.OK);
	}

	@PostMapping(value = "/asignaturas")
	public ResponseEntity<String> insertarAlumno(@RequestBody AsignaturasEntity asignatura) {

		asignaturarepository.save(asignatura);

		return new ResponseEntity<>("Insercion Correcta", HttpStatus.OK);

	}

	@DeleteMapping(value = "/asignaturas/{id}")
	public ResponseEntity<String> MostrarFormularioBorraAlumnos(@PathVariable("id") Integer id) {
		asignaturarepository.deleteById(id);
		return new ResponseEntity<>("Borrado con Exito", HttpStatus.OK);
	}
}
