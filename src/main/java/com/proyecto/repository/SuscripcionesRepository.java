package com.proyecto.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.Autores;
import com.proyecto.entidad.Marca;
import com.proyecto.entidad.Suscripciones;

public interface SuscripcionesRepository extends JpaRepository<Suscripciones, Integer> {
		
	public abstract Suscripciones findFirstById(int id);
	public abstract List<Suscripciones> findAll();
	}
