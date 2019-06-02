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
	private static final String url = "jdbc:mysql://localhost:3306/numerosenterosbd";
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

	public void establecerRaiz() throws SQLException {
		int neutro = 0;

		Statement s1 = conexion.createStatement();
		String queryConsulta = "SELECT * FROM neutros";
		rs = s1.executeQuery(queryConsulta);
		if (rs.next()) {
			System.out.println("Ya hay dato neutro en la BD");

			System.out.println("Dato: " + rs.getString(1));

		} else {
			st = conexion.createStatement();

			String query = "INSERT INTO neutros (num_neutro) VALUES(" + neutro + ")";
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Se ingresó correctamente el número neutro");

		}

		desconectar();

	}

	public void poblarBD(String num) throws SQLException {
		int i = Integer.parseInt(num);
		Statement poblar = conexion.createStatement();

		Random rnd = new Random();
		for (int k = 1; k <= i; k++) {
			int numRamdon = rnd.nextInt();
			if (numRamdon > 0) {
				String queryPositivos = "INSERT INTO positivos (num_positivos) VALUES(" + numRamdon + ")";
				poblar.executeUpdate(queryPositivos);
			} else {
				String queryNegativos = "INSERT INTO negativos (num_negativos) VALUES(" + numRamdon + ")";
				poblar.executeUpdate(queryNegativos);

			}

		}

		JOptionPane.showMessageDialog(null, "Se pobló correctamente la BD");
		desconectar();
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

}
