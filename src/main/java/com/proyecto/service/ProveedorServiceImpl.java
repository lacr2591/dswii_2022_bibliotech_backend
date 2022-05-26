package com.proyecto.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Proveedor;
import com.proyecto.repository.ProveedorRepository;
@Service
public class ProveedorServiceImpl implements  ProveedorService {

	@Autowired
	private ProveedorRepository repositorio;

	@Override
	public Proveedor  insertaActualizaProveedor(Proveedor obj) {
		return repositorio.save(obj);
	}
	@Override
	public List<Proveedor> listaProveedor() {
		return repositorio.findAll();	
		}
	
	@Override
	public List<Proveedor> listaProveedorRazonRucDireccion(String razonsocial, String ruc, String direccion, int estado) {
		return repositorio.listaProveedorRazonRucDireccion(razonsocial, ruc, direccion, estado);
	}
	
	
}
