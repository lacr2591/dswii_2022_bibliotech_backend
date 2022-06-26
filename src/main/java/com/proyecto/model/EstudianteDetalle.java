package com.proyecto.model;

import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDetalle {

	int id;
	String tipoDocumento;
	String numeroDocumento;
	String nombres;
	String apellidoPaterno;
	String apellidoMaternos;
	String fechaNacimiento;
	String genero;
	String email;
	String telefono;
	String fechaRegistro;
	
}


