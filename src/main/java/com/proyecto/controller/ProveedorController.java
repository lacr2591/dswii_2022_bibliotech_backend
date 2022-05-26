package com.proyecto.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.proyecto.service.ProveedorService;
import com.proyecto.util.AppSettings;

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


import com.proyecto.entidad.Proveedor;

//http://localhost:8090/rest/modalidad

@RestController
@RequestMapping("/rest/proveedor")
//@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
@CrossOrigin(origins = "http://localhost:4200")


public class ProveedorController {
	
	@Autowired
	private ProveedorService proveedorService;

	@GetMapping("/listarProveedor")
	@ResponseBody
	public ResponseEntity<List<Proveedor>> listaProveedor(){
		List<Proveedor> lista = proveedorService.listaProveedor();
		return ResponseEntity.ok(lista);
	}

	@PostMapping("/insertarProveedor")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaProveedor(@RequestBody Proveedor obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			
			obj.setEstado(1); /* estado activo */
			obj.setFechaRegistro(new Date());
			
			Proveedor objSalida = proveedorService.insertaActualizaProveedor(obj);
			if (objSalida == null) {
				salida.put("mensaje", "No se registró, consulte con el administrador.");
			} else {
				salida.put("mensaje", "Registro exitoso");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se registró, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}
	
	
	
	
 @GetMapping("/listaProveedorConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaProveedorRazonRucDireccion(
			@RequestParam(name = "razonsocial", required = false, defaultValue = "") String razonsocial,
			@RequestParam(name = "ruc", required = false, defaultValue = "") String ruc,
			@RequestParam(name = "direccion", required = false, defaultValue = "") String direccion,
			@RequestParam(name = "estado", required = true, defaultValue = "1") int estado) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Proveedor> lista = proveedorService.listaProveedorRazonRucDireccion("%"+razonsocial+"%",ruc,direccion, estado);
			
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existen datos para mostrar");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Existen " + lista.size() + " elementos para mostrar");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "error");
		}
		return ResponseEntity.ok(salida);
	}
	

	
}
