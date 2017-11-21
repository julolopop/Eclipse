package com.pspro;

public class Retirada extends Thread {
	Almacen almacen;
	int dias;
	public Retirada(Almacen almacen) {
		this.almacen = almacen;
		dias = 0;
	}

	@Override
	public void run() {
		while(almacen.getState()) {
		try { 
			sleep(2400); 
			}
			catch (InterruptedException e)
			 { e.printStackTrace(); 
			 }
		dias++;
		System.out.println("Día "+dias);
		almacen.retirada(2000+((int)(Math.random()*500+1)));
		
	}
	
}
}