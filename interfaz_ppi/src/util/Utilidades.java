package util;

public class Utilidades {

	public static String[] generarNombresAleatorios(String strCantidad) {
		int cantidad = Integer.valueOf(strCantidad);
		String[] nombresAleatorios = new String[cantidad];

		String[] nombres = { "Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
				"Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
				"Caritina", "Carlota", "Baltazar" };
		String[] apellidos = { "Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
				"Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
				"Grigalva" };

		for (int i = 0; i < cantidad; i++) {
			nombresAleatorios[i] = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))] + " "
					+ apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))];
		}
		return nombresAleatorios;
	}

	public static int[] generarIdentificacionesAleatorios(String strCantidad) {
		int cantidad = Integer.valueOf(strCantidad);
		int[] cedulasAleatorias = new int[cantidad];
		int rangoN = 2019050501;
		int rangoM = 2019060603;

		for (int i = 0; i < cantidad; i++) {
			int identificacionAleatoria = (int) Math.floor(Math.random() * (rangoM - rangoN + 1) + rangoM);

			cedulasAleatorias[i] = identificacionAleatoria;

		}

		return cedulasAleatorias;
	}
	
	public static int[] generarEdadesAleatorias(String strCantidad) {
		int cantidad = Integer.valueOf(strCantidad);
		int[] edadesAleatorias = new int[cantidad];
		int rangoN = 1;
		int rangoM = 20;

		for (int i = 0; i < cantidad; i++) {
			int edadAleatoria = (int) Math.floor(Math.random() * (rangoM - rangoN + 1) + rangoM);

			edadesAleatorias[i] = edadAleatoria;

		}

		return edadesAleatorias;
	}

	public static void imprimir(int[] nombresGenerados) {
		for (int i = 0; i < nombresGenerados.length; i++) {
			System.out.println(nombresGenerados[i]);
		}
	}

	public static void main(String[] args) {
		imprimir(generarEdadesAleatorias("5"));
	}

}
