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

import com.proyecto.entidad.Producto;
import com.proyecto.service.ProductoService;
import com.proyecto.util.AppSettings;



@RestController
@RequestMapping("/url/producto")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Producto>> listaProducto(){
		List<Producto> lista = productoService.listaProducto();
		return ResponseEntity.ok(lista);
	}
 
	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaProducto(@RequestBody Producto obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setEstado(1);
			obj.setFechaRegistro(new Date());
			Producto objSalida = productoService.insertaActualizaProducto(obj);
			if (objSalida == null) {
				salida.put("mensaje", "No se registró, consulte con el administrador.");
			}else {
				salida.put("mensaje", "Se registró correctamente.");
						}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se registró, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/listaVariables")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaProductoNombreSerieMarca(

		@RequestParam(name = "nombre", required = false, defaultValue = "") String nombre,
		@RequestParam(name = "serie", required = false, defaultValue = "") String serie,
		@RequestParam(name = "stock", required = false, defaultValue = "-1") int stock,
		@RequestParam(name = "idMarca", required = false, defaultValue = "-1") int idMarca,
		@RequestParam(name = "estado", required = false, defaultValue = "-1") int estado
		){
		Map<String, Object> salida = new HashMap<>();
	try {
		List<Producto> lista = productoService.listaProductoNombreSerieMarca("%"+nombre+"%", serie, stock, idMarca, estado);
		if (CollectionUtils.isEmpty(lista)) {
			salida.put("mensaje", "No existe datos para mostrar");
		}else {
			salida.put("data", lista);
			salida.put("mensaje", "Existen " + lista.size() + " datos para mostrar");
		}
	
	}catch (Exception e) {
		e.printStackTrace();
		salida.put("mensaje", "No se registró, consulte con el administrador.");
	}
		return ResponseEntity.ok(salida);

	}
}
