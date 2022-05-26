package com.proyecto.service;

import java.util.List;


import com.proyecto.entidad.Proveedor;

public interface ProveedorService {

	
	public abstract Proveedor insertaActualizaProveedor(Proveedor obj) ;
	public abstract List<Proveedor> listaProveedor() ;
	public abstract List<Proveedor> listaProveedorRazonRucDireccion(String razonsocial, String ruc, String direccion, int estado);
	
	
	}

