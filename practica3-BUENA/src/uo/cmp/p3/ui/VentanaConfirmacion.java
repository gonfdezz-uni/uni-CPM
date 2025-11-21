package uo.cmp.p3.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaConfirmacion extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel labelTextoFinal;
	private JTextField textFieldCodigoFinal;
	private JLabel labelCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaConfirmacion dialog = new VentanaConfirmacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaConfirmacion() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			ImageIcon original = new ImageIcon("src/img/ok.png");
			Image scaled = original.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
			JLabel labelTICfoto = new JLabel(new ImageIcon(scaled));
			labelTICfoto.setBounds(-3, 6, 140, 126);
			contentPanel.add(labelTICfoto);
		}
		contentPanel.add(getLabelTextoFinal());
		contentPanel.add(getTextFieldCodigoFinal());
		contentPanel.add(getLabelCodigo());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Finalizar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	public VentanaConfirmacion(JDialog dialog) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			ImageIcon original = new ImageIcon("src/img/ok.png");
			Image scaled = original.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
			JLabel labelTICfoto = new JLabel(new ImageIcon(scaled));
			labelTICfoto.setBounds(-3, 6, 140, 126);
			contentPanel.add(labelTICfoto);
		}
		contentPanel.add(getLabelTextoFinal());
		contentPanel.add(getTextFieldCodigoFinal());
		contentPanel.add(getLabelCodigo());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Finalizar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	public VentanaConfirmacion(JFrame parent) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			ImageIcon original = new ImageIcon("src/img/ok.png");
			Image scaled = original.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			JLabel labelTICfoto = new JLabel(new ImageIcon(scaled));
			labelTICfoto.setBounds(28, 31, 61, 16);
			contentPanel.add(labelTICfoto);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Finalizar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	private JLabel getLabelTextoFinal() {
		if (labelTextoFinal == null) {
			labelTextoFinal = new JLabel("Pulse Finalizar para confirmar su pedido");
			labelTextoFinal.setBounds(149, 58, 278, 16);
		}
		return labelTextoFinal;
	}
	private JTextField getTextFieldCodigoFinal() {
		if (textFieldCodigoFinal == null) {
			textFieldCodigoFinal = new JTextField();
			textFieldCodigoFinal.setText("OJ8Y76");
			textFieldCodigoFinal.setFocusable(false);
			textFieldCodigoFinal.setBounds(193, 151, 62, 26);
			textFieldCodigoFinal.setColumns(10);
		}
		return textFieldCodigoFinal;
	}
	private JLabel getLabelCodigo() {
		if (labelCodigo == null) {
			labelCodigo = new JLabel("Su código de recogida es:");
			labelCodigo.setBounds(149, 124, 172, 16);
		}
		return labelCodigo;
	}
	
	//Hacer el método de finalizar()
	/*
	 * privaet JLabel getblPrecioEs(){
	 * if(lblPrecioEs ==null){
	 * Completarlo
	 */
}
