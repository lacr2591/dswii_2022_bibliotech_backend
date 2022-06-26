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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entidad.Biblioteca;
import com.proyecto.entidad.Usuario;
import com.proyecto.model.Estudiante;
import com.proyecto.service.BibliotecaService;
import com.proyecto.service.BibliotecaServiceImpl;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/api/biblioteca")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)

public class BibliotecaController {
	
	@Autowired
	private BibliotecaService bibliotecaService;
			
}
