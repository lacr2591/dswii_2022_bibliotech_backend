package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.Cliente;

public interface ClienteService {

	public abstract List<Cliente> listaCliente();

	public abstract boolean RegistrarCliente(Cliente objCliente);

	public abstract boolean ExisteCLientePorDNI(String dni);

	public abstract List<Cliente> ListarClienteFiltros(String nombres, String apellidos, String dni, String correo,
			int estado);

}
