package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.Reclamo;

public interface ReclamoService {
	public abstract Reclamo insertUpdateReclamo(Reclamo obj);
	public List<Reclamo> listReclamoForFilters(String descripcion, int estado, int idTipoReclamo, int idCliente);
}
