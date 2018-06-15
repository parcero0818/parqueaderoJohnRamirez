package co.ceiba.parqueadero.parqueaderoJohnRamirez.rest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.ceiba.parqueadero.parqueaderoJohnRamirez.modelo.TiqueteParqueo;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.modelo.Vehiculo;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.repositorio.TiqueteParqueoRepositorio;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.service.VigilanteService;

@RequestMapping("/parqueadero")
@RestController
public class ParqueaderoRest {

	@Autowired
	VigilanteService vigilanteService;
	
	@Autowired
	TiqueteParqueoRepositorio tiqueteParqueoRepositorio;

	@GetMapping(value = "/parqueaderos")
	public void parqueaderos() {
		Vehiculo vehiculo = new Vehiculo("FZV-283", 220, "Carro");
		Calendar calendar = Calendar.getInstance();
		vigilanteService.registrarIngreso(vehiculo, calendar);
	}
	
	
	@GetMapping(value = "/getparqueaderos")
	public List<TiqueteParqueo> getParqueaderos() {
		return tiqueteParqueoRepositorio.findAll();
	}
}
