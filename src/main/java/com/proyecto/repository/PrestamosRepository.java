package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entidad.Autores;
import com.proyecto.entidad.Biblioteca;
import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.Prestamos;

public interface PrestamosRepository extends JpaRepository<Prestamos, Integer> {
	public abstract List<Prestamos> findAllByIdUsuarioAndEstado(int IdUsuario,char estado);
}
