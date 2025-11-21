package uo.cpm.p6.ui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

import uo.cpm.p6.model.Nivel;
import uo.cpm.p6.service.SpaceInvaders;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnDado;
	private JLabel lblNave;
	private JLabel lblPuntos;
	private JLabel lblTierra;
	private JLabel lblPuntosEnNumero;
	private JPanel panelDisparos;
	private JPanel panelTablero;

	private SpaceInvaders spaceInvaders;
	private JLabel lblDisparo;
	private JMenuBar menuBar;
	
	private ProcesarBotonTablero pBT = new ProcesarBotonTablero();

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(SpaceInvaders sp) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				confirmarSalir();
			}
		});

		this.spaceInvaders = sp;

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 980, 400);
		setLocationRelativeTo(null);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnDado());
		contentPane.add(getLblNave());
		contentPane.add(getLblPuntos());
		contentPane.add(getLblTierra());
		contentPane.add(getLblPuntosEnNumero());
		contentPane.add(getPanelDisparos());
		contentPane.add(getPanelTablero());
		this.setResizable(false);
		
		//Aqui iria el get del radioButton elegido
		redimensionarTablero(null);
	}

	private JButton getBtnDado() {
		if (btnDado == null) {
			btnDado = new JButton("New button");
			btnDado.setToolTipText("Click para destapar casilla");
			btnDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					iniciarSpaceInvaders();
				}
			});
			btnDado.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dice.jpg")));
			btnDado.setBackground(new Color(0, 0, 0));
			btnDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dice.jpg")));
			btnDado.setBounds(37, 33, 104, 117);
		}
		return btnDado;
	}

	private JLabel getLblNave() {
		if (lblNave == null) {
			lblNave = new JLabel("New label");
			lblNave.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/spaceship.png")));
			lblNave.setBounds(288, 37, 141, 81);
		}
		return lblNave;
	}

	private JLabel getLblPuntos() {
		if (lblPuntos == null) {
			lblPuntos = new JLabel("Puntos");
			lblPuntos.setForeground(new Color(255, 255, 255));
			lblPuntos.setBounds(603, 58, 49, 16);
		}
		return lblPuntos;
	}

	private JLabel getLblTierra() {
		if (lblTierra == null) {
			lblTierra = new JLabel("New label");
			lblTierra.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/earth.jpg")));
			lblTierra.setBounds(741, 25, 211, 164);
		}
		return lblTierra;
	}

	private JLabel getLblPuntosEnNumero() {
		if (lblPuntosEnNumero == null) {
			lblPuntosEnNumero = new JLabel("0");
			lblPuntosEnNumero.setForeground(new Color(255, 255, 255));
			lblPuntosEnNumero.setBounds(613, 86, 61, 16);
			lblPuntosEnNumero.setText("1000");
		}
		return lblPuntosEnNumero;
	}

	private JPanel getPanelDisparos() {
		if (panelDisparos == null) {
			panelDisparos = new JPanel();
			panelDisparos.setForeground(Color.BLACK);
			panelDisparos.setBackground(new Color(0, 0, 0));
			panelDisparos.setBounds(199, 159, 352, 86);
			panelDisparos.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		}
		return panelDisparos;
	}

	private JPanel getPanelTablero() {
		if (panelTablero == null) {
			panelTablero = new JPanel();
			panelTablero.setBorder(new LineBorder(new Color(0, 0, 0), 5));
			panelTablero.setBackground(new Color(65, 67, 164));
			panelTablero.setBounds(38, 256, 915, 95);
			panelTablero.setLayout(new GridLayout(0, 8, 4, 0));

			habilitarTablero(false);
		}
		return panelTablero;
	}

	private void habilitarTablero(boolean estado) {
		for (int i = 0; i < getPanelTablero().getComponents().length; i++) {
			getPanelTablero().getComponents()[i].setEnabled(estado);
		}
	}

	public SpaceInvaders getSpaceInvader() {
		return spaceInvaders;
	}

	private void iniciarSpaceInvaders() {
		spaceInvaders.lanzarDado();
		pintaDisparos();
		habilitarTablero(true);
		getBtnDado().setEnabled(false);
	}

	private void pintaDisparos() {
		for (int i = 0; i < spaceInvaders.getDisparos(); i++) {
			getPanelDisparos().add(nuevoDisparo());
		}
		validate(); // repinta el panel en tiempo de ejcucion para que se vean los disprtaros
					// añadidos
	}

	public JLabel nuevoDisparo() {
		lblDisparo = new JLabel("");
		lblDisparo.setBorder(new LineBorder(Color.GREEN));
		lblDisparo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/shoot.png")));
		return lblDisparo;
	}

	private void dispara(int i) {
		spaceInvaders.dipara(i);
		representaSpaceInvaders(i);
	}

	private void representaSpaceInvaders(int i) {
		pintaPuntos();
		despintaDisparo();
		pintaCasilla(i);
		compruebaFin();
		deshabilitacionBoton(i);
	}
	
	private void pintaPuntos() {
		getLblPuntosEnNumero().setText(String.valueOf(spaceInvaders.getPuntuacion()));
	}

	private void despintaDisparo() {
		getPanelDisparos().remove(0);
		getPanelDisparos().repaint(); //para eliminar en tiempo de ejecución
	}

	private void pintaCasilla(int i) {
		ImageIcon imagen = new ImageIcon(VentanaPrincipal.class.getResource(spaceInvaders.obtenerImagen(i)));
		((JButton) getPanelTablero().getComponent(i)).setIcon(imagen);
		((JButton) getPanelTablero().getComponent(i)).setDisabledIcon(imagen);
	}

	private void compruebaFin() {
		if(spaceInvaders.isFinJuego()) {
			habilitarTablero(false);
			descubreTablero();
			JOptionPane.showMessageDialog(this, spaceInvaders.getMotivoFin(), "Invasion espacial", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private void descubreTablero() {
		for(int i = 0; i<getPanelTablero().getComponentCount(); i++) {
			pintaCasilla(i);
		}
	}
	private void deshabilitacionBoton(int i) {
		((JButton) getPanelTablero().getComponent(i)).setEnabled(false);
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
		}
		return menuBar;
	}
	//Para el boton del menu nuevo juego
	private void inicializar() {
		spaceInvaders.inicializar();
		getBtnDado().setEnabled(true);
		eliminaDisparos();
		pintaPuntos();
		despintaTablero();
		habilitarTablero(false);
	}

	private void eliminaDisparos() {
		// TODO Auto-generated method stub
		
	}

	private void despintaTablero() {
		for(int i = 0; i<getPanelTablero().getComponentCount();i++) {
			((JButton) getPanelTablero().getComponents()[i]).setIcon(null);
			((JButton) getPanelTablero().getComponents()[i]).setDisabledIcon(null);
		}
	}
	
	
	//Para la opcion de salir del menu y para la x de la ventana
	private void confirmarSalir() {
		if(JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres salir de la app?") == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	private void aniadirBotones() {
		for(int i = 0;i<spaceInvaders.getDimension();i++) {
			getPanelTablero().add(nuevoBoton(i));
			validate();
		}
	}
	
	private JButton nuevoBoton(int i) {
		JButton bt = new JButton("");
		bt.setActionCommand(String.valueOf(i));
		bt.setBackground(Color.BLACK);
		bt.setToolTipText("Click para destapar casilla");
		bt.addActionListener(pBT);
		return bt;
	}
	
	private void redimensionarTablero(Nivel nivel) {
		int ancho = 0;
		int x = 0;
		switch (nivel) {
		case FACIL: {
			x = 20;
			ancho = 1010;
			break;
			}
		case INTERMEDIO: {
			x = 120;
			ancho = 815;
			break;
			}
		case DIFICIL: {
			x = 190;
			ancho = 610;
			break;
			}
		}
		getPanelTablero().setBounds(x, 210, ancho, 105);
		getPanelTablero().setLayout(new GridLayout(1, spaceInvaders.getDimension(), 4, 0)); //filas, columnas, hgap, vgap
		getPanelTablero().removeAll();
		// Se añaden los botones al tablero
		aniadirBotones();
	}
	
	
	public class ProcesarBotonTablero implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int posicion = Integer.parseInt(e.getActionCommand());
			dispara(posicion);
			
		}
		
	}
}
