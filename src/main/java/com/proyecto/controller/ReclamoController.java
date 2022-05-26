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

import com.proyecto.entidad.Reclamo;
import com.proyecto.service.ReclamoService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/url/reclamo")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ReclamoController {
	@Autowired
	private ReclamoService service;

	@GetMapping("/listForFilters")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaDocenteNombreDniUbigeo(
			@RequestParam(name="descripcion", required = false, defaultValue = "") String descripcion,
			@RequestParam(name="estado", required = false, defaultValue = "-1") int estado,
			@RequestParam(name="idTipoReclamo", required = false, defaultValue = "-1") int idTipoReclamo,
			@RequestParam(name="idCliente", required = false, defaultValue = "-1") int idCliente
			){
		Map<String, Object> messageResponse = new HashMap<>();
		try {
			List<Reclamo> lista=service.listReclamoForFilters("%"+descripcion+"%", estado, idTipoReclamo, idCliente);
			if (CollectionUtils.isEmpty(lista)) {
				messageResponse.put("message", "No existen datos para mostrar");
				messageResponse.put("status", "error");
			}else {
				messageResponse.put("data", lista);
				messageResponse.put("rows", lista.size());
				messageResponse.put("message", "Listado Correctamente");
				messageResponse.put("status", "OK");
			}
		} catch (Exception e) {
			e.printStackTrace();
			messageResponse.put("message", "Error en el listado " + e.getMessage());
			messageResponse.put("status", "error");
		}
		return ResponseEntity.ok(messageResponse);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> insertReclamo(@RequestBody Reclamo obj) {
		HashMap<String, Object> messageResponse = new HashMap<String, Object>();
		try {
			obj.setIdReclamo(0);
			obj.setFechaRegistro(new Date());
			obj.setEstado(1);
			Reclamo objResponse = service.insertUpdateReclamo(obj);
			if (objResponse == null) {
				messageResponse.put("message", "Error en el registro ");
				messageResponse.put("status", "error");
			} else {
				messageResponse.put("message", "Registro exitoso");
				messageResponse.put("status", "OK");
			}
		} catch (Exception e) {
			e.printStackTrace();
			messageResponse.put("message", "Error en el registro " + e.getMessage());
			messageResponse.put("status", "error");
		}
		return ResponseEntity.ok(messageResponse);
	}
}
