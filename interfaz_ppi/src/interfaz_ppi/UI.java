package interfaz_ppi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import util.ConexionBD;

public class UI extends JFrame implements ActionListener {
	JMenuBar barra;
	JMenu menuInteracciones, menuRecorridos, menuCrearArbol;
	JMenuItem registrarUsuario, eliminarUsuario, poblarBD, exportar, inorden, postorden, preorden, crearArbol;

	JTextArea resultado;
	JTextField valor1, valor2;

	public UI() {
		setLayout(null);

		barra = new JMenuBar();
		setJMenuBar(barra);
		menuInteracciones = new JMenu("OPERACIONES");
		barra.add(menuInteracciones);

		menuRecorridos = new JMenu("RECORRIDOS");
		barra.add(menuRecorridos);

		menuCrearArbol = new JMenu("CREAR ARBOL");
		barra.add(menuCrearArbol);

		registrarUsuario = new JMenuItem("Ingresar");
		registrarUsuario.addActionListener(this);
		menuInteracciones.add(registrarUsuario);

		eliminarUsuario = new JMenuItem("Eliminar");
		eliminarUsuario.addActionListener(this);
		menuInteracciones.add(eliminarUsuario);

		poblarBD = new JMenuItem("Poblar");
		poblarBD.addActionListener(this);
		menuInteracciones.add(poblarBD);

		inorden = new JMenuItem("Inorden");
		inorden.addActionListener(this);
		menuRecorridos.add(inorden);

		postorden = new JMenuItem("postorden");
		postorden.addActionListener(this);
		menuRecorridos.add(postorden);

		preorden = new JMenuItem("preorden");
		preorden.addActionListener(this);
		menuRecorridos.add(preorden);

		exportar = new JMenuItem("Exportar");
		exportar.addActionListener(this);
		menuRecorridos.add(exportar);

		crearArbol = new JMenuItem("crear arbol");
		crearArbol.addActionListener(this);
		menuCrearArbol.add(crearArbol);

		resultado = new JTextArea("Resultados");
		resultado.setBounds(110, 30, 500, 350);
		resultado.setOpaque(false);
		resultado.setEditable(false);
		add(resultado);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == registrarUsuario) {
			String cedula = JOptionPane.showInputDialog(registrarUsuario, "Ingresa Cedula",
					JOptionPane.QUESTION_MESSAGE);
			String nombre = JOptionPane.showInputDialog(registrarUsuario, "Ingresa nombre",
					JOptionPane.QUESTION_MESSAGE);
			String edad = JOptionPane.showInputDialog(registrarUsuario, "Ingresa edad", JOptionPane.QUESTION_MESSAGE);

			ConexionBD aggDato = new ConexionBD();
			try {
				aggDato.agregarPersona(cedula, nombre, edad);
				resultado.setText("El usuario que se registró fue la cedula: " + cedula + "\nCon el nombre: " + nombre
						+ "\nCon la edad: " + edad);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (e.getSource() == eliminarUsuario) {
			String cedulaAEliminar = JOptionPane.showInputDialog(eliminarUsuario, "Ingresa Cedula para eliminar",
					JOptionPane.QUESTION_MESSAGE);

			ConexionBD elimDato = new ConexionBD();
			try {
				elimDato.borrarPersona(cedulaAEliminar);
				resultado.setText("El usuario con cedula " + cedulaAEliminar + "ah sido eliminado");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (e.getSource() == poblarBD) {
			String cantidadPoblar = JOptionPane.showInputDialog(poblarBD,
					"cuantos usuarios quieres que se generen aleatoriamente", JOptionPane.QUESTION_MESSAGE);

			ConexionBD pobarbd = new ConexionBD();
			try {
				pobarbd.poblarBD(cantidadPoblar);
				resultado.setText("se ha registrado " + cantidadPoblar + " usuarios.");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (e.getSource() == inorden) {

			ConexionBD inOrden = new ConexionBD();
			System.out.println(inOrden.inOrdenConCedulas());
			resultado.setText("El resultado del recorrido inorden fue: " + inOrden.inOrdenConCedulas());
			inOrden.desconectar();
		}
		if (e.getSource() == postorden) {
			ConexionBD posOrden = new ConexionBD();
			resultado.setText("El resultado del recorrido postorden fue: " + posOrden.posOrdenConCedulas());
			posOrden.desconectar();
		}
		if (e.getSource() == preorden) {

			ConexionBD preOrden = new ConexionBD();
			preOrden.preOrdenConCedulas();
			resultado.setText("El resultado del recorrido preorden fue: " + preOrden.preOrdenConCedulas());
			preOrden.desconectar();

		}
		if (e.getSource() == exportar) {
			String texto = resultado.getText();
			System.out.println(texto);
			try {
				String ruta = "src/ResultadoExportar//archivoResultados.txt";
		        File archivo = new File(ruta);
		        BufferedWriter bw;
		        if(archivo.exists()) {
		            bw = new BufferedWriter(new FileWriter(archivo));
		            bw.write(texto);
		        } else {
		            bw = new BufferedWriter(new FileWriter(archivo));
		            bw.write(texto);
		        }
		        bw.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		if (e.getSource() == crearArbol) {
			ConexionBD crearArbol = new ConexionBD();
			crearArbol.crearArbolConCedulas();
		}

	}

	public static void main(String[] args) {
		UI obj = new UI();
		obj.setBounds(0, 0, 400, 200);
		obj.setVisible(true);
	}

}
