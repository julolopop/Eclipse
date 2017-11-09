package com.pspro;

class HiloHolaMundo implements Runnable{


	Thread hilo;
	
	public HiloHolaMundo() {
		this.hilo = new Thread(this,"Nuevo hilo Creado");
		System.out.println("Creando nuevo hilo ..."+ this.hilo);
		this.hilo.start();
	}
	public void Espera() {
		try {
			this.hilo.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		System.out.println("Hilo nuevo ha comenzado a ejecutarse ...");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Hilo finalizado...");
	}
	
}

public class HolaMundo {
	public static void main(String[] args) {
	
		System.out.println("Hola desde el hilo principal (Main)");
		new HiloHolaMundo().Espera();
		
		System.out.println("Fin del hilo principal");
	}
}
