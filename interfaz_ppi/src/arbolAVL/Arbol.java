package arbolAVL;

import java.util.ArrayList;

public class Arbol {
	/* Atributos */

	private Nodo raiz;

	/* Contructories */
	public Arbol() {
		this.raiz = null;
	}

	/* Setters y Getters */
	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	public boolean agregar(int cedula) {
		Nodo nuevo = new Nodo(cedula, null, null);
		insertar(nuevo, raiz);
		return true;
	}

	public void insertar(Nodo nuevo, Nodo pivote) {
		if (this.raiz == null) {
			raiz = nuevo;
		} else {
			if (nuevo.getCedula() <= pivote.getCedula()) {
				if (pivote.getHojaIzquierda() == null) {
					pivote.setHojaIzquierda(nuevo);
				} else {
					insertar(nuevo, pivote.getHojaIzquierda());
				}
			} else {
				if (pivote.getHojaDerecha() == null) {
					pivote.setHojaDerecha(nuevo);
				} else {
					insertar(nuevo, pivote.getHojaDerecha());
				}
			}
		}

	}

 	public ArrayList preOrden() {
		ArrayList l = new ArrayList();
		preOrden(raiz, l);
		return l;
	}

	private void preOrden(Nodo reco, ArrayList l) {
		if (reco != null) {
			l.add(reco.getCedula() + " ");
			preOrden(reco.getHojaIzquierda(), l);
			preOrden(reco.getHojaDerecha(), l);
		}
	}

	public ArrayList inOrden() {
		ArrayList l = new ArrayList();
		inOrden(raiz, l);
		return l;
	}

	private void inOrden(Nodo reco, ArrayList l) {
		if (reco != null) {
			inOrden(reco.getHojaIzquierda(), l);
			l.add(reco.getCedula() + " ");
			inOrden(reco.getHojaDerecha(), l);
		}
	}

	public ArrayList postOrden() {
		ArrayList l = new ArrayList();
		postOrden(raiz, l);
		return l;
	}

	private void postOrden(Nodo reco, ArrayList l) {
		if (reco != null) {
			postOrden(reco.getHojaIzquierda(), l);
			postOrden(reco.getHojaDerecha(), l);
			l.add(reco.getCedula() + " ");
		}
	}

}
