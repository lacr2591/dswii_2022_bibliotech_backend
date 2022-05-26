package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Sede;
import com.proyecto.repository.SedeRepository;

@Service
public class SedeServiceImpl implements SedeService {

	@Autowired
	private SedeRepository repository;
	
	@Override
	public Sede InsertSede(Sede obj) 
	{
		return repository.save(obj);
	}

	@Override
	public List<Sede> ListarSede() {
		return repository.findAll();
	}

	@Override
	public List<Sede> listaSedeFiltro(String nombre, String direccion, int estado, 
			String fechaCreacion,
			String fechaRegistro, 
			String codigoPostal, int idPais) {
		
		return repository.listaSedeFiltro(nombre, direccion, estado, 
				fechaCreacion, fechaRegistro, 
				codigoPostal, idPais);
	}

}
