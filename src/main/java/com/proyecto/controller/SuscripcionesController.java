package com.proyecto.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.Reclamo;
import com.proyecto.entidad.Suscripciones;
import com.proyecto.service.ReclamoService;
import com.proyecto.service.SuscripcionesService;
import com.proyecto.service.SuscripcionesServicelmpl;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/url/suscripciones")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class SuscripcionesController {
	@Autowired
	private SuscripcionesService suscripcionesService;
	
	@GetMapping("/listarSuscripciones")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> ListarCategorias() {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Suscripciones> lista = suscripcionesService.listarSuscripciones();
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("data", null);
				salida.put("mensaje", "No existen datos para mostrar");
			} else {
				salida.put("data", lista);
				salida.put("mensaje", "Existen " + lista.size() + " datos para mostrar");
			}

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se procesó: " + e.getMessage());
		}

		return ResponseEntity.ok(salida);
	}

	@GetMapping("/obtenerCategoriaPorId")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> ObtenerCategoriaPorId(
			@RequestParam(name = "id", required = false, defaultValue = "-1") int id) {
		
		Map<String, Object> salida = new HashMap<>();
		
		try {
			Suscripciones obj = suscripcionesService.obtenerPorId(id);
			
			if (obj==null) {
				salida.put("mensaje", "No existe datos para mostrar");
				salida.put("data", null);
			} else {
				salida.put("data", obj);
				salida.put("mensaje", "Se encontro una categoria");
			}

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se procesó: " + e.getMessage());
		}
		return ResponseEntity.ok(salida);

	}
}
