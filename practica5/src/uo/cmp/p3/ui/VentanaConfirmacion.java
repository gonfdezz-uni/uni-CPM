package uo.cmp.p3.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaConfirmacion extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel labelTextoFinal;
	private JTextField textFieldCodigoFinal;
	private JLabel labelCodigo;
	
	private VentanaRegistroJDIALOG Vr;
	private JLabel LabelPrecioFinal;



	/**
	 * Create the dialog.
	 * @wbp.parser.constructor
	 */
	public VentanaConfirmacion(VentanaRegistroJDIALOG vr) {
		
		this.Vr = vr;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			ImageIcon original = new ImageIcon("src/img/ok.png");
			Image scaled = original.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
			JLabel labelTICfoto = new JLabel(new ImageIcon(scaled));
			labelTICfoto.setBounds(-18, 6, 140, 126);
			contentPanel.add(labelTICfoto);
		}
		contentPanel.add(getLabelTextoFinal());
		contentPanel.add(getTextFieldCodigoFinal());
		contentPanel.add(getLabelCodigo());
		contentPanel.add(getLabelPrecioFinal());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton BotonFinalizar = new JButton("Finalizar");
				BotonFinalizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						finalizar();
					}
				});
				BotonFinalizar.setActionCommand("OK");
				buttonPane.add(BotonFinalizar);
				getRootPane().setDefaultButton(BotonFinalizar);
			}
		}
	}
	
	private JLabel getLabelTextoFinal() {
		if (labelTextoFinal == null) {
			labelTextoFinal = new JLabel("Pulse Finalizar para confirmar su pedido");
			labelTextoFinal.setFont(new Font("Arial", Font.PLAIN, 16));
			labelTextoFinal.setBounds(126, 58, 404, 16);
		}
		return labelTextoFinal;
	}
	private JTextField getTextFieldCodigoFinal() {
		if (textFieldCodigoFinal == null) {
			textFieldCodigoFinal = new JTextField();
			textFieldCodigoFinal.setText(Vr.getVp().getMc().getPedido().generarCodigo()); //llamar al generarCódigo
			textFieldCodigoFinal.setFocusable(false);
			textFieldCodigoFinal.setBounds(193, 151, 79, 26);
			textFieldCodigoFinal.setColumns(10);
		}
		return textFieldCodigoFinal;
	}
	private JLabel getLabelCodigo() {
		if (labelCodigo == null) {
			labelCodigo = new JLabel("Su código de recogida es:");
			labelCodigo.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCodigo.setBounds(149, 124, 237, 16);
		}
		return labelCodigo;
	}
	
	//finalizar()
	/*
	 * -Graba pedido
	 * -Notifica usuario
	 * -Cerrar vc
	 * -Cerrar vr
	 * -Inicializa vp
	 */
	
	private void finalizar() {
		Vr.getVp().getMc().grabarPedido();
		JOptionPane.showMessageDialog(null, "Muchas gracias por tu pedido. \nRecógelo en el mostrador con el código");
		Vr.getVp().inicializar();
		Vr.dispose();
		dispose();
	}
	private JLabel getLabelPrecioFinal() {
		if (LabelPrecioFinal == null) {
			String precio = String.format("%.2f", Vr.getVp().getMc().getImportePedido());
			LabelPrecioFinal = new JLabel("El precio de su pedido es " + precio + "€");
			LabelPrecioFinal.setFont(new Font("Arial", Font.PLAIN, 16));
			LabelPrecioFinal.setBounds(149, 190, 254, 16);
		}
		return LabelPrecioFinal;
	}
}
