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
public class Estudiante {

	int id;
	String numeroDocumento;
	String nombres;
	String apellidoPaterno;
	String apellidoMaternos;
}
