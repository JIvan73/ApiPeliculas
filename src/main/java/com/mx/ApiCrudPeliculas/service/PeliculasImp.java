package com.mx.ApiCrudPeliculas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.mx.ApiCrudPeliculas.controller.Productos;
import com.mx.ApiCrudPeliculas.entity.Peliculas;
import com.mx.ApiCrudPeliculas.repository.PeliculasDao;


@Service
public class PeliculasImp implements PeliculasServ{

	
	//Inyeccion de dependencias
	@Autowired //----permite tener un mejor control de los objetos que se inicializan
	PeliculasDao dao;
	
	/////Transactional rectifica la informacion y verifica que todo este bien
	
	@Transactional(readOnly = true)
	@Override
	public List<Peliculas> listar() {
		// TODO Auto-generated method stub
		return (List<Peliculas>) dao.findAll();
	}

	
	
	
	///validar que el id y el nombre no existan para guardar
	@Transactional
	@Override
	public String guardar(Peliculas pelicula) {
		// TODO Auto-generated method stub
		///Obtener todos los registros de la bd
		////ciclo
		///if
		
		
		String respuesta = "";
		boolean bandera = false;
		for (Peliculas p: dao.findAll()) {
			
////////todos los tipos de datos primitivos y estan parseados  se compara con un equals(todas las cadenas)
			if(p.getId().equals(pelicula.getId())) {
				respuesta = "Existe Id";
				bandera = true;
				break;
			} else if (p.getNombre().equals(pelicula.getNombre())) {
				respuesta="Existe Nombre";
				bandera = true;
				break;
			}

		}
		
		if(bandera=false)
		dao.save(pelicula);
		return respuesta;
	}

	
	@Transactional
	@Override
	public Peliculas buscar(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	
	@Transactional
	@Override
	public boolean editar(Peliculas pelicula) {
		// TODO Auto-generated method stub
		boolean bandera = true;
		if(buscar(pelicula.getId()) == null) {
			bandera = false;
		} else {
			dao.save(pelicula);
		}
		return bandera;
	}

	
	@Transactional
	@Override
	public boolean eliminar(Long Id) {
		// TODO Auto-generated method stub
		boolean bandera = true;
		if(buscar(Id) == null) {
			bandera = false;
		} else {
			dao.deleteById(Id);
		}
		return bandera;
	}


	//Buscar por nombre --- objeto
	//Buscar por genero ----lista(objetos)
	//Eliminar por nombre --- validar que el nombre exista --- mensaje


	@Transactional
	@Override
	public String buscarporNombre(Peliculas pelicula) {
		// TODO Auto-generated method stub
		String respuesta = "";
		boolean bandera = false;
		for (Peliculas p: dao.findAll()) {
			
			if(p.getId().equals(pelicula.getId())) {
				respuesta = "Existe Id";
				bandera = true;
				break;
			} else if (p.getNombre().equals(pelicula.getNombre())) {
				respuesta="Existe Nombre";
				bandera = true;
				break;
			}
		}
		
		if(bandera=false)
		dao.findAll();
		return respuesta;
	}




	@Transactional
	@Override
	public String buscarporGenero(Peliculas pelicula) {
		// TODO Auto-generated method stub
		String respuesta = "";
		boolean bandera = false;
		for (Peliculas p: dao.findAll()) {
			
			if(p.getId().equals(pelicula.getId())) {
				respuesta = "Existe Id";
				bandera = true;
				break;
			} else if (p.getGenero().equals(pelicula.getGenero())) {
				respuesta="Existe este genero";
				bandera = true;
				break;
			}
		}
		
		if(bandera=false)
		dao.findAll();
		return respuesta;
	}



	

	@Transactional
	@Override
	public String EliminarporNombre(Peliculas pelicula) {
		// TODO Auto-generated method stub
		String respuesta = "";
		boolean bandera = false;
		for (Peliculas p: dao.findAll()) {
			
			if(p.getId().equals(pelicula.getId())) {
				respuesta = "Existe este Id";
				bandera = true;
				break;
			} else if (p.getNombre().equals(pelicula.getNombre())) {
				respuesta="Existe Nombre";
				bandera = true;
				break;
			}
		}
		
		if(bandera=false)
		dao.delete(pelicula);
		return respuesta;
	}

	
	
	///Buscar que hay de crud repository y fin byrepository	
}
