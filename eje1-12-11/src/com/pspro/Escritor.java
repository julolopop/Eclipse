package com.pspro;

public class Escritor extends Thread {
	
	@Override
	public void run() {
		System.out.println("Hola, Soy el hilo, "+currentThread().getName());
	}
	

	public void Seguir() {
		try {
			this.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
