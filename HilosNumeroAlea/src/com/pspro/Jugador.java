package com.pspro;

public class Jugador extends Thread {

	Arbitro arbitro;
	int dorsal;
	
	public Jugador(Arbitro arbitro,int dorsal) {
		this.arbitro = arbitro;
		this.dorsal=dorsal;
		try {
			this.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		while (!arbitro.seAcabo()) {
			arbitro.jugar(this.dorsal, 1+(int)(this.arbitro.maximo *Math.random()));
		}
		System.out.println("fin de hilo "+currentThread().getName());
	}
	
}
