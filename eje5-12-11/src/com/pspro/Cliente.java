package com.pspro;

public class Cliente extends Thread {
	Caja cajas;
	int numero;
	
	public Cliente(Caja cajas) {
		this.cajas = cajas;
	}
	
	@Override
	public void run() {
	System.out.println("El cliente "+currentThread().getName()+" esta comprando");
	try {
		Thread.sleep((long) (Math.random()*2000));
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	System.out.println("El cliente "+currentThread().getName()+" entra ha caja");
	
	System.out.println("El cliente paga "+currentThread().getName()+" : "+cajas.atender());
	cajas.Salir();
	}
}
