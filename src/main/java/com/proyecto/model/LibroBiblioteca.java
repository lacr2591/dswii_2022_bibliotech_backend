package com.proyecto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibroBiblioteca {
	
	int idLibro;
	int cantidad;
	String title; 
	String edicion;
	String coverLink;
	String email;

}
