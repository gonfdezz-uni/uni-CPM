package uo.cpm.p8.iu;

import java.awt.EventQueue;
import javax.help.*;
import java.net.*;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import uo.cpm.p8.player.MusicPlayer;

import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.ChangeEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnNorte;
	private JSlider volumenSlider;
	private JLabel lblLogo;
	private JPanel pnVolumen;
	private JLabel lblVolNumero;
	private JLabel lblVol;
	private JPanel pnMedio;
	private JPanel panelLibreria;
	private JPanel panelBotonesLibreria;
	private JButton btnAddToPlaylist;
	private JButton btnDel;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JList<File> listCancionesLibreria;
	private JPanel panelPlayList;
	private JLabel lblPlayList;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnPlay;
	private JButton btnAnterior;
	private JButton btnNewButton_3;
	private JScrollPane scrollPane_1;
	private JList<File> listCancionesPlayList;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_2;
	private JSeparator separator;
	private JMenu mnNewMenu_2;

	private DefaultListModel<File> modeloListLibrary;
	private DefaultListModel<File> modeloListPlay;

	private JFileChooser selector;
	private MusicPlayer mp;
	private JButton Del;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JMenuItem btnContents;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(MusicPlayer mp) {

		this.mp = mp;
		
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 458);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnNorte(), BorderLayout.NORTH);
		contentPane.add(getPnMedio(), BorderLayout.CENTER);
		this.setMinimumSize(new Dimension(550, 225));
		setTitle("EII Music Player");
		cargaAyuda();

	}

	public MusicPlayer getMp() {
		return this.mp;
	}

	private JPanel getPnNorte() {
		if (pnNorte == null) {
			pnNorte = new JPanel();
			pnNorte.setBackground(new Color(0, 0, 0));
			pnNorte.setLayout(new GridLayout(0, 3, 0, 0));
			pnNorte.add(getLblLogo());
			pnNorte.add(getVolumenSlider());
			pnNorte.add(getPnVolumen());
		}
		return pnNorte;
	}

	private JSlider getVolumenSlider() {
		if (volumenSlider == null) {
			volumenSlider = new JSlider();
			volumenSlider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					pintaYCambiaVol();
				}
			});
			volumenSlider.setPaintTicks(true);
			volumenSlider.setPaintLabels(true);
			volumenSlider.setMinorTickSpacing(5);
			volumenSlider.setMajorTickSpacing(20);
			volumenSlider.setBackground(new Color(0, 0, 0));
			volumenSlider.setForeground(new Color(255, 255, 255));
		}
		return volumenSlider;
	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
		}
		return lblLogo;
	}

	private JPanel getPnVolumen() {
		if (pnVolumen == null) {
			pnVolumen = new JPanel();
			pnVolumen.setForeground(new Color(255, 255, 255));
			pnVolumen.setBackground(new Color(0, 0, 0));
			pnVolumen.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnVolumen.add(getLblVol());
			pnVolumen.add(getLblVolNumero());
		}
		return pnVolumen;
	}

	private JLabel getLblVolNumero() {
		if (lblVolNumero == null) {
			lblVolNumero = new JLabel("0");
			lblVolNumero.setForeground(new Color(255, 255, 255));
			lblVolNumero.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		}
		return lblVolNumero;
	}

	private JLabel getLblVol() {
		if (lblVol == null) {
			lblVol = new JLabel("Vol:");
			lblVol.setForeground(new Color(255, 255, 255));
			lblVol.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		}
		return lblVol;
	}

	private void pintaYCambiaVol() {
		mp.setVolume(getVolumenSlider().getValue());
		getLblVolNumero().setText(String.valueOf(getVolumenSlider().getValue()));
	}

	private JPanel getPnMedio() {
		if (pnMedio == null) {
			pnMedio = new JPanel();
			pnMedio.setBackground(new Color(0, 0, 0));
			pnMedio.setLayout(new GridLayout(0, 2, 0, 0));
			pnMedio.add(getPanelLibreria());
			pnMedio.add(getPanelPlayList());
		}
		return pnMedio;
	}

	private JPanel getPanelLibreria() {
		if (panelLibreria == null) {
			panelLibreria = new JPanel();
			panelLibreria.setBackground(new Color(0, 0, 0));
			panelLibreria.setLayout(new BorderLayout(0, 0));
			panelLibreria.add(getPanelBotonesLibreria(), BorderLayout.SOUTH);
			panelLibreria.add(getLblNewLabel(), BorderLayout.NORTH);
			panelLibreria.add(getScrollPane(), BorderLayout.CENTER);
		}
		return panelLibreria;
	}

	private JPanel getPanelBotonesLibreria() {
		if (panelBotonesLibreria == null) {
			panelBotonesLibreria = new JPanel();
			panelBotonesLibreria.setBackground(new Color(255, 255, 255));
			panelBotonesLibreria.setLayout(new GridLayout(0, 3, 0, 0));
			panelBotonesLibreria.add(getBtnAddToPlaylist());
			panelBotonesLibreria.add(getBtnDel());
			panelBotonesLibreria.add(getBtnNewButton_2());
		}
		return panelBotonesLibreria;
	}

	private JButton getBtnAddToPlaylist() {
		if (btnAddToPlaylist == null) {
			btnAddToPlaylist = new JButton("Add to PlayList");
			btnAddToPlaylist.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addToPlayList();
				}
			});
			btnAddToPlaylist.setBackground(new Color(0, 0, 0));
		}
		return btnAddToPlaylist;
	}

	protected void addToPlayList() {
		mp.addListPlay(getListCancionesLibreria().getSelectedValuesList());
		modeloListPlay.removeAllElements();
		modeloListPlay.addAll(mp.getListPlay());
		getListCancionesPlayList().setSelectedValue(mp.getCurrentSong(), true);
		getListCancionesPlayList().requestFocus();
	}

	private JButton getBtnDel() {
		if (btnDel == null) {
			btnDel = new JButton("Del");
			btnDel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					borrarDeListLibrary();
				}
			});
		}
		return btnDel;
	}

	protected void borrarDeListLibrary() {
		mp.deleteListLibrary(getListCancionesLibreria().getSelectedValuesList());
		modeloListLibrary.removeAllElements();
		modeloListLibrary.addAll(mp.getListLibrary());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Library");
			lblNewLabel.setForeground(new Color(229, 137, 255));
		}
		return lblNewLabel;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBorder(new LineBorder(new Color(158, 249, 225), 5));
			scrollPane.setViewportView(getListCancionesLibreria());
		}
		return scrollPane;
	}

	private JList getListCancionesLibreria() {
		if (listCancionesLibreria == null) {
			modeloListLibrary = new DefaultListModel<File>();
			listCancionesLibreria = new JList<File>(modeloListLibrary);
			listCancionesLibreria.setBackground(new Color(0, 0, 0));
		}
		return listCancionesLibreria;
	}

	private JPanel getPanelPlayList() {
		if (panelPlayList == null) {
			panelPlayList = new JPanel();
			panelPlayList.setBackground(new Color(0, 0, 0));
			panelPlayList.setLayout(new BorderLayout(0, 0));
			panelPlayList.add(getLblPlayList(), BorderLayout.NORTH);
			panelPlayList.add(getPanel(), BorderLayout.SOUTH);
			panelPlayList.add(getScrollPane_1(), BorderLayout.CENTER);
		}
		return panelPlayList;
	}

	private JLabel getLblPlayList() {
		if (lblPlayList == null) {
			lblPlayList = new JLabel("PlayList");
			lblPlayList.setForeground(new Color(238, 160, 254));
		}
		return lblPlayList;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(0, 6, 0, 0));
			panel.add(getButton_3());
			panel.add(getButton_2());
			panel.add(getButton_1());
			panel.add(getButton_4());
			panel.add(getDel());
			panel.add(getBtnNewButton_1());
		}
		return panel;
	}

	private JButton getButton_1() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Pause");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mp.stop();
				}
			});
		}
		return btnNewButton;
	}

	private JButton getButton_2() {
		if (btnPlay == null) {
			btnPlay = new JButton("Play");
			btnPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mp.play();
				}
			});
		}
		return btnPlay;
	}

	private JButton getButton_3() {
		if (btnAnterior == null) {
			btnAnterior = new JButton("Prev");
			btnAnterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rewind();
				}
			});
		}
		return btnAnterior;
	}

	protected void rewind() {

	}

	private JButton getButton_4() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("Post");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					forward();
				}
			});
		}
		return btnNewButton_3;
	}

	protected void forward() {
		mp.forward();
		getListCancionesPlayList().setSelectedValue(mp.getCurrentSong(), true);
		getListCancionesPlayList().requestFocus();
	}

	private void getMinimoVentana() {
		System.out.println();
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBorder(new LineBorder(new Color(73, 255, 199), 5));
			scrollPane_1.setViewportView(getListCancionesPlayList());
		}
		return scrollPane_1;
	}

	private JList getListCancionesPlayList() {
		if (listCancionesPlayList == null) {
			modeloListPlay = new DefaultListModel<File>();
			listCancionesPlayList = new JList<File>(modeloListPlay);
			listCancionesPlayList.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					mp.setCurrentSong((File) getListCancionesPlayList().getSelectedValue());
				}
			});
			listCancionesPlayList.setBackground(new Color(0, 0, 0));
		}
		return listCancionesPlayList;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setForeground(new Color(255, 255, 255));
			menuBar.setBackground(new Color(0, 0, 0));
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_1());
			menuBar.add(getMnNewMenu_2());
		}
		return menuBar;
	}

	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("Music");
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getSeparator());
			mnNewMenu.add(getMntmNewMenuItem_1());
		}
		return mnNewMenu;
	}

	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("Open");
			mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_DOWN_MASK));
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarMusica();
				}
			});
			mntmNewMenuItem.setMnemonic('O');
		}
		return mntmNewMenuItem;
	}

	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("Exit");
		}
		return mntmNewMenuItem_1;
	}

	private JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("Options");
			mnNewMenu_1.add(getMntmNewMenuItem_2());
		}
		return mnNewMenu_1;
	}

	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("???");
		}
		return mntmNewMenuItem_2;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}

	private JMenu getMnNewMenu_2() {
		if (mnNewMenu_2 == null) {
			mnNewMenu_2 = new JMenu("Help");
			mnNewMenu_2.add(getBtnContents());
		}
		return mnNewMenu_2;
	}

	public JFileChooser getSelector() {
		if (selector == null) {
			selector = new JFileChooser();
			selector.setMultiSelectionEnabled(true);
			// Poner filtro
			selector.setFileFilter(new FileNameExtensionFilter("Archivos mp3", "mp3"));

			// Cambiar directorio inicial a la carperta musica
			String curDir = System.getProperty("user.home") + "/Desktop/Musica";
			selector.setCurrentDirectory(new File(curDir));
		}
		return selector;
	}

	private void cargarMusica() {
		int resp = getSelector().showOpenDialog(null);
		if (resp == JFileChooser.APPROVE_OPTION) {
			mp.addListLibrary(selector.getSelectedFiles());
			modeloListLibrary.removeAllElements();
			modeloListLibrary.addAll(mp.getListLibrary());
		}
	}

	private void borrarDePlayList() {
		// Mejorar este método para cuando elimino una que está sonando
		mp.deleteListPlay((File) getListCancionesPlayList().getSelectedValue());
		modeloListPlay.removeElement(getListCancionesPlayList().getSelectedValue());
	}

	private JButton getDel() {
		if (Del == null) {
			Del = new JButton("Del");
			Del.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					borrarDePlayList();
				}
			});
		}
		return Del;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Clear");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clearForPlayList();
				}
			});
		}
		return btnNewButton_1;
	}

	protected void clearForPlayList() {
		mp.clearListPlay();
		modeloListPlay.removeAllElements();
	}

	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("Clear");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clearForLibrary();
				}
			});
		}
		return btnNewButton_2;
	}

	protected void clearForLibrary() {
		mp.clearListLibrary();
		modeloListLibrary.removeAllElements();
	}
	
	private void cargaAyuda(){

		   URL hsURL;
		   HelpSet hs;

		    try {
			    	File fichero = new File("help/ayuda.hs");
			    	hsURL = fichero.toURI().toURL();
			        hs = new HelpSet(null, hsURL);
			      }

		    catch (Exception e){
		      System.out.println("Ayuda no encontrada");
		      return;
		   }

		   HelpBroker hb = hs.createHelpBroker();
		   hb.initPresentation();

		   hb.enableHelpKey(getRootPane(),"intro", hs);
		   hb.enableHelpOnButton(getBtnContents(), "intro", hs);
		   hb.enableHelp(getListCancionesLibreria(), "add", hs);
		   hb.enableHelp(getBtnDel(), "delete", hs);
		   hb.enableHelp(getListCancionesPlayList(), "play", hs);
		  //hb.enableHelpOnButton(componente, "alias html introduccion", hs);
		  //hb.enableHelp(componente, "alias html concreto", hs);
		 }
	//Nota: si se hacen cambios en los html y demás hay que volver a crear la base de ayuda por consola
	//No hay que programar el actionPerformed, es el único caso en el que no hay que hacerlo
	/*
	 * Para generar la base de datos de búsqueda hay que ejecutar desde comandos en la help el jhindexer con
	 * la orden de java
	 */
	private JMenuItem getBtnContents() {
		if (btnContents == null) {
			btnContents = new JMenuItem("Contents");
		}
		return btnContents;
	}
}
