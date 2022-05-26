package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Cliente;
import com.proyecto.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Override
	public List<Cliente> listaCliente() {
		return repository.findAll();
	}

	@Override
	public boolean RegistrarCliente(Cliente objCliente) {

		
		return repository.save(objCliente)!=null?true:false;
	}

	@Override
	public boolean ExisteCLientePorDNI(String dni) {
		Cliente objCliente=repository.findFirstByDni(dni);
		
		return objCliente!=null?true:false;
	}

	@Override
	public List<Cliente> ListarClienteFiltros(String nombres, String apellidos, String dni, String correo, int estado) {

		return repository.listaClienteFiltros(nombres, apellidos, dni, correo, estado);
	}


	

}
