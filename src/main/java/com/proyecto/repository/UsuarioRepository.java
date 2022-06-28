package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	public abstract Usuario findFirstById(int id);
	public abstract Usuario findFirstByEmailUsuario(String email);
	public abstract Usuario findFirstByEmailUsuarioAndPasswordUsuarioAndRolId(String email,String password,int rolId);
	public abstract List<Usuario> findAllByRolId(int rolId);
	public abstract Usuario findFirstByEmailUsuarioAndPasswordUsuarioAndRolIdNot(String email,String password,int rolId);
	
}
