package com.bolsadeideas.springboot.backend.apirest.controllers;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Encargado;
import com.bolsadeideas.springboot.backend.apirest.models.services.IEncargadoServices;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class EncargadoRestController {
	
	@Autowired
	private IEncargadoServices encargadoService;
	
	@GetMapping("/encargados")
	public List<Encargado> index(){
		return encargadoService.findAll();
		
	}
	
	@GetMapping("/encargados/{id}")
	public Encargado show(@PathVariable Long id) {
		return encargadoService.findById(id);
	}
	
	@PostMapping("/encargados")
	@ResponseStatus(HttpStatus.CREATED)
	public Encargado create(@RequestBody Encargado encargado) {
		encargado.setCreateAt(new Date());
		return encargadoService.save(encargado);
	}
	
	@PutMapping("/encargados/{id}")
	public Encargado update(@RequestBody Encargado encargado, @PathVariable Long id) {
		Encargado encargadoActual = encargadoService.findById(id);
		encargadoActual.setApellido(encargado.getApellido());
		encargadoActual.setNombre(encargado.getNombre());
		encargadoActual.setEmail(encargado.getEmail());
		
		return encargadoService.save(encargadoActual);
	}
	
	@DeleteMapping("/encargados/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		encargadoService.delete(id);
	}

}
