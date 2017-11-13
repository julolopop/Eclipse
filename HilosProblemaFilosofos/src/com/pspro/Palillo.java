package com.pspro;

class Palillo{
	int numero;
	private boolean enUso;
	public Palillo(int x) {
		this.numero = x;
		enUso = false;
	}
	public synchronized void coger(){
		while (enUso) {
			System.out.println("Palillo "+numero+" ocupado, espera");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

		enUso = true;
		System.out.println("Palillo "+numero+" en uso");
	}
	
	public synchronized void soltar(){
		enUso = false;
		System.out.println("Palillo "+numero+" libre");

		this.notify();
	}
}
