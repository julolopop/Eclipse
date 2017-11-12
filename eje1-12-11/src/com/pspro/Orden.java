
package com.pspro;

public class Orden {
	public static void main(String[] args) {
		int hilos =2;
		Escritor e;
		
		for (int i = 0; i < hilos; i++) {
			e =new Escritor();
			e.start();
			try {
				e.join();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		System.out.println("Fin de la Orden");
		
	}
	
}
