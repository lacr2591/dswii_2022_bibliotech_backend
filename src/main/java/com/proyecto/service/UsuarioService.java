package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.Usuario;
import com.proyecto.model.EstudianteDetalle;

public interface UsuarioService {

	public abstract List<Usuario> ListarUsuarios();
	public abstract List<Usuario> ListarEstudiantes();
	
	public abstract List<Usuario> ListarUsuariosTodos();

	public abstract Usuario ObtenerUsuarioPorID(int id);
	
	public abstract int CrearEstudiante(EstudianteDetalle estudiante);
	public abstract int CrearRepresentante(EstudianteDetalle estudiante);
	
	public abstract int EditarEstudiante(EstudianteDetalle estudiante);
	
	public abstract boolean LoguearEstudiante(String email, String password);
	public abstract boolean LoguearRepresentante(String email, String password);
}
