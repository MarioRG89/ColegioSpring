package com.mario.colegio.daos;

import java.util.List;


import com.mario.colegio.dtos.ComboDTO;


public interface CombosDAO {

	List<ComboDTO> comboMunicipios();
	List<ComboDTO> comboAlumnos();
	List<ComboDTO> comboAsignaturas();
 }
