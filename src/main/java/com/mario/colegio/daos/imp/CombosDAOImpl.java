package com.mario.colegio.daos.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mario.colegio.daos.CombosDAO;
import com.mario.colegio.dtos.ComboDTO;
import com.mario.colegio.entidades.AlumnoEntity;
import com.mario.colegio.entidades.AsignaturasEntity;
import com.mario.colegio.entidades.MunicipiosEntity;
import com.mario.colegio.repositories.AlumnoRepository;
import com.mario.colegio.repositories.AsignaturaRepository;
import com.mario.colegio.repositories.MunicipioRepository;

@Service
public class CombosDAOImpl implements CombosDAO {
	@Autowired
	private MunicipioRepository municipioRespository;
	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Override
	public List<ComboDTO> comboMunicipios() {
		Iterable<MunicipiosEntity> listaEntidadesMunicipios= municipioRespository.findAll();
		List<ComboDTO> listaMunicipios = mapeoEntidadMuncipioComboDTO(listaEntidadesMunicipios);
		return listaMunicipios;
	}

	@Override
	public List<ComboDTO> comboAlumnos() {
		Iterable<AlumnoEntity> listaEntidadesAlumnos= alumnoRepository.findAll();
		List<ComboDTO> listaAlumnos = mapeoEntidadAlumnoComboDTO(listaEntidadesAlumnos);
		return listaAlumnos;
	}

	@Override
	public List<ComboDTO> comboAsignaturas() {
		Iterable<AsignaturasEntity> listaEntidadesAsignaturas= asignaturaRepository.findAll();
		List<ComboDTO> listaAsignaturas = mapeoEntidadAsignaturasComboDTO(listaEntidadesAsignaturas);
		return listaAsignaturas;
	}
	
	
	
	private List<ComboDTO> mapeoEntidadMuncipioComboDTO(Iterable<MunicipiosEntity> listaEntidadesMunicipios){
		List<ComboDTO> listaMunicipios = new ArrayList<ComboDTO>();
		for (MunicipiosEntity m : listaEntidadesMunicipios) {
			listaMunicipios.add(new ComboDTO(m.getIdMunicipio(),m.getNombre()));
		}
		return listaMunicipios;
		
	}
	private List<ComboDTO> mapeoEntidadAlumnoComboDTO(Iterable<AlumnoEntity> listaEntidadesAlumnos){
		List<ComboDTO> listaAlumnos = new ArrayList<ComboDTO>();
		for (AlumnoEntity m : listaEntidadesAlumnos) {
			listaAlumnos.add(new ComboDTO(m.getId(),m.getNombre()));
		}
		
		return listaAlumnos;
		
	}
	private List<ComboDTO> mapeoEntidadAsignaturasComboDTO(Iterable<AsignaturasEntity> listaEntidadesAsignaturas){
		List<ComboDTO> listaAsignaturas = new ArrayList<ComboDTO>();
		for (AsignaturasEntity m : listaEntidadesAsignaturas) {
			listaAsignaturas.add(new ComboDTO(m.getId(),m.getNombre()));
		}
		
		return listaAsignaturas;
		
	}
}
