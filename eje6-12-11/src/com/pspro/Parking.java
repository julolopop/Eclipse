package com.pspro;

public class Parking {
	private int[] buffer;
	private int contadorOcupado =0;
	private int posLectura=0;
	private int posEscritura=0;
	boolean[] ocupado;
	
public Parking(int numero) {
	buffer = new int[numero];
	for (int i = 0; i < numero; i++) {
		buffer[i]=-1;
	}
	
	ocupado = new boolean[numero];
	for (int i = 0; i < numero; i++) {
		ocupado[i]=false;
	}
}	


public synchronized void Aparcar(int matricula) {
	while (contadorOcupado==buffer.length) {
		try {
			this.wait();
		} catch (InterruptedException e) {				
			e.printStackTrace();
		}	
	}
	if(!ocupado[posEscritura]) {
		ocupado[posEscritura]=true;
		System.out.println("El coche ha aparcado en la posicion "+posEscritura);

		buffer[posEscritura] = matricula;
		contadorOcupado++;
		posEscritura = (posEscritura + 1)%buffer.length;
		
		
		String salida = "(Parking  \nhuecos:  ";
		for (int i = 0; i < buffer.length; i++) {
			salida += " "+buffer[i];
		}
		System.out.println(salida);
	}
	

}
public synchronized void Salir() {
	System.out.println("El coche "+buffer[posLectura]+" ha salido");
	ocupado[posLectura]=false;
	contadorOcupado--;
	posLectura = (posLectura + 1)%buffer.length;
	notifyAll();
}



	

}