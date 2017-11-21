package com.pspro;

public class Envio extends Thread {
	Almacen alm;

	public Envio(Almacen alm) {
		this.alm = alm;

	}
	@Override
	public void run() {
		while(alm.getState()) {
		try { 
			sleep(800); // simulación de 8 horas 
			} 
			catch (InterruptedException e)
			 { 
				e.printStackTrace(); 
			 }
			
		alm.envio(400+((int)(Math.random()*600+1)));	
	}
		
	}
	
}