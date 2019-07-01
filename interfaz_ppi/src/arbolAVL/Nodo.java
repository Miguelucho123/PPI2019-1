package arbolAVL;

public class Nodo {

	/* Declaraciones de variables */
	private String nombre;
	private int edad;
	private int cedula;

	private Nodo padre;
	private Nodo hojaIzquierda;
	private Nodo hojaDerecha;

	/* Constructor */
	public Nodo(int cedula, String nombre, int edad) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.edad = edad;
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

	public Nodo getPadre() {
		return padre;
	}

	public void setPadre(Nodo padre) {
		this.padre = padre;
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
