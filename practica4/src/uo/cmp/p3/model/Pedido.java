package uo.cmp.p3.model;

import java.util.*;

import uo.cmp.p3.util.FileUtil;

public class Pedido {

	private List<Articulo> listaPedido;
	private String codigo;
	private float importe;
	private boolean local;
	private Cliente cliente;
	

	public Pedido() {
		listaPedido = new ArrayList<Articulo>();
		inicializar();
	}

	public void inicializar() {
		listaPedido.clear();
		generarCodigo();
		setImporte(0);
		setLocal(true);
	    setCliente(null);
	}

	public void add(Articulo articuloDelCatalogo, int unidades) {
		Articulo articuloEnPedido = null;

		for (Articulo a : listaPedido) {
			if (a.getCodigo().equals(articuloDelCatalogo.getCodigo())) {
				articuloEnPedido = a;
				articuloEnPedido.setUnidades(articuloEnPedido.getUnidades() + unidades);
				break;
			}
		}

		if (articuloEnPedido == null) {
			articuloEnPedido = new Articulo(articuloDelCatalogo);
			articuloEnPedido.setUnidades(unidades);
			listaPedido.add(articuloEnPedido);
		}
		calcularImporte();
	}

	private void calcularImporte() {
		importe=0;
		for (Articulo a : listaPedido) 
			importe += a.getPrecio() * a.getUnidades();
		//Si es para llevar se sube el importe
		/*
		 * if(!isLocal())
		 * 	importe+=15;
		 */
	}

	public void grabarPedido() {
		FileUtil.saveToFile(this);
	}

	public List<Articulo> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(List<Articulo> listaPedido) {
		this.listaPedido = listaPedido;
	}

	public String getCodigo() {
		return codigo;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void eliminar(Articulo art, int unds) {
		Articulo articuloEnPedido = null;
		for(Articulo a: listaPedido) {
			if(a.getCodigo().equals(art.getCodigo())){
				articuloEnPedido = a;
			}
		}
		if(articuloEnPedido!=null) {
			int totalUnidades = articuloEnPedido.getUnidades() - unds;
			if(totalUnidades <=0) {
				listaPedido.remove(articuloEnPedido);
			}else {
				articuloEnPedido.setUnidades(totalUnidades);
			}
			calcularImporte();
		}
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setLocal (boolean tipo) {
		local = tipo;
	}
	
	public boolean isLocal() {
		return local;
	}
	
	
	//Esto estaba en void y lo cambié yo
	public String generarCodigo() {
		codigo = "";
		String base = "0123456789abcdefghijklmnopqrstuvwxyz";
		int longitudCodigo = 8;
		for (int i = 0; i < longitudCodigo; i++)
			codigo += base.charAt((int) (Math.random() * (base.length())));
		return codigo;
	}
	
	
	 public void actualizarTipoPedido(boolean llevar){
	  	setLocal(llevar);
	  	calcularImporte();
	  }
	 

	
}
