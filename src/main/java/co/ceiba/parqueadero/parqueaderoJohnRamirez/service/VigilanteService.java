package co.ceiba.parqueadero.parqueaderoJohnRamirez.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.ceiba.parqueadero.parqueaderoJohnRamirez.enums.TipoVehiculoEnum;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.excepcion.DisponibilidadExcepcion;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.excepcion.PlacaExcepcion;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.modelo.TiqueteParqueo;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.modelo.Vehiculo;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.repositorio.TiqueteParqueoRepositorio;

@Controller
public class VigilanteService {
	@Autowired
	TiqueteParqueoRepositorio tiqueteParqueoRepositorio;
	TiqueteParqueo tiqueteParqueo;

	public void registrarIngreso(Vehiculo vehiculo, Calendar calendar) {
		if (!verificarPlaca(vehiculo.getPlaca())) {
			if (vehiculo.getTipoVehiculo().equalsIgnoreCase(TipoVehiculoEnum.Carro.toString())) {
				if (verificarDisponibilidadCarro(tiqueteParqueoRepositorio.cantidadCarrosParqueados())) {
					tiqueteParqueo = new TiqueteParqueo(vehiculo.getPlaca(), vehiculo.getTipoVehiculo(),
							vehiculo.getCilindraje(), new Date(), null, 0);
					tiqueteParqueoRepositorio.save(tiqueteParqueo);
				} else {
					throw new DisponibilidadExcepcion("No hay cupo en el parqueadero para carros");
				}
			} else if (vehiculo.getTipoVehiculo().equalsIgnoreCase(TipoVehiculoEnum.Moto.toString())) {
				if (verificarDisponibilidadMoto(tiqueteParqueoRepositorio.cantidadMotosParqueados())) {
					tiqueteParqueo = new TiqueteParqueo(vehiculo.getPlaca(), vehiculo.getTipoVehiculo(),
							vehiculo.getCilindraje(), new Date(), null, 0);
					tiqueteParqueoRepositorio.save(tiqueteParqueo);
				} else {
					throw new DisponibilidadExcepcion("No hay cupo en el parqueadero para motos");
				}
			}
		} else if (verificarDiaSemana(calendar)) {
			if (vehiculo.getTipoVehiculo().equalsIgnoreCase(TipoVehiculoEnum.Carro.toString())) {
				if (verificarDisponibilidadCarro(tiqueteParqueoRepositorio.cantidadCarrosParqueados())) {
					tiqueteParqueo = new TiqueteParqueo(vehiculo.getPlaca(), vehiculo.getTipoVehiculo(),
							vehiculo.getCilindraje(), new Date(), null, 0);
					tiqueteParqueoRepositorio.save(tiqueteParqueo);
				} else {
					throw new DisponibilidadExcepcion("No hay cupo en el parqueadero para carros");
				}
			} else if (vehiculo.getTipoVehiculo().equalsIgnoreCase(TipoVehiculoEnum.Moto.toString())) {
				if (verificarDisponibilidadMoto(tiqueteParqueoRepositorio.cantidadMotosParqueados())) {
					tiqueteParqueo = new TiqueteParqueo(vehiculo.getPlaca(), vehiculo.getTipoVehiculo(),
							vehiculo.getCilindraje(), new Date(), null, 0);
					tiqueteParqueoRepositorio.save(tiqueteParqueo);
				} else {
					throw new DisponibilidadExcepcion("No hay cupo en el parqueadero para motos");
				}
			}
		} else {
			throw new PlacaExcepcion("No está autorizado para ingresar");
		}
	}

	public boolean verificarDiaSemana(Calendar calendar) {
		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
				|| calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
			return true;
		}
		return false;
	}

	public boolean verificarPlaca(String placa) {
		if (!placa.toLowerCase().startsWith("a")) {
			return false;
		}
		return true;
	}

	public boolean verificarDisponibilidadCarro(int cantidadCarrosParqueados) {
		if (cantidadCarrosParqueados < 20) {
			return true;
		}
		return false;
	}

	public boolean verificarDisponibilidadMoto(int cantidadMotosParqueados) {
		if (cantidadMotosParqueados < 10) {
			return true;
		}
		return false;
	}

}
