package uo.cmp.p3.service;


import java.time.LocalDateTime;

import uo.cmp.p3.model.*;

public class McDonalds {
	Carta carta = new Carta();
	Pedido pedido = new Pedido(); 
	
	
	public McDonalds() {
		inicializarPedido();
	}

	public Articulo[] getArticulosCarta() {
		return carta.getArticulos();
	}
	
	public void inicializarPedido() {
		pedido.inicializar();
	}
	
	public String getCodigoPedido() {
		return pedido.getCodigo();
	}

	public void aniadirAPedido(Articulo articulo, int unidades) {
		pedido.add(articulo, unidades);
	}
	
	public void eliminarDePedido(Articulo articulo, int unidades) {
		pedido.eliminar(articulo, unidades);
	}

	public float getImportePedido() {
		return pedido.getImporte();
	}
	
	public void guardarCliente(String nombre, int anio, String password) {
		pedido.setCliente(new Cliente(nombre, anio, password));
	}
	
	public void actualizarTipoPedido (boolean llevar) {
		pedido.setLocal(llevar);
	}
	
	public void grabarPedido() {
		pedido.grabarPedido();
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public String[] getRangoAnios() {
	    int anioActual = LocalDateTime.now().getYear();
	    int rango = Cliente.EDAD_MAX-Cliente.EDAD_MIN;
		String[]anios = new String[rango];
		for (int i=0;i<rango;i++)
			anios[i] = String.valueOf((anioActual-Cliente.EDAD_MIN)-i);
		return anios;
	}
	
	
	//Método que se usará para el texto en rojo. HACER
	
	public int getUnidadesArticulo(Articulo articuloSeleccionado) {
		for(Articulo a: pedido.getListaPedido()) { //Preguntar esto
			if(a.getCodigo().equals(articuloSeleccionado.getCodigo())) {
				return (a.getUnidades());
			}
		}
		return 0;
	}

	//HACER ESTOS DOS
	

	public boolean hayPedido() {
		return false;
	}

	public boolean hayUnidadesArticulo(Object selectedItem) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Articulo[] getArticulo(String tipo) {
		listaArticulosTipo.clear();
		if(tipo.equals("Todos")) {
			return getArticulosCarta();
		}else {
			for(Articulo a: listaArticulos) {
				if(a.getTipo().equals(tipo)) {
					listaArticulosTipo.add(a);
				}
			}
		}
		return listaArticulosTipo.toArray(new Articulo[listaArticulosTipo.size()]);
		
	}
	

}
