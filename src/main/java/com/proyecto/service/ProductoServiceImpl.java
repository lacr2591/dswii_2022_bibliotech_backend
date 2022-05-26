package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Producto;
import com.proyecto.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repositorio;

	@Override
	public Producto insertaActualizaProducto(Producto obj) {
		return repositorio.save(obj);
	}

	@Override
	public List<Producto> listaProducto() {
		return repositorio.findAll();
	}

	@Override
	public List<Producto> listaProductoNombreSerieMarca(String nombre, String serie, int stock, int idMarca, int estado) {
		
		return repositorio.listaProductoNombreSerieMarca(nombre, serie, stock, idMarca, estado);
	}

}

