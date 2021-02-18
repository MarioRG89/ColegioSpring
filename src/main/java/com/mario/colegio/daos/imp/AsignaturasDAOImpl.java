package com.mario.colegio.daos.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mario.colegio.daos.AsignaturasDAO;
import com.mario.colegio.dtos.Asignaturas;
import com.mario.colegio.entidades.AsignaturasEntity;
import com.mario.colegio.repositories.AsignaturaRepository;


@Service
public class AsignaturasDAOImpl implements AsignaturasDAO{
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Override
	public List<Asignaturas> obtenerTodasAsignaturas(Integer id, String nombre, Integer curso, Double tasa) {
		List<Asignaturas> listaAsignaturas=asignaturaRepository.buscaAsignaturas(id, nombre,curso,tasa);
		return listaAsignaturas;
	}

	@Override
	public Integer insertarAsignaturas(Integer id, String nombre, Integer curso, Double tasa) {
		AsignaturasEntity a= new AsignaturasEntity(id, nombre, curso, tasa);
		asignaturaRepository.save(a);
		return 1;
	}

	@Override
	public Integer actualizarAsignaturas(Integer id, String nombre, Integer curso, Double tasa) {
		AsignaturasEntity asig = new AsignaturasEntity(id,nombre,curso,tasa);
		asignaturaRepository.save(asig);
		return 1;
	}

	@Override
	public Integer borrarAsignatura(Integer id) {
		asignaturaRepository.deleteById(id);
		return 1;
	}


	@Override
	public double recuperarTasaAsignatura(Integer idAsignatura) {
		Optional<AsignaturasEntity> optinalAsignatura = asignaturaRepository.findById(idAsignatura);
		AsignaturasEntity asig = optinalAsignatura.get();
		return asig.getTasa();
	}

}
