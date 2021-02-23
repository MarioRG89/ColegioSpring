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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mario.colegio.daos.MatriculasDAO;
import com.mario.colegio.dtos.Matriculas;
import com.mario.colegio.dtos.Tasa;
import com.mario.colegio.dtos.TasaDto;
import com.mario.colegio.entidades.MatriculasEntity;
import com.mario.colegio.negocio.NegocioIN;
import com.mario.colegio.repositories.MatriculacionesRepository;

@RestController
@RequestMapping(value="/v1")
public class MatriculasRestController {
	@Autowired
	private NegocioIN negocio;
	@Autowired
	private MatriculacionesRepository matriculasRepository;
	@Autowired
	private MatriculasDAO matriculasDao;
	
	@GetMapping(value = "/matriculas/{id}")
	public Optional<MatriculasEntity> buscarNotasId(@PathVariable("id") Integer id) {
		return matriculasRepository.findById(id);
	}
	@GetMapping(value = "/matriculas" )
	public List<Matriculas> listarMatriculas(@RequestParam(value = "idAsignatura", required = false) Integer idAsignatura,
			@RequestParam(value = "nombreAsignatura", required = false) String nombreAsignatura,
			@RequestParam(value = "idAlumno", required = false) Integer idAlumno,
			@RequestParam(value = "nombreAlumno",required=false) String nombreAlumno, @RequestParam(value = "fecha",required=false) String fecha) {
		return matriculasDao.obtenerMatriculas(idAsignatura, nombreAsignatura, nombreAlumno, idAlumno, fecha);
	}
	@DeleteMapping(value = "/matriculas/{id}")
	public ResponseEntity<String> BorraMatriculas(@PathVariable("id") Integer id) {
		matriculasRepository.deleteById(id);
		return new ResponseEntity<>("Borrado con Exito", HttpStatus.OK);
	}
	@PostMapping(value="/matriculas")
	public ResponseEntity<String> insertarMatriculas(@RequestBody Matriculas matricula) {
		
		matriculasDao.insertarMatriculas(matricula.getIdAsignatura(), matricula.getIdAlumno(), matricula.getFecha(), matricula.getTasa());

		return new ResponseEntity<>("Insercion Correcta", HttpStatus.OK);

	}
	@PostMapping(value="/tasa")
	public Tasa calculaTasa(@RequestBody TasaDto tasa) {
		
		return new Tasa(negocio.obtenerTasa(tasa.getIdAlumno(), tasa.getIdAsignatura()));
		
		
	}
	
}

