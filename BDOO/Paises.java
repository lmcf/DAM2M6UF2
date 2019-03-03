/*
 * BDOO 1:
 * Punto 1: Crea la clase Paises con dos atributos y sus getter y setter.
 *  Los atributos son: private int id; private String nombrepais;
 *  
 *  Punto 2: Añade también el método toString() para que devuelva el nombre del país:
 *  public String toString() {return nombrepais;}
 * */

public class Paises {	
	private int id;
	
	public Paises(int id, String nombrePais) {
		super();
		this.id = id;
		this.nombrePais = nombrePais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	private String nombrePais;
	
	public String toString() {
		return nombrePais;
	}
}
