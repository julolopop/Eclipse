package com.pspro;

public class Cliente extends Thread {
	Caja[] cajas;
	int numero;
	
	public Cliente(Caja[] cajas) {
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
	numero =(int) (Math.random()*cajas.length);
	System.out.println("El cliente "+currentThread().getName()+" entra ha caja");
	cajas[numero].atender();
	System.out.println("El cliente paga "+currentThread().getName()+" : "+Math.random()*5);
	cajas[numero].Salir();
	}
}
