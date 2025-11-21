package uo.cmp.p3;

import java.awt.EventQueue;

import javax.swing.UIManager;

import uo.cmp.p3.service.McDonalds;
import uo.cmp.p3.ui.VentanaPrincipal;

public class Main {

	
	private static McDonalds mc = new McDonalds();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					VentanaPrincipal frame = new VentanaPrincipal(mc);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
