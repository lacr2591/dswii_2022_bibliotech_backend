package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.Personas;
import com.proyecto.entidad.Usuario;

public interface PersonasRepository extends JpaRepository<Personas, Integer> {
	public abstract Personas findFirstById(int id);
	public abstract Personas findFirstByDni(String dni);

}
