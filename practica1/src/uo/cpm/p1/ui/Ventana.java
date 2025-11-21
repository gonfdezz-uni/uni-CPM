package uo.cpm.p1.ui;

import java.awt.Color;
import javax.swing.*;

public class Ventana extends JFrame{
	private JPanel panelPrincipal; //Contenedor en el que van a estar mis componentes
	private JButton btAceptar; //Botón
	private JLabel etNombre; //Etiqueta
	private JTextField tfParaNombre; //Campo de texto
	
	
	private static final long serialVersionUID = 1L;

	public Ventana() {
		setBounds(100,100,450,300);
		//Esta línea de código para centrar la ventana tiene que ir siempre después del setBounds
		setLocationRelativeTo(null);
		setTitle("Ventana principal");
		//Creo y edito el panel
		this.panelPrincipal = new JPanel();
		setContentPane(panelPrincipal);
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setLayout(null);
		
		//Creo y edito el botón
		this.btAceptar = new JButton();
		btAceptar.setBounds(170, 220, 100, 30);
		btAceptar.setText("Aceptar");
		
		//Creo y edito la Etiqueta
		this.etNombre = new JLabel();
		etNombre.setBounds(70, 40, 200, 200);
		etNombre.setText("Introduzca su nombre: ");
		
		//Creo y edito el campo de texto
		this.tfParaNombre = new JTextField();
		tfParaNombre.setBounds(100, 100, 100, 30);
		
		//Añado los componentes al panel
		panelPrincipal.add(btAceptar);
		panelPrincipal.add(etNombre);
		panelPrincipal.add(tfParaNombre);
		
	}

	public static void main(String[] args) {
		 Ventana ventana = new Ventana();
		 ventana.setVisible(true); //Hace la ventana visible que por defecto es false
	}

}
