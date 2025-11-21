package uo.cmp.p3.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import uo.cmp.p3.service.McDonalds;

public class VentanaRegistroJDIALOG extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel pnPrincipal;
	private JLabel NombreYApellidos;
	private JLabel FechaDeNacimiento;
	private JLabel Password;
	private JLabel PasswordX2;
	private JTextField textFieldNombreYApellidos;
	private JTextField textFieldPassword;
	private JTextField textFieldPasswordX2;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JPanel panelCliente;
	private JPanel panel;
	private JComboBox comboBox;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaRegistroJDIALOG dialog = new VentanaRegistroJDIALOG();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaRegistroJDIALOG() {
		pnPrincipal = new JPanel();
		setTitle("Datos de registro");
		setBounds(100, 100, 605, 356);
		getContentPane().setLayout(new BorderLayout());
		pnPrincipal.setLayout(new FlowLayout());
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnPrincipal, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton BotonSiguiente = new JButton("Siguiente");
				BotonSiguiente.addActionListener(new ActionListener() {
//El comportamiento conviene aislarlo en métodos (actualizarDatosPedido()-> Podría estar en el actionPerformed de los radioBotones y comprobarDatosPedidos())					
					public void actionPerformed(ActionEvent e) {
						if(getTextFieldNombreYApellidos().getText().equals("") || getTextFieldPassword().getText() .equals("")|| 
								getTextFieldPasswordX2().getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Hay que escribir algo en los huecos");
						}if(!getTextFieldPasswordX2().getText().equals(getTextFieldPassword().getText())) {
							JOptionPane.showMessageDialog(null, "La contraseña tiene que ser igual");
						}else {
							openConfirmation();
						}
					}
				});
				//BotonSiguiente.setActionCommand("OK");
				buttonPane.add(BotonSiguiente);
				getRootPane().setDefaultButton(BotonSiguiente);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		pnPrincipal.setBackground(Color.LIGHT_GRAY);
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnPrincipal.setLayout(null);
		pnPrincipal.add(getNombreYApellidos());
		pnPrincipal.add(getFechaDeNacimiento());
		pnPrincipal.add(getPassword());
		pnPrincipal.add(getPasswordX2());
		pnPrincipal.add(getTextFieldNombreYApellidos());
		pnPrincipal.add(getTextFieldPassword());
		pnPrincipal.add(getTextFieldPasswordX2());
		pnPrincipal.add(getRdbtnNewRadioButton());
		pnPrincipal.add(getRdbtnNewRadioButton_1());
		pnPrincipal.add(getPanelCliente());
		pnPrincipal.add(getPanel());
		pnPrincipal.add(getComboBox());
	}
	
	private void openConfirmation() {
		// Abrir el JDialog
        VentanaConfirmacion dialogo = new VentanaConfirmacion(this); // 'this' = JDialog padre
        dialogo.setVisible(true); // modal, bloquea hasta que se cierra
	}
	
	public VentanaRegistroJDIALOG(JFrame parent) {
		pnPrincipal = new JPanel();
		setTitle("Datos de registro");
		setBounds(100, 100, 605, 407);
		getContentPane().setLayout(new BorderLayout());
		pnPrincipal.setLayout(new FlowLayout());
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnPrincipal, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton BotonSiguiente1 = new JButton("Siguiente");
				BotonSiguiente1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(getTextFieldNombreYApellidos().getText().equals("") || getTextFieldPassword().getText() .equals("")|| 
								getTextFieldPasswordX2().getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Hay que escribir algo en los huecos");
						}if(!getTextFieldPasswordX2().getText().equals(getTextFieldPassword().getText())) {
							JOptionPane.showMessageDialog(null, "La contraseña tiene que ser igual");
						}else {
							VentanaConfirmacion dialogo2 = new VentanaConfirmacion(parent);
							dialogo2.setVisible(true);
						}
					}
				});
				BotonSiguiente1.setActionCommand("OK");
				buttonPane.add(BotonSiguiente1);
				getRootPane().setDefaultButton(BotonSiguiente1);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		pnPrincipal.setBackground(Color.LIGHT_GRAY);
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnPrincipal.setLayout(null);
		pnPrincipal.add(getNombreYApellidos());
		pnPrincipal.add(getFechaDeNacimiento());
		pnPrincipal.add(getPassword());
		pnPrincipal.add(getPasswordX2());
		pnPrincipal.add(getTextFieldNombreYApellidos());
		pnPrincipal.add(getTextFieldPassword());
		pnPrincipal.add(getTextFieldPasswordX2());
		pnPrincipal.add(getRdbtnNewRadioButton());
		pnPrincipal.add(getRdbtnNewRadioButton_1());
		pnPrincipal.add(getPanelCliente());
		pnPrincipal.add(getPanel());
		pnPrincipal.add(getComboBox());
	}
	
	private JLabel getNombreYApellidos() {
		if (NombreYApellidos == null) {
			NombreYApellidos = new JLabel("Nombre y Apellidos:");
			NombreYApellidos.setBounds(23, 31, 150, 16);
		}
		return NombreYApellidos;
	}
	private JLabel getFechaDeNacimiento() {
		if (FechaDeNacimiento == null) {
			FechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
			FechaDeNacimiento.setBounds(23, 69, 150, 16);
		}
		return FechaDeNacimiento;
	}
	private JLabel getPassword() {
		if (Password == null) {
			Password = new JLabel("Password:");
			Password.setBounds(23, 107, 80, 16);
		}
		return Password;
	}
	private JLabel getPasswordX2() {
		if (PasswordX2 == null) {
			PasswordX2 = new JLabel("Reintroduzca password:");
			PasswordX2.setBounds(23, 147, 170, 16);
		}
		return PasswordX2;
	}
	private JTextField getTextFieldNombreYApellidos() {
		if (textFieldNombreYApellidos == null) {
			textFieldNombreYApellidos = new JTextField();
			textFieldNombreYApellidos.setBounds(251, 26, 260, 26);
			textFieldNombreYApellidos.setColumns(10);
		}
		return textFieldNombreYApellidos;
	}
	private JTextField getTextFieldPassword() {
		if (textFieldPassword == null) {
			textFieldPassword = new JTextField();
			textFieldPassword.setBounds(251, 97, 180, 26);
			textFieldPassword.setColumns(10);
		}
		return textFieldPassword;
	}
	private JTextField getTextFieldPasswordX2() {
		if (textFieldPasswordX2 == null) {
			textFieldPasswordX2 = new JTextField();
			textFieldPasswordX2.setColumns(10);
			textFieldPasswordX2.setBounds(251, 142, 180, 26);
		}
		return textFieldPasswordX2;
	}
	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("Local");
			rdbtnNewRadioButton.setBounds(23, 225, 80, 23);
		}
		return rdbtnNewRadioButton;
	}
	private JRadioButton getRdbtnNewRadioButton_1() {
		if (rdbtnNewRadioButton_1 == null) {
			rdbtnNewRadioButton_1 = new JRadioButton("Llevar");
			rdbtnNewRadioButton_1.setBounds(115, 225, 80, 23);
		}
		return rdbtnNewRadioButton_1;
	}
	private JPanel getPanelCliente() {
		if (panelCliente == null) {
			panelCliente = new JPanel();
			panelCliente.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelCliente.setToolTipText("");
			panelCliente.setBounds(6, 9, 539, 183);
		}
		return panelCliente;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Pedido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(6, 207, 210, 59);
		}
		return panel;
	}
	private JComboBox getComboBox() {
		
		// Definir el rango
        int min = 1960;
        int max = 2007;

        // Crear un array con los años válidos
        Integer[] years = new Integer[max - min + 1];
        for (int i = 0; i <= max - min; i++) {
            years[i] = min + i;
        }
		if (comboBox == null) {
			comboBox = new JComboBox(years);
			comboBox.setBounds(237, 225, 73, 27);
		}
		return comboBox;
	}

	
	
	
	
}


