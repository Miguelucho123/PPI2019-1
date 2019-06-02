package interfaz;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import util.ConexionBD;

public class Vistas extends JFrame implements ActionListener {

	// ventana principal
	private JPanel miPanel;
	// menu superior
	private JMenuBar barraMenu;
	// opciones del menu superior
	private JMenu menuArchivo, menuRecorrido, menuSalir;
	// opciones del apartado archivo
	private JMenuItem archivoAgregarDato, archivoEliminarDato, archivoExportar, archivoPoblarBD, archivoEstablecerRaiz;
	// opciones del apartado recorridos
	private JMenuItem recorridoINORDEN, recorridoPOSORDEN, recorridoPREORDEN;
	// titulo principal
	private JLabel titulo;
	// titulo apartado archivo
	private JLabel lblAgregarDato, lblEliminarDato, lblExportar, lblMostrarDatoAgg, lblMostrarDatoElim;

	// titulo apartado recorridos
	private JLabel inorden, posorden, preorden;
	// label con el recorrido seleccionado
	private JLabel contenidoInorden, contenidoPosorden, contenidoPreorden;

	String strInorden, strPosorden, strPreorden;

	public Vistas() {
		iniciarComponentes();
		setTitle("PP1-2019-1 ARBOLES AVL");
		// tamaño de la ventana
		setSize(500, 180);
		// pone la ventana en el Centro de la pantalla
		setLocationRelativeTo(null);
		/* impide que la ventana cambie de tamaño */
		setResizable(false);

	}

	private void iniciarComponentes() {
		// inicia las instancias de los componentes

		miPanel = new JPanel();
		miPanel.setLayout(null);
		barraMenu = new JMenuBar();
		menuArchivo = new JMenu();
		menuRecorrido = new JMenu();
		menuSalir = new JMenu();

		archivoAgregarDato = new JMenuItem();
		archivoEliminarDato = new JMenuItem();
		archivoExportar = new JMenuItem();
		archivoPoblarBD = new JMenuItem();
		archivoEstablecerRaiz = new JMenuItem();

		recorridoINORDEN = new JMenuItem();
		recorridoPOSORDEN = new JMenuItem();
		recorridoPREORDEN = new JMenuItem();

		titulo = new JLabel();
		lblAgregarDato = new JLabel();
		lblEliminarDato = new JLabel();
		lblExportar = new JLabel();
		lblMostrarDatoAgg = new JLabel();
		lblMostrarDatoElim = new JLabel();

		inorden = new JLabel();
		posorden = new JLabel();
		preorden = new JLabel();

		contenidoInorden = new JLabel();
		contenidoPosorden = new JLabel();
		contenidoPreorden = new JLabel();

		// tamaño de labels
		titulo.setBounds(10, 0, 80, 30);
		titulo.setText("MENU");

		lblAgregarDato.setBounds(20, 30, 150, 30);
		lblAgregarDato.setText("Dato agregado:");

		lblEliminarDato.setBounds(20, 30, 150, 30);
		lblEliminarDato.setText("Dato eliminado: ");

		lblMostrarDatoAgg.setBounds(60, 60, 400, 30);
		lblMostrarDatoElim.setBounds(60, 60, 400, 30);

		// Crear items del menu archivo

		archivoEstablecerRaiz.setText("Establecer Raíz");
		menuArchivo.add(archivoEstablecerRaiz);
		menuArchivo.addSeparator();

		archivoAgregarDato.setText("Agregar dato");
		menuArchivo.add(archivoAgregarDato);
		menuArchivo.addSeparator();

		archivoEliminarDato.setText("EliminarDato");
		menuArchivo.add(archivoEliminarDato);
		menuArchivo.addSeparator();

		archivoPoblarBD.setText("Poblar BD");
		menuArchivo.add(archivoPoblarBD);
		menuArchivo.addSeparator();

		archivoExportar.setText("EXPORTAR");
		menuArchivo.add(archivoExportar);

		// crear item menu recorridos
		recorridoINORDEN.setText("INORDEN");
		menuRecorrido.add(recorridoINORDEN);
		menuRecorrido.addSeparator();

		recorridoPOSORDEN.setText("POSORDEN");
		menuRecorrido.add(recorridoPOSORDEN);
		menuRecorrido.addSeparator();

		recorridoPREORDEN.setText("PREORDEN");
		menuRecorrido.add(recorridoPREORDEN);

		menuArchivo.setText("ARCHIVO");
		barraMenu.add(menuArchivo);

		menuRecorrido.setText("RECORRIDOS");
		barraMenu.add(menuRecorrido);

		menuSalir.setText("SALIR");
		barraMenu.add(menuSalir);

		setJMenuBar(barraMenu);

		// creamos eventos

		archivoAgregarDato.addActionListener(this);
		archivoEliminarDato.addActionListener(this);
		archivoEstablecerRaiz.addActionListener(this);
		archivoPoblarBD.addActionListener(this);
		archivoExportar.addActionListener(this);

		recorridoINORDEN.addActionListener(this);
		recorridoPOSORDEN.addActionListener(this);
		recorridoPREORDEN.addActionListener(this);

		miPanel.add(titulo);

		miPanel.add(contenidoInorden);
		miPanel.add(contenidoPosorden);
		miPanel.add(contenidoPreorden);

		add(miPanel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		eventosMenuArchivo(e);
		eventosMenuRecorridos(e);
		contenidoInorden.setText("Contenido inorden: " + strInorden);

	}

	private void eventosMenuArchivo(ActionEvent e) {
		if (e.getSource() == archivoEstablecerRaiz) {
			ConexionBD con = new ConexionBD();
			try {
				con.establecerRaiz();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (e.getSource() == archivoAgregarDato) {
			if (lblEliminarDato.isVisible()) {
				lblEliminarDato.setVisible(false);
				lblAgregarDato.setVisible(true);
			}
			miPanel.add(lblAgregarDato);
			miPanel.add(lblMostrarDatoAgg);
			String respuesta = JOptionPane.showInputDialog("dato a insertar");

			lblMostrarDatoAgg.setText(respuesta);
			ConexionBD con = new ConexionBD();
			try {
				con.agregarDato(respuesta);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (e.getSource() == archivoPoblarBD) {

			String numeroRegistros = JOptionPane.showInputDialog("NUMERO DE REGISTROS PARA POBLAR LA BD");
			ConexionBD con = new ConexionBD();

			try {
				con.poblarBD(numeroRegistros);
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

		} else if (e.getSource() == archivoEliminarDato) {

			if (lblAgregarDato.isVisible() && lblMostrarDatoAgg.isVisible()) {
				lblAgregarDato.setVisible(false);
				lblMostrarDatoAgg.setVisible(false);

			}
			miPanel.add(lblEliminarDato);
			miPanel.add(lblMostrarDatoElim);
			String respuesta = JOptionPane.showInputDialog("dato a borrar");

			lblMostrarDatoElim.setText(respuesta);
			ConexionBD con=new ConexionBD();
			try {
				con.borrarDato(respuesta);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			

		} else if (e.getSource() == archivoExportar) {
			System.out.println("exportar");
		}
	}

	private void eventosMenuRecorridos(ActionEvent e) {

		if (e.getSource() == recorridoINORDEN) {

		} else if (e.getSource() == recorridoPOSORDEN) {

		} else if (e.getSource() == recorridoPREORDEN) {

		}
	}

}
