/*
 * BDOO 1:
 * Punto 3: Crea la clase Jugadores (como el ejemplo anterior) y añade el siguiente
 * atributo con sus getter y setter: private Paises pais;
 */

class Jugadores { //Clase Jugadores
	private String nombre;
	private String deporte;
	private String ciudad;
	private int edad;
	public Jugadores() {}
	public Jugadores(String nombre, String deporte,
		 String ciudad, int edad, Paises pais) {
		 this.nombre = nombre;
		 this.deporte = deporte;
		 this.ciudad = ciudad;
		 this.edad = edad;
		 this.pais = pais;
	}
	
	public void setNombre(String nombre) {this.nombre = nombre;}
	public String getNombre() {return nombre;}
	public void setDeporte(String deporte) {this.deporte = deporte;}
	public String getDeporte() {return deporte;}
	public void setCiudad(String ciudad) {this.ciudad = ciudad;}
	public String getCiudad () {return ciudad;}
	public void setEdad(int edad) {this.edad = edad;}
	public int getEdad() {return edad;}
	
	private Paises pais;
	public Paises getPais() {
		return pais;
	}
	public void setPais(Paises pais) {
		this.pais = pais;
	}
	
}