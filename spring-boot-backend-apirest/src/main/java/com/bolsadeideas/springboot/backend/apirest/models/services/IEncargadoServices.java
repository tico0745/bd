package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Encargado;

public interface IEncargadoServices {

	public List<Encargado> findAll();
	
	public Encargado findById(Long id);
	
	public Encargado save (Encargado encargado);
	
	public void delete(Long id);
}
