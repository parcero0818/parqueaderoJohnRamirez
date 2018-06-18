package co.ceiba.parqueadero.parqueaderojohnramirez.service;

import co.ceiba.parqueadero.parqueaderojohnramirez.repositorio.TiqueteParqueoRepositorio;

public interface IParqueaderoService {

	public boolean verificarDisponibilidadCarro(TiqueteParqueoRepositorio tiqueteParqueoRepositorio);

	public boolean verificarDisponibilidadMoto(TiqueteParqueoRepositorio tiqueteParqueoRepositorio);

	public String obtenerValorPropiedad(String nombrePropiedad);

	public int cantidadMotosParqueados(TiqueteParqueoRepositorio tiqueteParqueoRepositorio);

	public int cantidadCarrosParqueados(TiqueteParqueoRepositorio tiqueteParqueoRepositorio);
}
