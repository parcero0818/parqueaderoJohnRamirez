package co.ceiba.parqueadero.parqueaderoJohnRamirez.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.ceiba.parqueadero.parqueaderoJohnRamirez.enums.Propiedades;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.enums.TipoVehiculoEnum;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.excepcion.DisponibilidadExcepcion;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.excepcion.PlacaExcepcion;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.modelo.TiqueteParqueo;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.modelo.Vehiculo;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.repositorio.PropiedadesRepositorio;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.repositorio.TiqueteParqueoRepositorio;

@Controller
public class VigilanteService implements IVigilanteService {
	@Autowired
	TiqueteParqueoRepositorio tiqueteParqueoRepositorio;
	@Autowired
	ParqueaderoService parqueaderoService;
	@Autowired
	PropiedadesRepositorio propiedadesRepositorio;
	TiqueteParqueo tiqueteParqueo;

	public boolean registrarIngreso(Vehiculo vehiculo, Calendar calendar) {
		if (!verificarPlaca(vehiculo.getPlaca())) {
			if (validarTipoVehiculo(vehiculo)) {
				registrar(vehiculo);
				return true;
			}
		} else if (verificarDiaSemana(calendar)) {
			if (validarTipoVehiculo(vehiculo)) {
				registrar(vehiculo);
				return true;
			}
		} else {
			throw new PlacaExcepcion("No está autorizado para ingresar");
		}
		return false;
	}

	public boolean validarTipoVehiculo(Vehiculo vehiculo) {
		if (isCarro(vehiculo)) {
			if (!parqueaderoService.verificarDisponibilidadCarro(tiqueteParqueoRepositorio)) {
				throw new DisponibilidadExcepcion("No hay cupo en el parqueadero para carros");
			}
		} else if (isMoto(vehiculo)) {
			if (parqueaderoService.verificarDisponibilidadMoto(tiqueteParqueoRepositorio)) {
				throw new DisponibilidadExcepcion("No hay cupo en el parqueadero para motos");
			}
		}
		return true;
	}

	public void registrar(Vehiculo vehiculo) {
		tiqueteParqueo = new TiqueteParqueo(vehiculo.getPlaca(), vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(),
				new Date(), null, 0);
		tiqueteParqueoRepositorio.save(tiqueteParqueo);
	}

	public boolean isCarro(Vehiculo vehiculo) {
		if (vehiculo.getTipoVehiculo().equalsIgnoreCase(TipoVehiculoEnum.Carro.toString())) {
			return true;
		}
		return false;
	}

	public boolean isMoto(Vehiculo vehiculo) {
		if (vehiculo.getTipoVehiculo().equalsIgnoreCase(TipoVehiculoEnum.Moto.toString())) {
			return true;
		}
		return false;
	}

	public boolean verificarDiaSemana(Calendar calendar) {
		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
				|| calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
			return true;
		}
		return false;
	}

	public boolean verificarPlaca(String placa) {
		String placasBd = propiedadesRepositorio.obtenerValorPropiedad(Propiedades.placas.toString());
		String[] placas = placasBd.toLowerCase().split(",");
		if (!Arrays.asList(placas).contains(placa.toLowerCase().substring(0, 1))) {
			return false;
		}
		return true;
	}

}
