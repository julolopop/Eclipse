package com.pspro;

public class Jugar {

	public static void main(String[] args) {
		int threads = 10;
		
		Arbitro arbitro = new Arbitro(threads);
	
		
		for (int i = 0; i < threads; i++) {
			new Jugador(arbitro, i).start();
		}
		
		System.out.println("fin");
	}

}
