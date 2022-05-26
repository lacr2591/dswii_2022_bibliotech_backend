package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.Sede;

public interface SedeRepository extends JpaRepository<Sede, Integer>
{

	@Query("select s from Sede s where (?1 is '' or s.nombre like ?1) and (?2 is '' or s.direccion=?2) and (?3 is -1 or s.estado=?3) and "
			+ "(?4 is '' or s.fechaCreacion like ?4) and (?5 is '' or s.fechaRegistro like ?5) and "
			+ "(?6 is '' or s.codigoPostal=?6) and (?7 is -1 or s.pais.idPais=?7)")
	public List<Sede> listaSedeFiltro(String nombre,String direccion, int estado,
			String fechaCreacion,String fechaRegistro, 
			String codigoPostal,int idPais);
}
