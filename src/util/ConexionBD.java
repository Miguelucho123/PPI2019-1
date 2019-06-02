package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {

	private static Connection conexion;
	private static final String driver="com.mysql.jdbc.Driver";
	private static final String user="root";
	private static final String password="";
	private static final String url="jdbc:mysql://localhost:3306/numerosenterosbd";
	
	public ConexionBD() {
		conexion=null;
		try {
			Class.forName(driver);
			conexion=DriverManager.getConnection(url,user,password);
			if(conexion!=null) {
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
		if(conexion==null) {
			System.out.println("se ha desconectado la conexión.");
		}
	}
	
	
	public void poblarBD(String num) {
		int i= Integer.parseInt(num);
		int clave= 0;
		
		
		
	}
}
