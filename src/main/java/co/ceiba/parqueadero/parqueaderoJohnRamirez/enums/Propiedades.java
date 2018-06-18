package co.ceiba.parqueadero.parqueaderoJohnRamirez.enums;

public enum Propiedades {

	costoHoraCarro("valorHoraCarro"),
	costoHoraMoto("valorHoraMoto"),
	costoDiaCarro("valorDiaCarro"),
	CostoDiaMoto("valorDiaMoto"),
	cantCarrosPermitidos("cantidadCarros"),
	cantMotosPermitidos("cantidadMotos"),
	placasPermitidas("placas");

	private String nombrePropiedad;

	Propiedades(String nombrePropiead) {
		this.nombrePropiedad = nombrePropiead;
	}

	public String getNombrePropiedad() {
		return nombrePropiedad;
	}

	public void setNombrePropiedad(String nombrePropiedad) {
		this.nombrePropiedad = nombrePropiedad;
	}

}
