package com.pspro;

public class Envio extends Thread {
	Almacen almacen;

	public Envio(Almacen almacen) {
		this.almacen = almacen;

	}
	@Override
	public void run() {
		while(almacen.getState()) {
		try { 
			sleep(8000);
			} 
			catch (InterruptedException e)
			 { 
				e.printStackTrace(); 
			 }
			
		almacen.envio(400+((int)(Math.random()*600+1)));	
	}
		
	}
	
}