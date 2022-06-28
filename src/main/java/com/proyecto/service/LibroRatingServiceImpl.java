package com.proyecto.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.RatingLibro;
import com.proyecto.entidad.Usuario;
import com.proyecto.repository.CategoriaRepository;
import com.proyecto.repository.LibroRatingRepository;
import com.proyecto.repository.UsuarioRepository;

@Service
public class LibroRatingServiceImpl implements LibroRatingService {

	@Autowired
	private LibroRatingRepository repository;

	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public List<RatingLibro> ListarRatingsLibros() {
		return repository.findAll();
	}

	@Override
	public RatingLibro ObtenerRatingsLibroPorID(int id) {
		return repository.findFirstById(id);
	}

	@Override
	public RatingLibro ObtenerRatingsLibroIdLibroEmail(int id, String email) {
		Usuario objUsuario = userRepository.findFirstByEmailUsuario(email);
		if (objUsuario != null) {
			return repository.findFirstByIdLibroAndIdUsuario(id, objUsuario.getId());
		} else {

			return null;
		}
	}

	@Override
	public boolean ResenarLibro(String email, int idLibro, int rating, String resena) {
		boolean resenado = false;
		RatingLibro objRating = null;

		Usuario objUsuario = userRepository.findFirstByEmailUsuario(email);

		if (objUsuario != null) {

			objRating = repository.findFirstByIdLibroAndIdUsuario(idLibro, objUsuario.getId());

			if (objRating == null) {
				objRating= new RatingLibro();
				
				objRating.setId(0);
				objRating.setIdLibro(idLibro);
				objRating.setIdUsuario(objUsuario.getId());
				objRating.setPuntuacion(rating);
				objRating.setComentario(resena);
				objRating.setFechaComentario(new Date());

				if (repository.save(objRating).getId() > 0) {
					resenado = true;
				}
			} else {
				objRating.setIdLibro(idLibro);
				objRating.setIdUsuario(objUsuario.getId());
				objRating.setPuntuacion(rating);
				objRating.setComentario(resena);
				objRating.setFechaComentario(new Date());

				if (repository.save(objRating).getId() > 0) {
					resenado = true;
				}
			}
		}

		return resenado;
	}

}
