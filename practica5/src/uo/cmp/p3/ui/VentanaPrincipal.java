package uo.cmp.p3.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uo.cmp.p3.model.Articulo;
import uo.cmp.p3.model.Carta;
import uo.cmp.p3.service.McDonalds;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PanelVentanaPrincipal;
	private JLabel labelArticulos;
	private JLabel labelUnidades;
	private JButton botonAñadirUnidades;
	private JLabel LabelPrecioPedido;
	private JButton botonSiguiente;
	private JButton botonCancelar;
	private JLabel ImagenLogo;
	private JLabel titulo;
	private JComboBox comboArticulos;
	private JSpinner spinnerUnidades;
	private JTextField textFieldPrecio;

	private McDonalds mc;
	private JButton botonEliminar;
	private JScrollPane scrollPane;
	private JTextArea textAreaPedido;
	private JToggleButton ToggleBotonPedido;
	private JLabel labelImagenesProductos;
	private JMenuBar menuBar;
	private JMenu mnPedido;
	private JMenu mnAyuda;
	private JMenuItem mnItemNuevo;
	private JMenuItem mntmSalir;
	private JSeparator separator;
	private JMenuItem mntmContenidos;
	private JMenuItem mntmAcercaDe;
	private JSeparator separator_1;
	private JPanel panelFiltro;
	private JButton btTodos;
	private JButton btPostres;
	private JButton btHamburguesa;
	private JButton btBebida;
	private JButton btComplementos;
	
	
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(McDonalds mc) {
		
		this.mc = mc;
		
		setTitle("McDonalds´s España");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 457);
		setJMenuBar(getMenuBar_1());
		PanelVentanaPrincipal = new JPanel();
		PanelVentanaPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelVentanaPrincipal);
		PanelVentanaPrincipal.setLayout(null);
		PanelVentanaPrincipal.add(getLabelArticulos());
		PanelVentanaPrincipal.add(getLabelUnidades());
		PanelVentanaPrincipal.add(getBotonAniadirUnidades());
		PanelVentanaPrincipal.add(getLabelPrecioPedido());
		PanelVentanaPrincipal.add(getBotonSiguiente());
		PanelVentanaPrincipal.add(getBotonCancelar());
		PanelVentanaPrincipal.add(getImagenLogo());
		PanelVentanaPrincipal.add(getTitulo());
		PanelVentanaPrincipal.add(getComboArticulos());
		PanelVentanaPrincipal.add(getSpinnerUnidades());
		PanelVentanaPrincipal.add(getTextFieldPrecio());
		PanelVentanaPrincipal.add(getBotonEliminar());
		PanelVentanaPrincipal.add(getScrollPane());
		PanelVentanaPrincipal.add(getToggleBotonPedido());
		PanelVentanaPrincipal.add(getLabelImagenesProductos());
		PanelVentanaPrincipal.add(getPanelFiltro());
		
		inicializar();

	}
	
	
	private JLabel getLabelArticulos() {
		if (labelArticulos == null) {
			labelArticulos = new JLabel("Artículos:");
			labelArticulos.setBounds(31, 126, 61, 16);
		}
		return labelArticulos;
	}
	private JLabel getLabelUnidades() {
		if (labelUnidades == null) {
			labelUnidades = new JLabel("Unidades:");
			labelUnidades.setBounds(460, 126, 72, 16);
		}
		return labelUnidades;
	}
	
	private JLabel getLabelPrecioPedido() {
		if (LabelPrecioPedido == null) {
			LabelPrecioPedido = new JLabel("Precio Pedido:");
			LabelPrecioPedido.setBounds(460, 225, 97, 16);
		}
		return LabelPrecioPedido;
	}
	
	private JButton getBotonAniadirUnidades() {
		if (botonAñadirUnidades == null) {
			botonAñadirUnidades = new JButton("Añadir");
			botonAñadirUnidades.setMnemonic('A');
			botonAñadirUnidades.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					aniadirAPedido();
			}
			});
			botonAñadirUnidades.setBounds(535, 153, 97, 29);
		}
		return botonAñadirUnidades;
	}
	
	private JButton getBotonSiguiente() {
		if (botonSiguiente == null) {
			botonSiguiente = new JButton("Siguiente");
			botonSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionBotonSiguiente();
					
				}
			});
			botonSiguiente.setBounds(449, 319, 97, 29);
		}
		return botonSiguiente;
	}
	
	private JButton getBotonCancelar() {
		if (botonCancelar == null) {
			botonCancelar = new JButton("Cancelar");
			botonCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar();
				}
			});
			botonCancelar.setBounds(558, 319, 97, 29);
		}
		return botonCancelar;
	}
	
	private JButton getBotonEliminar() {
		if (botonEliminar == null) {
			botonEliminar = new JButton("Eliminar");
			botonEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarDelPedido();
				}
			});
			botonEliminar.setBounds(535, 184, 97, 29);
		}
		return botonEliminar;
	}
	
	private JLabel getImagenLogo() {
		if (ImagenLogo == null) {
			ImageIcon original = new ImageIcon("src/img/logo.png");
			Image scaled = original.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			ImagenLogo = new JLabel(new ImageIcon(scaled));
			ImagenLogo.setBounds(24, 6, 140, 92);
		}
		return ImagenLogo;
	}
	
	private JLabel getLabelImagenesProductos() {
		if (labelImagenesProductos == null) {
			labelImagenesProductos = new JLabel("");
			labelImagenesProductos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/HA01.png")));
			labelImagenesProductos.setBounds(99, 193, 198, 155);
		}
		return labelImagenesProductos;
	}
	
	private JLabel getTitulo() {
		if (titulo == null) {
			titulo = new JLabel("Mc Donald´s");
			titulo.setBounds(194, 39, 198, 29);
			titulo.setFont(new Font("Arial Black", Font.BOLD,28));
		}
		return titulo;
	}
	
	
	private JComboBox getComboArticulos() {
		if (comboArticulos == null) {
			//Carta con los articulos
			Carta cartaArticulos = new Carta();
			comboArticulos = new JComboBox(cartaArticulos.getArticulos());
			comboArticulos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actualizarComponentesCombo();
				}
			});
			comboArticulos.setBounds(24, 154, 406, 27);
		}
		return comboArticulos;
	}
	private JSpinner getSpinnerUnidades() {
		if (spinnerUnidades == null) {
			spinnerUnidades = new JSpinner();
			spinnerUnidades.setBounds(459, 154, 53, 29);
		}
		return spinnerUnidades;
	}
	private JTextField getTextFieldPrecio() {
		if (textFieldPrecio == null) {
			textFieldPrecio = new JTextField();
			textFieldPrecio.setEditable(false);
			textFieldPrecio.setBounds(460, 253, 97, 26);
			textFieldPrecio.setColumns(10);
			textFieldPrecio.setFont(new Font("SansSerif", Font.BOLD,16));
		}
		return textFieldPrecio;
	}
	
	//MÉTODOS IMPLEMENTADOS POR MI
	public McDonalds getMc() {
		return mc;
	}
	
	public void inicializar() {
		//Negocio
		mc.inicializarPedido();
		//Interfaz
		getComboArticulos().setSelectedIndex(0);
		getSpinnerUnidades().setValue(1);
		getLabelUnidades().setVisible(false); //o setText("");
		getTextFieldPrecio().setText("");
		getBotonSiguiente().setEnabled(false);
		
	}
	
	private void mostrarUnidadesArticulo() {
		Articulo articuloSeleccionado = (Articulo) getComboArticulos().getSelectedItem();
		getLabelUnidades().setText("Hay" + mc.getUnidadesArticulo(articuloSeleccionado));
	}
	
	/**
	 * Método para el actionPerformed de BotonAniadirUnidades
	 */
	private void aniadirAPedido() {
		Articulo articuloSeleccionado = (Articulo) getComboArticulos().getSelectedItem();
		int unidadesSolicitadas = (int) getSpinnerUnidades().getValue();
		mc.aniadirAPedido(articuloSeleccionado, unidadesSolicitadas);
		String precio = String.format("%.2f", mc.getImportePedido());
		getTextFieldPrecio().setText(precio + "€");
		mostrarUnidadesArticulo();
		if(!getBotonSiguiente().isEnabled()) {
			getBotonSiguiente().setEnabled(true);
		}
		if(!getBotonEliminar().isEnabled()) {
			getBotonEliminar().setEnabled(true);
		}
	}
	
	/**
	 * Método para el actionPerformed de BotonEliminar
	 * Tiene que empezar desactivado y cuando de se completa
	 * la función se desactiva otra vez y desactiva el boton siguiente
	 */
	private void eliminarDelPedido() {
		//Tener claro lo que hace exactamente
		Articulo articuloSeleccionado = (Articulo) getComboArticulos().getSelectedItem();
		int unidadesAEliminar = (int) getSpinnerUnidades().getValue();
		mc.eliminarDePedido(articuloSeleccionado, unidadesAEliminar);
		
		String precio = String.format("%.2f", mc.getImportePedido());
		getTextFieldPrecio().setText(precio + "€");
		
		if(!mc.hayPedido()) {
			getBotonSiguiente().setEnabled(false);
			getTextFieldPrecio().setText("");
		}
		if(!mc.hayUnidadesArticulo(articuloSeleccionado)) {
			getBotonEliminar().setEnabled(false);
		}
	}
	
	/*
	 * Para el actionPerformed del combo
	 */
	private void actualizarComponentesCombo() {
		getSpinnerUnidades().setValue(1);
		if(!mc.hayUnidadesArticulo(getComboArticulos().getSelectedItem())) {
			getBotonEliminar().setEnabled(false);
		}else {
			getBotonEliminar().setEnabled(true);
		}
	}
	
	/**
	 * Método para el actionPerformed de BotonSiguiente
	 */
	private void actionBotonSiguiente() {
		VentanaRegistroJDIALOG dialogo = new VentanaRegistroJDIALOG(this); 
        dialogo.setVisible(true); // modal, bloquea hasta que se cierra
		
	}
	
	
	//HACER EL VERPEDIDO E INOCARLO EN ELIMINAR Y AÑADIR
	private void verPedido() {
		boolean ver = getToggleBotonPedido().isSelected();	
		if(ver) {
			//getTextAreaPedido().setText(mc.getTextoPedido());
		}
	}
	
	/*
	 * Para el actionPerformed del combo sean cambios de imagenes
	 */
	private void cambiarImagenesArticulo() {
		
	}
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(528, 39, 140, 100);
			scrollPane.setViewportView(getTextAreaPedido());
		}
		return scrollPane;
	}
	private JTextArea getTextAreaPedido() {
		if (textAreaPedido == null) {
			textAreaPedido = new JTextArea();
		}
		return textAreaPedido;
	}
	private JToggleButton getToggleBotonPedido() {
		if (ToggleBotonPedido == null) {
			ToggleBotonPedido = new JToggleButton("Pedido");
			ToggleBotonPedido.setBounds(518, 6, 161, 29);
		}
		return ToggleBotonPedido;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setForeground(new Color(255, 255, 255));
			menuBar.add(getMnPedido());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}
	private JMenu getMnPedido() {
		if (mnPedido == null) {
			mnPedido = new JMenu("Pedido");
			mnPedido.setMnemonic('P');
			mnPedido.add(getMnItemNuevo());
			mnPedido.add(getSeparator());
			mnPedido.add(getMntmSalir());
		}
		return mnPedido;
	}
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.setMnemonic('Y');
			mnAyuda.add(getMntmContenidos());
			mnAyuda.add(getSeparator_1());
			mnAyuda.add(getMntmAcercaDe());
		}
		return mnAyuda;
	}
	private JMenuItem getMnItemNuevo() {
		if (mnItemNuevo == null) {
			mnItemNuevo = new JMenuItem("Nuevo");
			mnItemNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
			mnItemNuevo.setMnemonic('N');
		}
		return mnItemNuevo;
	}
	private JMenuItem getMntmSalir() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("Salir");
		}
		return mntmSalir;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getMntmContenidos() {
		if (mntmContenidos == null) {
			mntmContenidos = new JMenuItem("Contenidos");
			mntmContenidos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
			mntmContenidos.setMnemonic('C');
			mntmContenidos.setEnabled(false);
		}
		return mntmContenidos;
	}
	private JMenuItem getMntmAcercaDe() {
		if (mntmAcercaDe == null) {
			mntmAcercaDe = new JMenuItem("Acerca de");
			mntmAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Aplicaion para TPV de comida rápida \n Realizada por Gonzalo \n"
							+ "Practicas CPM 25-26 \n EII Oviedo",
							 "Acerca de", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			mntmAcercaDe.setMnemonic('A');
		}
		return mntmAcercaDe;
	}
	
	/*
	 * Para el actionPerformed de acerca de
	 */
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
	private JPanel getPanelFiltro() {
		if (panelFiltro == null) {
			panelFiltro = new JPanel();
			panelFiltro.setBounds(713, 6, 151, 395);
			panelFiltro.setLayout(new GridLayout(5, 1, 0, 0));
			panelFiltro.add(getBtTodos());
			panelFiltro.add(getBtHamburguesa());
			panelFiltro.add(getBtBebida());
			panelFiltro.add(getBtComplementos());
			panelFiltro.add(getBtPostres());
		}
		return panelFiltro;
	}
	private JButton getBtTodos() {
		if (btTodos == null) {
			btTodos = new JButton("Todos");
			btTodos.setVerticalTextPosition(SwingConstants.BOTTOM);
			btTodos.setHorizontalTextPosition(SwingConstants.CENTER);
			btTodos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Todos.png")));
		}
		return btTodos;
	}
	private JButton getBtPostres() {
		if (btPostres == null) {
			btPostres = new JButton("Postres");
			btPostres.setVerticalTextPosition(SwingConstants.BOTTOM);
			btPostres.setHorizontalTextPosition(SwingConstants.CENTER);
			btPostres.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Postre.png")));
		}
		return btPostres;
	}
	private JButton getBtHamburguesa() {
		if (btHamburguesa == null) {
			btHamburguesa = new JButton("Hamburguesas");
			btHamburguesa.setVerticalTextPosition(SwingConstants.BOTTOM);
			btHamburguesa.setHorizontalTextPosition(SwingConstants.CENTER);
			btHamburguesa.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Hamburguesa.png")));
		}
		return btHamburguesa;
	}
	private JButton getBtBebida() {
		if (btBebida == null) {
			btBebida = new JButton("Bebidas");
			btBebida.setVerticalTextPosition(SwingConstants.BOTTOM);
			btBebida.setHorizontalTextPosition(SwingConstants.CENTER);
			btBebida.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Bebida.png")));
		}
		return btBebida;
	}
	private JButton getBtComplementos() {
		if (btComplementos == null) {
			btComplementos = new JButton("Complementos");
			btComplementos.setVerticalTextPosition(SwingConstants.BOTTOM);
			btComplementos.setHorizontalTextPosition(SwingConstants.CENTER);
			btComplementos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Complemento.png")));
		}
		return btComplementos;
	}
	
	//Ampliación de la 5
	protected void mostrarArticulos(String tipo) {
		getComboArticulos().setModel(new DefaultComboBoxModel<Articulo>(mc.getArticulosCarta()));
		actualizarComponentesCombo();
	}
	class PorcesaBtFiltro implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btFiltro = (JButton)e.getSource();
			mostrarArticulos(btFiltro.getText());
			
		}
		
	}
}
