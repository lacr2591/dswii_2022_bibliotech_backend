package com.proyecto.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.Instituciones;
import com.proyecto.entidad.Personas;
import com.proyecto.entidad.Roles;
import com.proyecto.entidad.Usuario;
import com.proyecto.model.EstudianteDetalle;
import com.proyecto.repository.CategoriaRepository;
import com.proyecto.repository.InstitucionesRepository;
import com.proyecto.repository.PersonasRepository;
import com.proyecto.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PersonasRepository personaRepository;

	@Autowired
	private InstitucionesRepository institucionesRepository;

	@Override
	public List<Usuario> ListarUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario ObtenerUsuarioPorID(int id) {
		return usuarioRepository.findFirstById(id);
	}

	@Override
	public int CrearEstudiante(EstudianteDetalle estudiante) {
		int modificaciones = 0;
		String dominioInstitucion = estudiante.getEmail().split("@")[1];
		Roles objRoles = new Roles();
		objRoles.setId(3);

		if (personaRepository.findFirstByDni(estudiante.getNumeroDocumento()) != null) {

			modificaciones = -1;

		} else {
			Personas objPersonas = new Personas();
			objPersonas.setId(0);
			objPersonas.setDni(estudiante.getNumeroDocumento());
			objPersonas.setNombres(estudiante.getNombres());
			objPersonas.setApellidoPaterno(estudiante.getApellidoPaterno());
			objPersonas.setApellidoMaterno(estudiante.getApellidoMaternos());

			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

			try {
				objPersonas.setFecNacimiento(formato.parse(estudiante.getFechaNacimiento()));
			} catch (Exception e) {
				System.out.println(e);
			}

			objPersonas.setGenero(estudiante.getGenero().charAt(0));
			objPersonas.setTelefono(estudiante.getTelefono());

			objPersonas = personaRepository.saveAndFlush(objPersonas);

			Instituciones objInstituciones = institucionesRepository.findFirstByDominioInstitucion(dominioInstitucion);
			if (objInstituciones != null) {

				Usuario obj = new Usuario();
				obj.setId(0);
				obj.setEmailUsuario(estudiante.getEmail());
				obj.setEstado(true);
				obj.setFecRegistro(new Date());
				System.out.println(estudiante.getId());
				obj.setIdPersona(objPersonas.getId());
				obj.setIdInstitucion(objInstituciones.getId());
				obj.setPasswordUsuario(estudiante.getNumeroDocumento());
				obj.setRolId(3);

				modificaciones = usuarioRepository.save(obj).getId();

			}
		}

		return modificaciones;
	}

	@Override
	public int EditarEstudiante(EstudianteDetalle estudiante) {

		int modificaciones = 0;
		String dominioInstitucion = estudiante.getEmail().split("@")[1];

		Usuario objUsuario = usuarioRepository.findFirstById(estudiante.getId());

		Personas objPersonas = new Personas();

		System.out.println("=== " + objUsuario.getIdPersona());
		objPersonas.setId(objUsuario.getIdPersona());

		objPersonas.setDni(estudiante.getNumeroDocumento());
		objPersonas.setNombres(estudiante.getNombres());
		objPersonas.setApellidoPaterno(estudiante.getApellidoPaterno());
		objPersonas.setApellidoMaterno(estudiante.getApellidoMaternos());

		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

		try {
			objPersonas.setFecNacimiento(formato.parse(estudiante.getFechaNacimiento()));
		} catch (Exception e) {
			System.out.println(e);
		}

		objPersonas.setGenero(estudiante.getGenero().charAt(0));
		objPersonas.setTelefono(estudiante.getTelefono());

		objPersonas = personaRepository.save(objPersonas);

		Instituciones objInstituciones = institucionesRepository.findFirstByDominioInstitucion(dominioInstitucion);
		if (objInstituciones != null) {

			Usuario obj = new Usuario();
			obj.setId(estudiante.getId());
			obj.setEmailUsuario(estudiante.getEmail());
			obj.setEstado(true);
			obj.setFecRegistro(new Date());
			// obj.setIdPersonaFK(objPersonas);
			obj.setIdPersona(objPersonas.getId());
			obj.setIdInstitucion(objInstituciones.getId());
			// obj.setIdInstitucionFK(new Instituciones());
			obj.setPasswordUsuario(estudiante.getNumeroDocumento());
			obj.setRolId(3);

			modificaciones = usuarioRepository.save(obj).getId();

		}

		return modificaciones;
	}

}
