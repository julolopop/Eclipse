package com.pspro;


public class Escritor extends Thread {

	private ControladorFichero destino;
	private String contenido = "";
	
	public Escritor(ControladorFichero fich) {
		this.destino = fich;
	}
	
	public void fraseAdd(String cadena) {
		this.contenido += cadena;
	}
	
	@Override
	public void run() {
		this.destino.println(contenido);
	}
}
