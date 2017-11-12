package com.psrpo;


public class Check {

	public static void main(String[] args) {
		int nBuffer = 10000;
		int nBuffer2 = nBuffer*2;
			Bufer bCompartido = new Bufer(nBuffer);

			
			
			Escritor escritor = new Escritor(bCompartido,nBuffer2);
			Lector lector1 = new Lector(bCompartido, nBuffer2);
			Lector lector2 = new Lector(bCompartido, nBuffer2);
			StringBuffer encabezado = new StringBuffer("Operacion");
			

			System.out.println(encabezado);
			System.out.println();
			
			bCompartido.MostrarEstado("Estado inicial");
			
			escritor.start();
			lector1.start();
			lector2.start();
			
			try {
				escritor.join();
				lector1.join();
				lector2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Hilos principales ha finalizado");

		}


}
