package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	
	public abstract Cliente findFirstByDni(String dni);
	
	@Query("select c from Cliente c where (?1 is '' or c.nombres like ?1) and (?2 is '' or c.apellidos like ?2) and (?3 is '' or c.dni like ?3) and (?4 is '' or c.correo like ?4) and (?5 is -1 or c.estado =?5)")

	public List<Cliente> listaClienteFiltros(String nombres,String apellidos,String dni, String correo, int estado);
		
}
	