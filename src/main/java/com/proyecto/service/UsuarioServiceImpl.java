package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.Usuario;
import com.proyecto.repository.CategoriaRepository;
import com.proyecto.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public List<Usuario> ListarUsuarios() {
		return repository.findAll();
	}

	@Override
	public Usuario ObtenerUsuarioPorID(int id) {
		return repository.findFirstById(id);
	}

}
