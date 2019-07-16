package arbolAVL;

import java.util.ArrayList;

public class SimuladorArbol {

	public SimuladorArbol() {
	}

	Arbol miArbol = new Arbol();

	public boolean insertar(int dato) {
		return (this.miArbol.agregar(dato));
	}

	public String preOrden() {
		ArrayList it = this.miArbol.preOrden();
		return (recorrido(it, "Recorrido PreOrden"));
	}

	public String inOrden() {
		ArrayList it = this.miArbol.inOrden();
		return (recorrido(it, "Recorrido InOrden"));
	}

	public String posOrden() {
		ArrayList it = this.miArbol.postOrden();
		return (recorrido(it, "Recorrido PosOrden"));
	}

	private String recorrido(ArrayList it, String msg) {
		int i = 0;
		String r = msg + "\n";
		while (i < it.size()) {
			r += "\t" + it.get(i).toString() + "\n";
			i++;
		}
		return (r);
	}

}
