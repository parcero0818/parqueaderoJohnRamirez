package co.ceiba.parqueadero.parqueaderojohnramirez.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.ceiba.parqueadero.parqueaderojohnramirez.excepcion.DisponibilidadExcepcion;
import co.ceiba.parqueadero.parqueaderojohnramirez.excepcion.PlacaExcepcion;
import co.ceiba.parqueadero.parqueaderojohnramirez.modelo.TiqueteParqueo;
import co.ceiba.parqueadero.parqueaderojohnramirez.modelo.Vehiculo;
import co.ceiba.parqueadero.parqueaderojohnramirez.repositorio.PropiedadesRepositorio;
import co.ceiba.parqueadero.parqueaderojohnramirez.repositorio.TiqueteParqueoRepositorio;
import co.ceiba.parqueadero.parqueaderojohnramirez.enums.PropiedadesParqueadero;
import co.ceiba.parqueadero.parqueaderojohnramirez.enums.TipoVehiculoEnum;

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
			if (validarDisponibilidadVehiculo(vehiculo)) {
				registrar(vehiculo);
				return true;
			}
		} else if (verificarDiaSemana(calendar)) {
			if (validarDisponibilidadVehiculo(vehiculo)) {
				registrar(vehiculo);
				return true;
			}
		} else {
			throw new PlacaExcepcion("No est� autorizado para ingresar");
		}
		return false;
	}

	public boolean validarDisponibilidadVehiculo(Vehiculo vehiculo) {
		if (isCarro(vehiculo)) {
			if (!parqueaderoService.verificarDisponibilidadCarro(tiqueteParqueoRepositorio)) {
				throw new DisponibilidadExcepcion("No hay cupo en el parqueadero para el tipo de vehiculo");
			}
		} else if (isMoto(vehiculo)) {
			if (parqueaderoService.verificarDisponibilidadMoto(tiqueteParqueoRepositorio)) {
				throw new DisponibilidadExcepcion("No hay cupo en el parqueadero para el tipo de vehiculo");
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
		if (vehiculo.getTipoVehiculo().equalsIgnoreCase(TipoVehiculoEnum.VehiculoCarro.getTipoVehiculo())) {
			return true;
		}
		return false;
	}

	public boolean isMoto(Vehiculo vehiculo) {
		if (vehiculo.getTipoVehiculo().equalsIgnoreCase(TipoVehiculoEnum.VehiculoMoto.getTipoVehiculo())) {
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
		String placasBd = propiedadesRepositorio.obtenerValorPropiedad(PropiedadesParqueadero.PlacasPermitidas.getNombrePropiedad());
		String[] placas = placasBd.toLowerCase().split(",");
		if (!Arrays.asList(placas).contains(placa.toLowerCase().substring(0, 1))) {
			return false;
		}
		return true;
	}

}
