package uo.cpm.p2.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class VentanaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnPrincipal;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
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
	public VentanaRegistro() {
		setTitle("Datos de registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		pnPrincipal = new JPanel();
		pnPrincipal.setBackground(Color.LIGHT_GRAY);
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(null);
		pnPrincipal.add(getBtnNewButton());
		pnPrincipal.add(getBtnNewButton_1());
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
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Siguiente");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(getTextFieldNombreYApellidos().getText().equals("") || getTextFieldPassword().getText() .equals("")|| 
							getTextFieldPasswordX2().getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Hay que escribir algo en los huecos");
					}if(!getTextFieldPasswordX2().getText().equals(getTextFieldPassword().getText())) {
						JOptionPane.showMessageDialog(null, "La contraseña tiene que ser igual");
					}else {
						System.exit(0);
					}
				}
			});
			btnNewButton.setBackground(Color.WHITE);
			btnNewButton.setBounds(322, 224, 128, 29);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Cancelar");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				System.exit(0);
				}
			});
			btnNewButton_1.setBounds(452, 224, 117, 29);
		}
		return btnNewButton_1;
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
        int min = 190;
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
