package com.proyecto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entidad.Autores;
import com.proyecto.service.AutoresService;
import com.proyecto.util.AppSettings;

	@RestController
	@RequestMapping("/api/autores")
	@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
	
	public class AutoresController {	
	@Autowired
	private AutoresService autoresService;
	
	@GetMapping("/listarAutores")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> ListarAutores() {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Autores> lista = autoresService.ListarAutores();
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

	@GetMapping("/obtenerAutoresPorId")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> ObtenerCategoriaPorId(
			@RequestParam(name = "id", required = false, defaultValue = "-1") int id) {
		
		Map<String, Object> salida = new HashMap<>();
		
		try {
			Autores obj = autoresService.ObtenerAutoresPorID(id);
			
			if (obj==null) {
				salida.put("mensaje", "No existe datos para mostrar");
				salida.put("data", null);
			} else {
				salida.put("data", obj);
				salida.put("mensaje", "Se encontro un autor");
			}

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se procesó: " + e.getMessage());
		}
		return ResponseEntity.ok(salida);

	}
}

