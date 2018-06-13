package co.ceiba.parqueadero.parqueaderoJohnRamirez.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.ceiba.parqueadero.parqueaderoJohnRamirez.modelo.Parqueadero;
import co.ceiba.parqueadero.parqueaderoJohnRamirez.repositorio.ParqueaderoRepositorio;

@RequestMapping("/parqueadero")
@RestController
public class ParqueaderoRest {

	@Autowired
	ParqueaderoRepositorio parqueaderoRepositorio;
	
	@GetMapping(value = "/parqueaderos")
	public List<Parqueadero> parqueaderos() {
		return parqueaderoRepositorio.findAll();
	}
}
