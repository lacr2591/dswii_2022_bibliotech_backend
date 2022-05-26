package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.Reclamo;

public interface ReclamoRepository extends JpaRepository<Reclamo, Integer> {
	/**
	 * Método para realizar filtros por:
	 * Descripción, Estado, Tipo de Reclamo y/o Cliente
	 * 
	 * @param nombre
	 * @param estado
	 * @param idTipoReclamo
	 * @param idCliente
	 * @return
	 */
	@Query("select r from Reclamo r where "
			+ "(?1 is '' or r.descripcion like ?1) and "
			+ "(?2 is -1 or r.estado=?2) and "
			+ "(?3 is -1 or r.tipoReclamo.idTipoReclamo=?3) and "
			+ "(?4 is -1 or r.cliente.idCliente=?4)")
	public List<Reclamo> listReclamoForFilters(String descripcion, int estado, int idTipoReclamo, int idCliente);
}
