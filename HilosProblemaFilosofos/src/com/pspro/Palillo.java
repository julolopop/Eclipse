package com.pspro;

public class Palillo {

	int numero;
	boolean usando = false;
	
	public Palillo(int numero) {
		this.numero = numero;
	}
	
	
	public synchronized void Coger() {this.usando = true;}
	public synchronized void Soltar() {this.usando = false;}
}
