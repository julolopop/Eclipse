package com.pspro;

public class Corredor extends Thread {
	
	Testigo testigo;
	
	public Corredor(Testigo testigo) {
	this.testigo = testigo;
	}
	@Override
	public void run() {
		
		testigo.coger();
		System.out.println("El corredor"+currentThread().getName()+" ha empezado a correr");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		testigo.soltar();
		System.out.println("el corredor"+currentThread().getName()+" ha dejado el testigo");
	}
}
