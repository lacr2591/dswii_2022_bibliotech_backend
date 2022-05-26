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

import com.proyecto.entidad.Sede;
import com.proyecto.service.SedeService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/url/sede")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class SedeController {

	@Autowired
	private SedeService service;
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> InsertarSede(@RequestBody Sede obj)
	{
		HashMap<String, Object> exit = new HashMap<String, Object>();
		try 
		{
			obj.setIdSede(0);
			obj.setFechaRegistro(new Date());
			obj.setEstado(1);
			Sede objExit = service.InsertSede(obj);
			if (objExit == null) 
			{
				exit.put("message", "Error al registrar ");
				exit.put("status", "error");

			}else {

				exit.put("message", "Registro exitoso");
				exit.put("status", "success");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			exit.put("message", "Error al registrar " + e.getMessage());
			exit.put("status", "error");
		}
		return ResponseEntity.ok(exit);
	}

	@GetMapping
    @ResponseBody
    public ResponseEntity<List<Sede>> listSede(){
        return ResponseEntity.ok(service.ListarSede());
    }
	
	@GetMapping("/listaSedeFiltro")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> listaSedeFiltro
	(
			@RequestParam (name = "nombre",required =  false,defaultValue ="")String nombre,
			@RequestParam (name = "direccion",required =  false,defaultValue ="")String direccion,
			@RequestParam (name = "estado",required =  false,defaultValue = "-1")int estado,
			@RequestParam (name = "fechaCreacion",required =  false,defaultValue ="")String fechaCreacion,
			@RequestParam (name = "fechaRegistro",required =  false,defaultValue ="")String fechaRegistro,
			@RequestParam (name = "codigoPostal",required =  false,defaultValue ="")String codigoPostal,
			@RequestParam (name = "idPais",required =  false,defaultValue ="-1")int idPais
	)		
	{
		Map<String,Object> salida = new HashMap<>();
		if (fechaRegistro.contains("a") || fechaRegistro.contains("m") || fechaRegistro.contains("d"))
		{
			fechaRegistro = "";
		}
		if (fechaCreacion.contains("a") || fechaCreacion.contains("m") || fechaCreacion.contains("d"))
		{
			fechaCreacion = "";
		}
		try 
		{
			
			List<Sede> lista = service.listaSedeFiltro(nombre, direccion, estado, 
					"%"+fechaCreacion+"%", "%"+fechaRegistro+"%", 
					codigoPostal, idPais);
			if(CollectionUtils.isEmpty(lista))
			{
				salida.put("message", "No existe datos para mostrar");
				salida.put("status", "error");
			}
			else
			{
				salida.put("data", lista);
				salida.put("message", "Existe " + lista.size() + " datos para mostrar");
				salida.put("status", "success");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			salida.put("message", "No se encontro registros, consulte con el administrador.");
			salida.put("status", "error");
		}
		
		return ResponseEntity.ok(salida);
	}
}
