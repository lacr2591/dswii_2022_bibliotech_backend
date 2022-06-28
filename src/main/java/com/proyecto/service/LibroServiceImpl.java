package com.proyecto.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.repository.UsuarioRepository;
import com.proyecto.repository.LibroRepository;
import com.proyecto.repository.PrestamosRepository;
import com.proyecto.repository.BibliotecaRepository;
import com.proyecto.entidad.*;
import com.proyecto.model.*;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	private LibroRepository repoLibro;

	@Autowired
	private PrestamosRepository repoPrestamos;

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
		Biblioteca objBiblioteca = null;
		Usuario objUsuario = repoUsuario.findFirstByEmailUsuario(libroBibl.getEmail());

		if (objUsuario != null && objUsuario.getIdInstitucion() > 0) {
			int idInstitucion = objUsuario.getIdInstitucion();

			Libro objLibro = repoLibro.findFirstById(libroBibl.getIdLibro());

			if (objLibro != null && objLibro.getTitle() != null) {

				objBiblioteca = repoBiblioteca.findFirstByIdLibro(objLibro.getId());

				if (objBiblioteca == null) {
					objBiblioteca = new Biblioteca();

					objBiblioteca.setId(0);
				}

				objBiblioteca.setEstado(true);
				objBiblioteca.setStockDisponible(libroBibl.getCantidad());
				objBiblioteca.setIdLibro(objLibro.getId());
				objBiblioteca.setIdInstitucion(idInstitucion);
				objBiblioteca.setIdLibroFK(objLibro);

				registrado = repoBiblioteca.save(objBiblioteca).getId() != 0 ? true : false;
			}
		}

		return registrado;

	}

	@Override
	public boolean actualizarLibro(LibroBiblioteca libroBibl) {

		boolean actualizado = false;
		Biblioteca obj = repoBiblioteca.findFirstByIdLibro(libroBibl.getIdLibro());
		Usuario objUsuario = repoUsuario.findFirstByEmailUsuario(libroBibl.getEmail());

		if (objUsuario != null && objUsuario.getIdInstitucion() > 0) {
			int idInstitucion = objUsuario.getIdInstitucion();

			Libro objLibro = repoLibro.findFirstById(libroBibl.getIdLibro());

			if (objLibro != null && objLibro.getId() > 0) {

				if (libroBibl.getCantidad() == 0) {

					obj.setEstado(false);

				}

				obj.setStockDisponible(libroBibl.getCantidad());
				obj.setIdLibro(objLibro.getId());
				obj.setIdInstitucion(idInstitucion);
				obj.setIdLibroFK(objLibro);

				actualizado = repoBiblioteca.save(obj).getId() != 0 ? true : false;
			}
		} else {
			System.out.println("=====> NO ENTRO");
			System.out.println("=====> NO ENTRO");
			System.out.println("=====> NO ENTRO");
			System.out.println("=====> NO ENTRO");
			System.out.println("=====> NO ENTRO");
			System.out.println("=====> NO ENTRO");
			System.out.println("=====> NO ENTRO");
			System.out.println("=====> NO ENTRO");
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

	@Override
	public List<LibroModel> ListarLibrosxEstudiante(int idEstudiante) {

		List<LibroModel> lstLibrosModel = null;
		LibroModel objLibroModel = null;

		List<Prestamos> lstPrestamos = repoPrestamos.findAllByIdUsuarioAndEstado(idEstudiante, 'p');

		if (lstPrestamos != null && lstPrestamos.size() > 0) {
			lstLibrosModel = new ArrayList<LibroModel>();
			for (Prestamos prestamos : lstPrestamos) {
				objLibroModel = new LibroModel();

				objLibroModel.setTitle(prestamos.getIdLibroFK().getTitle());
				objLibroModel.setCoverLink(prestamos.getIdLibroFK().getCoverLink());
				objLibroModel.setSynopsys(prestamos.getIdLibroFK().getSynopsys());
				objLibroModel.setEdition(prestamos.getIdLibroFK().getEdition());

				lstLibrosModel.add(objLibroModel);
			}

		} else {
			return null;
		}

		return lstLibrosModel;
	}

}
