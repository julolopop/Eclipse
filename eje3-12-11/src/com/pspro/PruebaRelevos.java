package com.pspro;

public class PruebaRelevos {

	public static void main(String[] args) {
		int corredores = 4;
		Testigo testigo = new Testigo();
		Corredor corredor;
		
		for (int i = 0; i < corredores; i++) {
			corredor = new Corredor(testigo);
			corredor.start();
			try {
				corredor.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("Fin de la carrera");
	}

}
