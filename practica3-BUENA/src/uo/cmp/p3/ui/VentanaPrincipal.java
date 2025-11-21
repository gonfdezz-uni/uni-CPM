package uo.cmp.p3.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uo.cmp.p3.model.Articulo;
import uo.cmp.p3.model.Carta;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("McDonalds´s España");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 397);
		PanelVentanaPrincipal = new JPanel();
		PanelVentanaPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelVentanaPrincipal);
		PanelVentanaPrincipal.setLayout(null);
		PanelVentanaPrincipal.add(getLabelArticulos());
		PanelVentanaPrincipal.add(getLabelUnidades());
		PanelVentanaPrincipal.add(getBotonAñadirUnidades());
		PanelVentanaPrincipal.add(getLabelPrecioPedido());
		PanelVentanaPrincipal.add(getBotonSiguiente());
		PanelVentanaPrincipal.add(getBotonCancelar());
		PanelVentanaPrincipal.add(getImagenLogo());
		PanelVentanaPrincipal.add(getTitulo());
		PanelVentanaPrincipal.add(getComboArticulos());
		PanelVentanaPrincipal.add(getSpinnerUnidades());
		PanelVentanaPrincipal.add(getTextFieldPrecio());

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
	private JButton getBotonAñadirUnidades() {
		if (botonAñadirUnidades == null) {
			botonAñadirUnidades = new JButton("Añadir");
			botonAñadirUnidades.addActionListener(new ActionListener() {
				float suma = 0;
				public void actionPerformed(ActionEvent e) {
					float operation = ((Articulo) getComboArticulos().getSelectedItem()).getPrecio() * 
							(Integer)getSpinnerUnidades().getValue();
					suma += operation;
					textFieldPrecio.setText(String.valueOf(suma));
			}
			});
			botonAñadirUnidades.setBounds(535, 153, 97, 29);
		}
		return botonAñadirUnidades;
	}
	private JLabel getLabelPrecioPedido() {
		if (LabelPrecioPedido == null) {
			LabelPrecioPedido = new JLabel("Precio Pedido:");
			LabelPrecioPedido.setBounds(460, 225, 97, 16);
		}
		return LabelPrecioPedido;
	}
	private JButton getBotonSiguiente() {
		if (botonSiguiente == null) {
			botonSiguiente = new JButton("Siguiente");
			botonSiguiente.addActionListener(e -> {
		        // Abrir el JDialog
		        VentanaRegistroJDIALOG dialogo = new VentanaRegistroJDIALOG(this); // 'this' = JFrame padre
		        dialogo.setVisible(true); // modal, bloquea hasta que se cierra
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
					System.exit(0);
				}
			});
			botonCancelar.setBounds(558, 319, 97, 29);
		}
		return botonCancelar;
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
}
