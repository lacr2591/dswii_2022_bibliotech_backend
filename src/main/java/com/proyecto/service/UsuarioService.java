package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.Usuario;

public interface UsuarioService {

	public abstract List<Usuario> ListarUsuarios();

	public abstract Usuario ObtenerUsuarioPorID(int id);
}
