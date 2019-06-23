package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JOptionPane;

public class ConexionBD {

	private static Connection conexion;
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String user = "root";
	private static final String password = "";
	private static final String url = "jdbc:mysql://localhost:3306/personalbd";
	private ResultSet rs;
	private Statement st;

	public ConexionBD() {
		conexion = null;
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, user, password);
			if (conexion != null) {
				System.out.println("Conexion establecida.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Connection getConnection() {
		return conexion;
	}

	public void desconectar() {
		conexion = null;
		if (conexion == null) {
			System.out.println("se ha desconectado la conexión.");
		}
	}

	public void poblarBD(String num) throws SQLException {
		int i = Integer.parseInt(num);
		int[] edadesAleatorias = Utilidades.generarEdadesAleatorias(num);
		int[] cedulasAleatorias = Utilidades.generarIdentificacionesAleatorios(num);
		String[] nombresAleatorios = Utilidades.generarNombresAleatorios(num);
		Statement poblar = conexion.createStatement();

		for (int k = 0; k < i; k++) {

			String queryPositivos = "INSERT INTO `personas`(`CEDULA`, `NOMBRE`, `EDAD`) VALUES (" + cedulasAleatorias[k]
					+ ",'" + nombresAleatorios[k] + "'," + edadesAleatorias[k] + ")";
			System.out.println(queryPositivos);
			poblar.executeUpdate(queryPositivos);

		}
		desconectar();
		JOptionPane.showMessageDialog(null, "Se pobló correctamente la BD");

	}

	public void agregarDato(String dato) throws SQLException {
		int datoNum = Integer.parseInt(dato);
		Statement ejecutor = conexion.createStatement();
		if (datoNum > 0) {
			String query = "INSERT INTO positivos (num_positivos) VALUES(" + datoNum + ")";
			ejecutor.executeUpdate(query);
		} else {
			String queryNegativos = "INSERT INTO negativos (num_negativos) VALUES(" + datoNum + ")";
			ejecutor.executeUpdate(queryNegativos);
		}

		JOptionPane.showMessageDialog(null, "Se agregó correctamente el dato");
		desconectar();

	}

	public void borrarDato(String dato) throws SQLException {
		int datoNum = Integer.parseInt(dato);
		Statement ejecutor = conexion.createStatement();
		if (datoNum > 0) {
			String query = "DELETE FROM positivos WHERE num_positivos ='" + datoNum + "'";
			ejecutor.executeUpdate(query);
		} else {
			String queryNegativos = "DELETE FROM negativos WHERE num_negativos ='" + datoNum + "'";
			ejecutor.executeUpdate(queryNegativos);
		}

		JOptionPane.showMessageDialog(null, "Se borró correctamente el dato");
		desconectar();
	}

	public void ejecutarQueryCreacion(int cedula, String nombre, int edad) throws SQLException {
		Statement poblar = conexion.createStatement();
		String queryPositivos = "INSERT INTO `personas`(`CEDULA`, `NOMBRE`, `EDAD`) VALUES (" + cedula + ",'" + nombre
				+ "'," + edad + ")";
		System.out.println(queryPositivos);
		poblar.executeUpdate(queryPositivos);
		desconectar();
	}

}