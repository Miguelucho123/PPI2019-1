package arbolAVL;

public class Nodo {

	/* Declaraciones de variables */
	private String nombre;
	private int edad;
	private int cedula;

	private Nodo hojaIzquierda;
	private Nodo hojaDerecha;

	/* Constructor */
	public Nodo(int cedula, Nodo hojaIzquierda, Nodo hojaDerecha) {
		this.cedula = cedula;

		this.hojaIzquierda = hojaIzquierda;
		this.hojaDerecha = hojaDerecha;

	}



	/* Setters y Getters */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public Nodo getHojaIzquierda() {
		return hojaIzquierda;
	}

	public void setHojaIzquierda(Nodo hojaIzquierda) {
		this.hojaIzquierda = hojaIzquierda;
	}

	public Nodo getHojaDerecha() {
		return hojaDerecha;
	}

	public void setHojaDerecha(Nodo hojaDerecha) {
		this.hojaDerecha = hojaDerecha;
	}

}
