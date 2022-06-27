package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.repository.UsuarioRepository;
import com.proyecto.repository.LibroRepository;
import com.proyecto.repository.BibliotecaRepository;
import com.proyecto.entidad.*;
import com.proyecto.model.*;

@Service
public class LibroServiceImpl implements LibroService {
	
	@Autowired
	private LibroRepository repoLibro;
	
	@Autowired
	private UsuarioRepository repoUsuario;
	
	@Autowired
	private BibliotecaRepository repoBiblioteca;
	

	@Override
	public Libro registraActualizaLibro(LibroBiblioteca libroBibl) {

		return null;
	}

	@Override
	public Libro findLibroByTitle(String title) {
		
		Optional<Libro> found = repoLibro.findLibroByTitle(title);
		
		return (found.isPresent() ? found.get() : null);

	}

	@Override
	public List<Libro> findByTitleLike(String title) {
		return repoLibro.findByTitleLike("%" + title + "%");
	}


	@Override
	public boolean registrarLibro(LibroBiblioteca libroBibl) {
		
		boolean registrado = false;
		Biblioteca obj = new Biblioteca();
		Usuario objUsuario = repoUsuario.findFirstByEmailUsuario(libroBibl.getEmail());
		
		if(objUsuario != null && objUsuario.getIdInstitucion() > 0)
		{
			int idInstitucion = objUsuario.getIdInstitucion();
			Instituciones objInstitucion = new Instituciones();
			objInstitucion.setId(idInstitucion);
			
			Libro objLibro = repoLibro.findFirstById(libroBibl.getIdLibro());
			
				if (objLibro != null && objLibro.getTitle() != null) {
					
						obj.setId(0);
						obj.setEstado(true);
						obj.setStockDisponible(libroBibl.getCantidad());
						obj.setIdLibro(objLibro.getId());
						obj.setIdInstitucion(idInstitucion);
						obj.setIdLibroFK(objLibro);

						registrado = repoBiblioteca.save(obj).getId() != 0 ? true : false;
				}
		}
		
		return registrado;
		
	}

	@Override
	public boolean actualizarLibro(LibroBiblioteca libroBibl) {
		
		boolean actualizado = false;
		Biblioteca obj = repoBiblioteca.findFirstById(libroBibl.getIdLibro());
		Usuario objUsuario = repoUsuario.findFirstByEmailUsuario(libroBibl.getEmail());
		
		if(objUsuario != null && objUsuario.getIdInstitucion() > 0)
		{
			int idInstitucion = objUsuario.getIdInstitucion();
			Instituciones objInstitucion = new Instituciones();
			objInstitucion.setId(idInstitucion);
		
			Libro objLibro = repoLibro.findFirstById(libroBibl.getIdLibro());
			
				if (objLibro != null && objLibro.getId() > 0) {
					
					if(libroBibl.getCantidad() == 0) {
						
							obj.setEstado(false);
							
					}
					
					obj.setStockDisponible(libroBibl.getCantidad());
					obj.setIdLibro(objLibro.getId());
					obj.setIdInstitucion(idInstitucion);
					obj.setIdLibroFK(objLibro);
						
					actualizado = repoBiblioteca.save(obj).getId() != 0 ? true : false;
				}
		}
		return actualizado;
	}

	@Override
	public List<Libro> listaLibro() {
		return repoLibro.findAll();	
		}

	@Override
	public Libro findFirstById(Integer id) {
	
		return repoLibro.findFirstById(id);
	}

}
