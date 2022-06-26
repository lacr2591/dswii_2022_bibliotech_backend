package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.Instituciones;
import com.proyecto.entidad.Usuario;

public interface InstitucionesRepository extends JpaRepository<Instituciones, Integer> {

	public abstract Instituciones findFirstByDominioInstitucion(String dominioInstitucion);

}
