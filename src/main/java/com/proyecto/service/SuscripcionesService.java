package com.proyecto.service;
import java.util.Date;
import java.util.List;

import com.proyecto.entidad.Marca;
import com.proyecto.entidad.Suscripciones;

public interface SuscripcionesService {
	public abstract Suscripciones registraSuscripciones(Suscripciones obj);
	public abstract Suscripciones registraActualizaSuscripciones(Suscripciones obj);
	public abstract List<Suscripciones> listarSuscripciones();
	public abstract Suscripciones obtenerPorId(int id);
	
}

