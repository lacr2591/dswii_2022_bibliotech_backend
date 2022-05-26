package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.Producto;

public interface ProductoService {

	public Producto insertaActualizaProducto(Producto obj);
	public List<Producto> listaProducto();
	
	public abstract List<Producto> listaProductoNombreSerieMarca(String nombre, String serie, int stock, int idMarca, int estado);
}