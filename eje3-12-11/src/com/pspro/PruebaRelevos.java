package com.pspro;

public class PruebaRelevos {

	public static void main(String[] args) {
		int corredores = 4;
		Testigo testigo = new Testigo();
		Corredor corredor;
		
		for (int i = 0; i < corredores; i++) {
			corredor = new Corredor(testigo,i);
			corredor.start();
		}
		
	}

}
