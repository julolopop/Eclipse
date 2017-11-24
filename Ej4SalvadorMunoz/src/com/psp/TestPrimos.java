package com.psp;

public class TestPrimos {
	static int numeros[];

	public static void main(String[] args) {
		numeros = new int[100];
		inicializar();
		Numero  numero = new Numero();
		HiloPrimos hilo1 = new HiloPrimos(numero, 0, 19, numeros);
		HiloPrimos hilo2 = new HiloPrimos(numero, 20, 39, numeros);
		HiloPrimos hilo3 = new HiloPrimos(numero, 40, 59, numeros);
		HiloPrimos hilo4 = new HiloPrimos(numero, 60, 79, numeros);
		HiloPrimos hilo5 = new HiloPrimos(numero, 80, 99, numeros);


		hilo1.run();
		hilo2.run();
		hilo3.run();
		hilo4.run();
		hilo5.run();
		try {
			hilo1.esperar();
			hilo2.esperar();
			hilo3.esperar();
			hilo4.esperar();
			hilo5.esperar();
			Double media =(double)100/(double)numero.obtenerTotal();
			System.out.println("La media de numeros primos es "+ media);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void inicializar() {
		for(int i = 0; i< numeros.length;i++) {
			numeros[i] = (int) (Math.random()*1001);
		}
	}

}
