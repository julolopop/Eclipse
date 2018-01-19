package com.pspro;

public class Globos {
	
	private int numero;
	private int volumen;
	
	public Globos(int numero) {
		this.volumen = 1;
		this.numero = numero;
	}
	
	
	public synchronized void inchar() {
		this.volumen++;
	}
	
	public synchronized void verEstado() {
		System.out.println("El Globo "+this.numero+" con volumen : "+this.volumen);
	}
	
	public synchronized void estallar() {
		System.out.println("El Globo "+this.numero+" ha estallado");
		this.volumen = -1;
	}
	
	public synchronized void pinchar(String nombre) {
		System.out.println("El Globo "+this.numero+" ha sido pinchado por "+nombre);
		this.volumen = -1;
	}
	
	public synchronized int getVolumen() {
		return this.volumen;
	}
	
	public int getNumero() {
		return this.numero;
	}
}
