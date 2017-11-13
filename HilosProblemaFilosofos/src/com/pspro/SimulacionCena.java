package com.pspro;

public class SimulacionCena {

	public static void main(String[] args) {
		int comensales = Integer.parseInt(args[0]);
		int almuerzos = Integer.parseInt(args[1]);
		Filosofo f;
		
		Cena cena = new Cena(comensales);
		for(int i = 0; i<comensales;i++){
			f = new Filosofo(i,almuerzos,cena);
			f.start();
		}
		
		

	}

}






