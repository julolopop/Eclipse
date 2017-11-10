package com.pspro;

public class SimulacionCena {

	
	
	public static void main(String[] args) {
		int comensales = 5;
		int comidasIndividuales=3;
		Palillo[] palillos= new Palillo[comensales];
	
		
		for (int i = 0; i < comensales; i++) {
			new Filosofo(i,comidasIndividuales);
			palillos[i]= new Palillo(i);
		}
		
		System.out.println("fin principal");
	}

}
