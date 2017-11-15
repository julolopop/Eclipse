package com.pspro;

public class Parking {
	private int[] buffer;
	private int contadorOcupado =0;

	private int posEscritura=0;
	boolean[] ocupado;
	
public Parking(int veiculos) {
	buffer = new int[veiculos];
	for (int i = 0; i < veiculos; i++) {
		buffer[i]=-1;
	}
	ocupado = new boolean[veiculos];
	for (int i = 0; i < veiculos; i++) {
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
		
	}
	

}

public synchronized void AparcarCamion(int matricula) {

	while (contadorOcupado==buffer.length) {
		try {
			this.wait();
		} catch (InterruptedException e) {				
			e.printStackTrace();
		}	
	}
	if(!ocupado[posEscritura] &&!ocupado[posEscritura+1]) {
		ocupado[posEscritura]=true;
		ocupado[posEscritura+1]=true;
		System.out.println("El coche ha aparcado en la posicion "+posEscritura);

		buffer[posEscritura] = matricula;
		contadorOcupado++;
		posEscritura = (posEscritura + 1)%buffer.length;
		
	}
	

}

public synchronized void Salir() {
	System.out.println("El coche ha salido");
	ocupado[posEscritura]=false;
	contadorOcupado--;
	notifyAll();
}
public synchronized void SalirCamion() {
	System.out.println("El coche ha salido");
	ocupado[posEscritura]=false;
	ocupado[posEscritura+1]=false;
	contadorOcupado--;
	notifyAll();
}

public void MostrarSalida() {
	String salida = "(Parking  \nhuecos:  ";
	for (int i = 0; i < buffer.length; i++) {
		salida += " "+buffer[i];
	}
System.out.println(salida);

}
	

}