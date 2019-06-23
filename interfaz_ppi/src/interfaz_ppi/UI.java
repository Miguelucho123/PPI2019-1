package interfaz_ppi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import util.ConexionBD;

public class UI extends JFrame implements ActionListener {
	JMenuBar barra;
	JMenu menuInteracciones, menuRecorridos;
	JMenuItem registrarUsuario, eliminarUsuario, poblarBD, exportar, inorden, postorden, preorden;

	JTextArea resultado;
	JTextField valor1, valor2;
	public static String sumando, restando, dividiendo, multiplicando;

	public UI() {
		setLayout(null);

		barra = new JMenuBar();
		setJMenuBar(barra);
		menuInteracciones = new JMenu("OPERACIONES");
		barra.add(menuInteracciones);

		menuRecorridos = new JMenu("RECORRIDOS");
		barra.add(menuRecorridos);

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
			// ACA VA METODO DE INORDEN

			resultado.setText("El resultado del recorrido inorden fue: ");
		}
		if (e.getSource() == postorden) {
			// ACA VA METODO POSTORDEN
			resultado.setText("El resultado del recorrido postorden fue: ");
		}
		if (e.getSource() == preorden) {
			resultado.setText("El resultado del recorrido preorden fue: ");
		}
		if (e.getSource() == exportar) {
			// ACA VA EL METODO PARA EXPORTAR

		}

	}

	public static void main(String[] args) {
		UI obj = new UI();
		obj.setBounds(0, 0, 400, 200);
		obj.setVisible(true);
	}

}
