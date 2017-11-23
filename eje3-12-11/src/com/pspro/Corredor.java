package com.pspro;

public class Corredor extends Thread {
	
	Testigo testigo;
	int corredor;
	
	public Corredor(Testigo testigo,int corredor) {
	this.testigo = testigo;
	this.corredor =corredor;
	}
	@Override
	public void run() {
		
		testigo.coger(this.corredor);
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
