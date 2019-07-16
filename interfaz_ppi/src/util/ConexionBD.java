package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import javax.swing.JOptionPane;

import arbolAVL.Arbol;
import arbolAVL.Nodo;
import arbolAVL.SimuladorArbol;

public class ConexionBD {

	private static Connection conexion;
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String user = "root";
	private static final String password = "";
	private static final String url = "jdbc:mysql://localhost:3306/personalbd";
	private ResultSet rs;
	private Statement st;
	SimuladorArbol simulador = new SimuladorArbol();

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

	public void agregarPersona(String strCedula, String nombre, String strEdad) throws SQLException {
		int cedula = Integer.valueOf(strCedula);
		int edad = Integer.valueOf(strEdad);

		Statement ejecutor = conexion.createStatement();

		String query = "INSERT INTO `personas`(`CEDULA`, `NOMBRE`, `EDAD`) VALUES (" + cedula + ",'" + nombre + "',"
				+ edad + ")";
		ejecutor.executeUpdate(query);

		JOptionPane.showMessageDialog(null, "Se registró correctamente");
		desconectar();

	}

	public void borrarPersona(String strCedula) throws SQLException {
		int cedula = Integer.valueOf(strCedula);

		Statement ejecutor = conexion.createStatement();

		String query = "DELETE FROM `personas` WHERE  CEDULA='" + cedula + "'";
		ejecutor.executeUpdate(query);

		JOptionPane.showMessageDialog(null, "Se borró correctamente el dato");
		desconectar();
	}

	public void crearArbolConCedulas() {
		String sqlResto = "SELECT * FROM personas ORDER by EDAD DESC";
		int cedula;

		try (Statement st = conexion.createStatement()) {
			// hace la consulta
			ResultSet rs = st.executeQuery(sqlResto);
			while (rs.next()) {
				cedula = rs.getInt(1);
				if (this.simulador.insertar(cedula)) {
					System.out.println("se agregó el arbol correctamente" + cedula);
				}
			}

		} catch (SQLException e) {
			// hacer algo con la excepcion
		}
		desconectar();

	}

	public String preOrdenConCedulas() {
		String sqlResto = "SELECT * FROM personas ORDER by EDAD DESC";
		int cedula;
		SimuladorArbol arboljr = new SimuladorArbol();

		try (Statement st = conexion.createStatement()) {
			// hace la consulta
			ResultSet rs = st.executeQuery(sqlResto);
			while (rs.next()) {
				cedula = rs.getInt(1);
				if (arboljr.insertar(cedula)) {
					//System.out.println("se agregó el arbol correctamente" + cedula);
				}
			}

		} catch (SQLException e) {
			e.getCause();
		}

		return arboljr.preOrden();

	}

	public String inOrdenConCedulas() {
		String sqlResto = "SELECT * FROM personas ORDER by EDAD DESC";
		int cedula;
		SimuladorArbol arboljr = new SimuladorArbol();

		try (Statement st = conexion.createStatement()) {
			// hace la consulta
			ResultSet rs = st.executeQuery(sqlResto);
			while (rs.next()) {
				cedula = rs.getInt(1);
				if (arboljr.insertar(cedula)) {
					// System.out.println("se agregó el arbol correctamente" + cedula);
				}
			}

		} catch (SQLException e) {
			// hacer algo con la excepcion
		}

		return arboljr.inOrden();
	}

	public String posOrdenConCedulas() {
		String sqlResto = "SELECT * FROM personas ORDER by EDAD DESC";
		int cedula;
		SimuladorArbol arboljr = new SimuladorArbol();

		try (Statement st = conexion.createStatement()) {
			// hace la consulta
			ResultSet rs = st.executeQuery(sqlResto);
			while (rs.next()) {
				cedula = rs.getInt(1);
				if (arboljr.insertar(cedula)) {
					// System.out.println("se agregó el arbol correctamente" + cedula);
				}
			}

		} catch (SQLException e) {

		}

		return arboljr.posOrden();
	}

}