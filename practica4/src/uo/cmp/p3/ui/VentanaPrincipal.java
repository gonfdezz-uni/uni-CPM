package uo.cmp.p3.ui;

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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	
	
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(McDonalds mc) {
		
		this.mc = mc;
		
		setTitle("McDonalds´s España");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 397);
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
			botonCancelar.setMnemonic('C');
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
			comboArticulos.setToolTipText("hola\n");
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
	}
	
	/**
	 * Método para el actionPerformed de BotonEliminar
	 */
	private void eliminarDelPedido() {
		//Tener claro lo que hace exactamente
	}
	
	/**
	 * Método para el actionPerformed de BotonSiguiente
	 */
	private void actionBotonSiguiente() {
		VentanaRegistroJDIALOG dialogo = new VentanaRegistroJDIALOG(this); 
        dialogo.setVisible(true); // modal, bloquea hasta que se cierra
		
	}
	
	//LO DEL TEXTO EN ROJO
}
