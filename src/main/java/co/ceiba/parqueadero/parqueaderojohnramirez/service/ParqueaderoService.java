package co.ceiba.parqueadero.parqueaderojohnramirez.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.ceiba.parqueadero.parqueaderojohnramirez.repositorio.PropiedadesRepositorio;
import co.ceiba.parqueadero.parqueaderojohnramirez.repositorio.TiqueteParqueoRepositorio;
import co.ceiba.parqueadero.parqueaderojohnramirez.enums.PropiedadesParqueadero;
@Controller
public class ParqueaderoService implements IParqueaderoService{
	
	@Autowired
	PropiedadesRepositorio propiedadesRepositorio;

	public boolean verificarDisponibilidadCarro(TiqueteParqueoRepositorio tiqueteParqueoRepositorio) {
		int cantidadCarrosPermitidos = Integer.parseInt(obtenerValorPropiedad(PropiedadesParqueadero.CantCarrosPermitidos.getNombrePropiedad()));
		if (cantidadCarrosParqueados(tiqueteParqueoRepositorio) < cantidadCarrosPermitidos) {
			return true;
		}
		return false;
	}

	public boolean verificarDisponibilidadMoto(TiqueteParqueoRepositorio tiqueteParqueoRepositorio) {
		int cantidadMotosPermitidos = Integer.parseInt(obtenerValorPropiedad(PropiedadesParqueadero.CantMotosPermitidos.getNombrePropiedad()));
		if (cantidadMotosParqueados(tiqueteParqueoRepositorio) < cantidadMotosPermitidos) {
			return true;
		}
		return false;
	}
	
	public String obtenerValorPropiedad(String nombrePropiedad) {
		return propiedadesRepositorio.obtenerValorPropiedad(nombrePropiedad);
	}
	
	public int cantidadMotosParqueados(TiqueteParqueoRepositorio tiqueteParqueoRepositorio) {
		return tiqueteParqueoRepositorio.cantidadMotosParqueados();
	}
	
	public int cantidadCarrosParqueados(TiqueteParqueoRepositorio tiqueteParqueoRepositorio) {
		return tiqueteParqueoRepositorio.cantidadCarrosParqueados();
	}
}
