package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.backend.apirest.models.dao.IEncargadoDao;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Encargado;

@Service
public class EncargadoServiceImpl implements IEncargadoServices{

	@Autowired
	private IEncargadoDao encargadoDao;
	@SuppressWarnings("unchecked")
	
	@Override
	@Transactional(readOnly = true)
	public List<Encargado> findAll() {
		return (List<Encargado>) encargadoDao.findAll();
	}
	
	@Override
	@Transactional
	public Encargado save(Encargado encargado) {
	
		return encargadoDao.save(encargado);
	
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
	
		encargadoDao.deleteById(id);
	
	}

	@Override
	public Encargado findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
