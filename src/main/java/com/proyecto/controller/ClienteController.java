package com.proyecto.controller;

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

import com.proyecto.entidad.Cliente;
import com.proyecto.entidad.Producto;
import com.proyecto.service.ClienteService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/url/cliente")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ClienteController {
	@Autowired
	private ClienteService clienteService;

	@PostMapping("/registrarCliente")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> RegistrarCliente(@RequestBody Cliente objCliente) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (!objCliente.getDni().isEmpty() && !clienteService.ExisteCLientePorDNI(objCliente.getDni())) {
				objCliente.setEstado(1);
				objCliente.setFechaRegistro(new Date());
				salida.put("mensaje", clienteService.RegistrarCliente(objCliente) ? "Exitoso" : "Error");
			} else {
				salida.put("mensaje",
						"No se ha guardado debido a que el cliente con DNI: " + objCliente.getDni() + " ya existe.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", e.getMessage());
		}

		return ResponseEntity.ok(salida);
	}

	@GetMapping("/listarClientesFiltros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> ListarClienteFiltros(

			@RequestParam(name = "nombres", required = false, defaultValue = "") String nombre,
			@RequestParam(name = "apellidos", required = false, defaultValue = "") String apellidos,
			@RequestParam(name = "dni", required = false, defaultValue = "") String dni,
			@RequestParam(name = "correo", required = false, defaultValue = "") String correo,
			@RequestParam(name = "estado", required = false, defaultValue = "-1") int estado) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Cliente> lista = clienteService.ListarClienteFiltros("%" + nombre + "%", "%" + apellidos + "%",
					"%" + dni + "%", "%" + correo + "%", estado);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existe datos para mostrar");
				salida.put("data", null);
			} else {
				salida.put("data", lista);
				salida.put("mensaje", "Existen " + lista.size() + " datos para mostrar");
			}

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se registró, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);

	}
}
