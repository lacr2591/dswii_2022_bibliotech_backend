package com.proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Biblioteca;
import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.Instituciones;
import com.proyecto.entidad.Libro;
import com.proyecto.entidad.LibroCategoria;
import com.proyecto.entidad.RatingLibro;
import com.proyecto.model.LibroModel;
import com.proyecto.model.RatingModel;
import com.proyecto.repository.BibliotecaRepository;
import com.proyecto.repository.LibroCategoriaRepository;
import com.proyecto.repository.InstitucionesRepository;
import com.proyecto.repository.LibroRatingRepository;
import com.proyecto.repository.LibroRepository;

@Service
public class BibliotecaServicelmpl implements BibliotecaService {
	@Autowired
	private InstitucionesRepository institucionRep;

	@Autowired
	private BibliotecaRepository bibliotecaRep;

	@Autowired
	private LibroRatingRepository ratingRep;

	@Autowired
	private LibroCategoriaRepository categoriaRep;

	@Override
	public List<LibroModel> ListarLibro(String email) {
		String dominioInstitucion = email.split("@")[1];

		List<LibroModel> lstLibros = new ArrayList<LibroModel>();
		Instituciones objInstitucion = institucionRep.findFirstByDominioInstitucion(dominioInstitucion);

		List<Biblioteca> objBiblioteca = bibliotecaRep.findByIdInstitucionAndEstado(objInstitucion.getId(), true);

		LibroModel objLibroModel;

		for (Biblioteca biblioteca : objBiblioteca) {
			objLibroModel = new LibroModel();

			List<RatingLibro> lstRatingLibro = ratingRep.findAllByIdLibro(biblioteca.getIdLibro());
			double promedio = 0;
			int cantidadrating = 0;

			for (RatingLibro rating : lstRatingLibro) {
				promedio = promedio + rating.getPuntuacion();
				cantidadrating++;
			}
			promedio = promedio / cantidadrating;

			objLibroModel.setId_Libro(biblioteca.getIdLibroFK().getId());
			objLibroModel.setCoverLink(biblioteca.getIdLibroFK().getCoverLink());

			objLibroModel.setEdition(biblioteca.getIdLibroFK().getEdition());
			objLibroModel.setLanguage(biblioteca.getIdLibroFK().getLanguage());
			objLibroModel.setPages(biblioteca.getIdLibroFK().getPages());
			objLibroModel.setStockDisponible(biblioteca.getStockDisponible());
			objLibroModel.setSynopsys(biblioteca.getIdLibroFK().getSynopsys());
			objLibroModel.setTitle(biblioteca.getIdLibroFK().getTitle());
			objLibroModel.setTitle_Long(biblioteca.getIdLibroFK().getTitle_long());

			objLibroModel.setPuntuacion((promedio));

			List<LibroCategoria> lstCategorias = categoriaRep.findAllByIdLibro(biblioteca.getIdLibro());
			String categorias = "";
			for (LibroCategoria categoria : lstCategorias) {
				categorias = categorias + categoria.getIdCategoriaFK().getDescripcion() + " ";
			}

			objLibroModel.setCategorias(categorias);

			lstLibros.add(objLibroModel);
		}
		return lstLibros;
	}

	public List<LibroModel> ListarLibroGeneral(String email) {
		String dominioInstitucion = email.split("@")[1];

		List<LibroModel> lstLibros = new ArrayList<LibroModel>();
		Instituciones objInstitucion = institucionRep.findFirstByDominioInstitucion(dominioInstitucion);

		List<Biblioteca> objBiblioteca = bibliotecaRep.findByIdInstitucionAndEstado(objInstitucion.getId(), false);

		LibroModel objLibroModel;

		for (Biblioteca biblioteca : objBiblioteca) {
			objLibroModel = new LibroModel();

			List<RatingLibro> lstRatingLibro = ratingRep.findAllByIdLibro(biblioteca.getIdLibro());
			double promedio = 0;
			int cantidadrating = 0;

			for (RatingLibro rating : lstRatingLibro) {
				promedio = promedio + rating.getPuntuacion();
				cantidadrating++;
			}
			promedio = promedio / cantidadrating;

			objLibroModel.setId_Libro(biblioteca.getIdLibroFK().getId());
			objLibroModel.setCoverLink(biblioteca.getIdLibroFK().getCoverLink());

			objLibroModel.setEdition(biblioteca.getIdLibroFK().getEdition());
			objLibroModel.setLanguage(biblioteca.getIdLibroFK().getLanguage());
			objLibroModel.setPages(biblioteca.getIdLibroFK().getPages());
			objLibroModel.setStockDisponible(biblioteca.getStockDisponible());
			objLibroModel.setSynopsys(biblioteca.getIdLibroFK().getSynopsys());
			objLibroModel.setTitle(biblioteca.getIdLibroFK().getTitle());
			objLibroModel.setTitle_Long(biblioteca.getIdLibroFK().getTitle_long());

			objLibroModel.setPuntuacion((promedio));

			List<LibroCategoria> lstCategorias = categoriaRep.findAllByIdLibro(biblioteca.getIdLibro());
			String categorias = "";
			for (LibroCategoria categoria : lstCategorias) {
				categorias = categorias + categoria.getIdCategoriaFK().getDescripcion() + " ";
			}

			objLibroModel.setCategorias(categorias);

			lstLibros.add(objLibroModel);
		}
		return lstLibros;
	}

	@Override
	public List<LibroModel> ListarLibroDetalle(int id) {

		List<LibroModel> lstLibros = new ArrayList<LibroModel>();

		List<Biblioteca> objBiblioteca = bibliotecaRep.findById(id);

		LibroModel objLibroModel;

		for (Biblioteca biblioteca : objBiblioteca) {
			objLibroModel = new LibroModel();

			List<RatingLibro> lstRatingLibro = ratingRep.findAllByIdLibro(biblioteca.getIdLibro());
			double promedio = 0;
			int cantidadrating = 0;

			for (RatingLibro rating : lstRatingLibro) {
				promedio = promedio + rating.getPuntuacion();
				cantidadrating++;
			}
			promedio = promedio / cantidadrating;

			objLibroModel.setId_Libro(biblioteca.getIdLibroFK().getId());
			objLibroModel.setCoverLink(biblioteca.getIdLibroFK().getCoverLink());

			objLibroModel.setEdition(biblioteca.getIdLibroFK().getEdition());
			objLibroModel.setLanguage(biblioteca.getIdLibroFK().getLanguage());
			objLibroModel.setPages(biblioteca.getIdLibroFK().getPages());
			objLibroModel.setStockDisponible(biblioteca.getStockDisponible());
			objLibroModel.setSynopsys(biblioteca.getIdLibroFK().getSynopsys());
			objLibroModel.setTitle(biblioteca.getIdLibroFK().getTitle());
			objLibroModel.setTitle_Long(biblioteca.getIdLibroFK().getTitle_long());

			objLibroModel.setPuntuacion((promedio));

			List<LibroCategoria> lstCategorias = categoriaRep.findAllByIdLibro(biblioteca.getIdLibro());
			String categorias = "";
			for (LibroCategoria categoria : lstCategorias) {
				categorias = categorias + categoria.getIdCategoriaFK().getDescripcion() + " ";
			}

			objLibroModel.setCategorias(categorias);

			lstLibros.add(objLibroModel);
		}
		return lstLibros;
	}

}
