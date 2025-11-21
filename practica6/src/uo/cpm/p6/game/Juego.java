package uo.cpm.p6.game;

import uo.cpm.p6.model.*;
import uo.cpm.p6.model.Casilla.TipoCasilla;

public class Juego {

	public static final int MAX_DISPAROS = 4;
	private int puntos;
	private int disparos;
	private Tablero tablero;
	private Casilla casillaDisparada;
	private boolean finJuego;

	public Juego() {
		inicializarJuego();
	}

	public void inicializarJuego() {
		tablero = new Tablero();
		puntos = 1000;
		disparos = 0;
		casillaDisparada = null;
		finJuego = false;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public Casilla getCasillaDisparada() {
		return casillaDisparada;
	}

	public void setCasillaDisparada(Casilla casillaDisparada) {
		this.casillaDisparada = casillaDisparada;
	}

	public boolean isFinJuego() {
		return finJuego;
	}

	public void dispara(int i) {
		disparos--;
		setCasillaDisparada(tablero.getCasillas()[i]); // guardamos la casilla sobre la que se ha disparado
		finJuego = isPartidaFinalizada();
		if(!getCasillaDisparada().getTipoCasilla().equals(TipoCasilla.METEORITO)) {
			puntos+=tablero.getCasillas()[i].getPuntos();
		}else {
			puntos = 0;
		}
	}

	public boolean isPartidaFinalizada() {
		return (getCasillaDisparada().getTipoCasilla().equals(TipoCasilla.INVASOR) || disparos == 0);
	}

	public int getPuntos() {
		return puntos;
	}

	public void lanzar() {
		setDisparos(Dado.lanzar());
	}

	public int getDisparos() {
		System.out.println(disparos); 
		return disparos;
	}

	private void setDisparos(int disparos) {
		this.disparos = disparos;
	}

	public String obtenerImagen(int i) {
		return getTablero().obtenerImagen(i);
	}   
	
}
