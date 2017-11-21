package com.pspro;

public class Principal {

	public static void main(String[] args) {
		Almacen almacen = new Almacen();
		
		Retirada retirada = new Retirada(almacen);
		Envio envio = new Envio(almacen);
	
		retirada.start();
		envio.start();

		
		
	}

}