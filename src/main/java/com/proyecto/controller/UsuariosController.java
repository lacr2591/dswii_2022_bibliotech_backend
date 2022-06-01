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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.RatingLibro;
import com.proyecto.entidad.Usuario;
import com.proyecto.model.Estudiante;
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

		return ResponseEntity.ok(null);
	}

}
