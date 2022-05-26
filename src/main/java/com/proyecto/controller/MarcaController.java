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

import com.proyecto.entidad.Marca;
import com.proyecto.service.MarcaService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/url/marca")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class MarcaController {

	@Autowired
	private MarcaService marcaService;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> registraMarca(@RequestBody Marca obj) {
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			
			obj.setIdMarca(0);
			obj.setEstado(1); /* estado activo */
			obj.setFechaRegistro(new Date());
			
			Marca objSalida = marcaService.registraActualizaMarca(obj);
			
				if (objSalida == null) {
					salida.put("mensaje", "Error en el registro ");
				} else {
					salida.put("mensaje", "Registro exitoso");   }
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error en el registro " + e.getMessage());
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/listaMarcaPorParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaMarcaNombrePaisFecha(
			
			@RequestParam(name = "nombre", required = false, defaultValue = "") String nombre,
			@RequestParam(name = "estado", required = true, defaultValue = "1") int estado,
			@RequestParam(name = "idPais", required = false, defaultValue = "-1") int idPais,
			@RequestParam(name = "fechaInicio", required = false, defaultValue = "") String fechaInicio,
			@RequestParam(name = "fechaFin", required = false, defaultValue = "") String fechaFin
	) {
		
	Map<String, Object> salida = new HashMap<>();
	
	try {
		List<Marca> lista = marcaService.listaMarcaNombrePaisFecha("%"+nombre+"%", estado, idPais, fechaInicio, fechaFin);
		if (CollectionUtils.isEmpty(lista)) {
			salida.put("mensaje", "No existen datos para mostrar");
		}else {
			salida.put("lista", lista);
			salida.put("mensaje", "Existen " + lista.size() + " elementos para mostrar");
		}
	} catch (Exception e) {
		e.printStackTrace();
		salida.put("mensaje", "No se registró, consulte con el administrador");
	}
	
	return ResponseEntity.ok(salida);
	}
}
