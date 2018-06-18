package co.ceiba.parqueadero.parqueaderojohnramirez.enums;

public enum PropiedadesParqueadero {

	costoHoraCarro("valorHoraCarro"),
	costoHoraMoto("valorHoraMoto"),
	costoDiaCarro("valorDiaCarro"),
	CostoDiaMoto("valorDiaMoto"),
	cantCarrosPermitidos("cantidadCarros"),
	cantMotosPermitidos("cantidadMotos"),
	placasPermitidas("placas");

	private String nombrePropiedad;

	private PropiedadesParqueadero(String nombrePropiead) {
		this.nombrePropiedad = nombrePropiead;
	}

	public String getNombrePropiedad() {
		return nombrePropiedad;
	}
	
}
