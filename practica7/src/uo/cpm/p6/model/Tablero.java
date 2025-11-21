package uo.cpm.p6.model;

import uo.cpm.p6.model.Casilla.TipoCasilla;

public class Tablero {

	Casilla[] casillas;
	private int dim;
	private int nInvasores;
	private int nMeteoritos;

	public Tablero() {
		casillas = new Casilla[dim];
		for (int i = 0; i < dim; i++)
			casillas[i] = new Casilla("Espacio", TipoCasilla.ESPACIO, -200, "/img/space.jpg");
		colocaInvasor();
	}

	public Tablero(int dim, int numInvasores, int numMeteoritos) {
		this.dim = dim;
		this.nInvasores = numInvasores;
		this.nMeteoritos = numMeteoritos;
		
		casillas = new Casilla[dim];
		for(int i = 0;i<casillas.length;i++) {
			casillas[i] = new Casilla("Espacio", TipoCasilla.ESPACIO,-200, "/img/space.jpg");
			colocaInvasor();
			colocaMeteorito();
		}
	}

	private void colocaInvasor() {
		int posicionInvasor;
		for(int i =0;i<nInvasores;i++) {
			do {
				posicionInvasor  = (int) (Math.random() * dim);
			}while(!casillas[posicionInvasor].getTipoCasilla().equals(TipoCasilla.ESPACIO));
			casillas[posicionInvasor] = new Casilla("Invasor", TipoCasilla.INVASOR, 3000, "/img/invader.jpg");
			System.out.println("Posicion invasor = " + posicionInvasor);
		}
	}

	public Casilla[] getCasillas() {
		return casillas;
	}

	public int getnInvasores() {
		return nInvasores;
	}

	public String obtenerImagen(int i) {
		return casillas[i].getImagen();
	}
	
	private void colocaMeteorito() {
		int posicionMeteorito;
		for(int i = 0; i<nMeteoritos;i++) {
			do
				posicionMeteorito = (int) (Math.random() *dim);
			while(!casillas[posicionMeteorito].getTipoCasilla().equals(TipoCasilla.ESPACIO));
			casillas[posicionMeteorito] = new Casilla("Meteorito", TipoCasilla.METEORITO,0, "/img/meteorite.jpg");
			System.out.println("Posición meteorito = "+ posicionMeteorito);
		}
	}
	public int getDim() {
		return dim;
	}
}
