package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.Marca;

public interface MarcaService {

	public abstract List<Marca> listaMarca();
	public abstract Marca registraMarca(Marca obj);
	public abstract Marca registraActualizaMarca(Marca obj);
	public abstract List<Marca> listaMarcaNombrePaisFecha(String nombre, int estado, int idPais, String fecInicio, String fecFin);
	// public abstract void eliminarPorId(int idMarca);

}
