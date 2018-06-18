package co.ceiba.parqueadero.parqueaderojohnramirez.enums;

public enum PropiedadesParqueadero {

	CostoHoraCarro("valorHoraCarro"),
	CostoHoraMoto("valorHoraMoto"),
	CostoDiaCarro("valorDiaCarro"),
	CostoDiaMoto("valorDiaMoto"),
	CantCarrosPermitidos("cantidadCarros"),
	CantMotosPermitidos("cantidadMotos"),
	PlacasPermitidas("placas");

	private String nombrePropiedad;

	private PropiedadesParqueadero(String nombrePropiead) {
		this.nombrePropiedad = nombrePropiead;
	}

	public String getNombrePropiedad() {
		return nombrePropiedad;
	}
	
}
