package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>  {

@Query("select p from Producto p where (?1 is '' or p.nombre like ?1) and (?2 is '' or p.serie = ?2) and (?3 is -1 or p.stock =?3) and (?4 is -1 or p.marca.idMarca =?4) and (?5 is -1 or p.estado =?5)")

public List<Producto> listaProductoNombreSerieMarca(String nombre, String serie, int stock, int idMarca, int estado);
	
}
