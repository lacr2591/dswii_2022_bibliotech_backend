package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.Autores;

public interface AutoresRepository extends JpaRepository<Autores, Integer> {

	public abstract Autores findFirstById(int id);

}
