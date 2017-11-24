package com.psp;

public class HiloPrimos implements Runnable{
	Thread hilo;
	Numero numero;
	int inicio,fin;
	int numeros[];
	
	public HiloPrimos(Numero numero,int inicio, int fin, int numeros []) {
		hilo = new Thread(this,"hilito");
		this.numero=numero;
		this.inicio = inicio;
		this.fin = fin;
		this.numeros = numeros;
	}

	@Override
	public void run() {
		for(int i = inicio; i < fin;i++) {
			numero.esPrimo(numeros[i]);
		}
		
	}
	public void esperar() throws InterruptedException {
		hilo.join();
	}

}
