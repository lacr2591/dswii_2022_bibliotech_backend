package com.proyecto.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entidad.Biblioteca;
import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.RatingLibro;
import com.proyecto.entidad.Usuario;
import com.proyecto.model.Estudiante;
import com.proyecto.model.EstudianteDetalle;
import com.proyecto.repository.BibliotecaRepository;
import com.proyecto.service.CategoriaService;
import com.proyecto.service.LibroRatingService;
import com.proyecto.service.UsuarioService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/api/Usuarios")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class UsuariosController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/ListarUsuarios")
	@ResponseBody
	public ResponseEntity<List<Usuario>> ListarUsuarios() {
		List<Usuario> lst = usuarioService.ListarUsuariosTodos();

		return ResponseEntity.ok(lst);
	}

	@GetMapping("/ListarEstudiantes")
	@ResponseBody
	public ResponseEntity<List<Estudiante>> ListarEstudiantes() {
		Estudiante estudiante;
		List<Estudiante> lstEstudiantes = null;

		try {
			List<Usuario> lstUsuarios = usuarioService.ListarUsuarios();

			if (lstUsuarios != null && lstUsuarios.size() > 0) {

				lstEstudiantes = new ArrayList<Estudiante>();

				for (Usuario usuario : lstUsuarios) {
					estudiante = new Estudiante();

					estudiante.setId(usuario.getId());
					estudiante.setNumeroDocumento(usuario.getIdPersonaFK().getDni());
					estudiante.setNombres(usuario.getIdPersonaFK().getNombres());
					estudiante.setApellidoMaternos(usuario.getIdPersonaFK().getApellidoMaterno());
					estudiante.setApellidoPaterno(usuario.getIdPersonaFK().getApellidoPaterno());

					lstEstudiantes.add(estudiante);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok(lstEstudiantes);
	}

	@GetMapping("/DetalleEstudiante")
	@ResponseBody
	public ResponseEntity<EstudianteDetalle> DetalleEstudiante(int idEstudiante) {
		EstudianteDetalle estudiante = null;

		try {
			Usuario usuario = usuarioService.ObtenerUsuarioPorID(idEstudiante);

			estudiante = new EstudianteDetalle();

			estudiante.setId(usuario.getId());
			estudiante.setTipoDocumento("DNI");
			estudiante.setNumeroDocumento(usuario.getIdPersonaFK().getDni());
			estudiante.setNombres(usuario.getIdPersonaFK().getNombres());
			estudiante.setApellidoMaternos(usuario.getIdPersonaFK().getApellidoMaterno());
			estudiante.setApellidoPaterno(usuario.getIdPersonaFK().getApellidoPaterno());
			estudiante.setFechaNacimiento(usuario.getIdPersonaFK().getFecNacimiento().toString());
			estudiante.setGenero(Character.toString(usuario.getIdPersonaFK().getGenero()));
			estudiante.setEmail(usuario.getEmailUsuario());
			estudiante.setTelefono(usuario.getIdPersonaFK().getTelefono());
			estudiante.setFechaRegistro(usuario.getFecRegistro().toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok(estudiante);
	}

	@PostMapping("/AgregarEstudiante")
	@ResponseBody
	public ResponseEntity<Integer> AgregarEstudiante(@RequestBody EstudianteDetalle nuevoEstudiante) {
		int modificaciones = 0;
		try {

			modificaciones = usuarioService.CrearEstudiante(nuevoEstudiante);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok(modificaciones);
	}

	@PutMapping("/EditarEstudiante")
	@ResponseBody
	public ResponseEntity<Integer> EditarEstudiante(@RequestBody EstudianteDetalle nuevoEstudiante) {
		int modificaciones = 0;
		try {

			modificaciones = usuarioService.EditarEstudiante(nuevoEstudiante);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok(modificaciones);
	}

}
