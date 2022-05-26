package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.Sede;

public interface SedeService 
{

	public abstract Sede InsertSede(Sede obj);
	public abstract List<Sede> ListarSede();
	public abstract List<Sede> listaSedeFiltro(String nombre,String direccion, int estado,
			String fechaCreacion,String fechaRegistro, 
			String codigoPostal,int idPais);
}
