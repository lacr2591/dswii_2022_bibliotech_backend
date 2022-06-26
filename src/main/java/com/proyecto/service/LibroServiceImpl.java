package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.repository.UsuarioRepository;
import com.proyecto.repository.LibroRepository;
import com.proyecto.repository.BibliotecaRepository;
import com.proyecto.entidad.*;
import com.proyecto.model.LibroBiblioteca;

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
	public Libro findLibroById(Integer idLibro) {
		
		Optional<Libro> found = getLibroRepository().findById(idLibro);
		
		return (found.isPresent() ? found.get() : null);
	}
	
	public LibroRepository getLibroRepository() {
		return repoLibro;
	}

	public void setLibroRepository(LibroRepository repoLibro) {
		this.repoLibro = repoLibro;
	}
	
	public UsuarioRepository getUsuarioRepository() {
		return repoUsuario;
	}

	public void setUsuarioRepository(UsuarioRepository repoUsuario) {
		this.repoUsuario = repoUsuario;
	}
	
	public BibliotecaRepository getBibliotecaRepository() {
		return repoBiblioteca;
	}

	public void setBibliotecaRepository(BibliotecaRepository repoBiblioteca) {
		this.repoBiblioteca = repoBiblioteca;
	}

	@Override
	public Libro findLibroByTitle(String title) {
		
		Optional<Libro> found = getLibroRepository().findLibroByTitle(title);
		
		return (found.isPresent() ? found.get() : null);

	}

	@Override
	public List<Libro> findByTitleLike(String title) {
		return getLibroRepository().findByTitleLike("%" + title + "%");
	}


	@Override
	public boolean registrarLibro(LibroBiblioteca libroBibl) {
		
		boolean registrado = false;
		Biblioteca obj = new Biblioteca();
		Usuario objUsuario = repoUsuario.findFirstByEmailUsuario(libroBibl.getEmail());
		
		if(objUsuario != null)
		{
			Instituciones objInst = objUsuario.getIdInstitucionFK();
			Libro objLibro = repoLibro.getById(libroBibl.getIdLibro());
			
			if (objInst != null)
			{
				if (objLibro != null) {
					
						obj.setId(0);
						obj.setEstado(true);
						obj.setStockDisponible(libroBibl.getCantidad());
						obj.setIdLibroFK(null);
						obj.setIdInstitucionFK(objInst);
						obj.setIdLibroFK(objLibro);

						registrado = getBibliotecaRepository().save(obj).getId() != 0 ? true : false;
				}
			}
		}
		
		return registrado;
		
	}

	@Override
	public boolean actualizarLibro(LibroBiblioteca libroBibl) {
		
		boolean actualizado = false;
		
		Biblioteca obj = repoBiblioteca.getById(libroBibl.getIdLibro());
		Usuario objUsuario = repoUsuario.findFirstByEmailUsuario(libroBibl.getEmail());
		
		if(objUsuario != null)
		{
			Instituciones objInst = objUsuario.getIdInstitucionFK();
			Libro objLibro = repoLibro.getById(libroBibl.getIdLibro());
			
			if (objInst != null)
			{
				if (objLibro != null) {
					
						obj.setId(0);
						actualizado = getBibliotecaRepository().save(obj).getId() != 0 ? true : false;
				}
			}
		}
		
		return actualizado;
	}

}
