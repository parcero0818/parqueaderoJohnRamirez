package co.ceiba.parqueadero.parqueaderoJohnRamirez.enums;

public enum Propiedades {

	valorHoraCarro("valorHoraCarro"),
	valorHoraMoto("valorHoraMoto"),
	valorDiaCarro("valorDiaCarro"),
	valorDiaMoto("valorDiaMoto"),
	cantidadCarros("cantidadCarros"),
	cantidadMotos("cantidadMotos"),
	placas("placas");

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
