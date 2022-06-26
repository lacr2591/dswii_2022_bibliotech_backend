package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entidad.Biblioteca;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Integer> {
	
	

}
