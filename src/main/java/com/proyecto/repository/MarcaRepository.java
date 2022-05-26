package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer>{
	
	// Query JPQL para consultar Marca por filtros
	
	@Query("select m from Marca m where (?1 is '' or m.nombre like ?1) and (m.estado = ?2) and (?3 is -1 or m.pais.idPais = ?3) and (?4 is '' or ?5 is '' or (m.fechaRegistro between ?4  and ?5 ))")
	public List<Marca> listaMarcaNombrePaisFecha(String nombre, int estado, int idPais, String fecInicio, String fecFin);
	
}
