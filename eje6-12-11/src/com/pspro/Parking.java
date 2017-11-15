package com.pspro;

public class Parking {
	private int[] buffer;
	private int contadorOcupado =0;

	private int posEscritura=0;
	boolean ocupado = false;
	
public Parking(int cajas) {
	buffer = new int[cajas];
	for (int i = 0; i < cajas; i++) {
		buffer[i]=-1;
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
	if(!ocupado) {
		ocupado=true;
		System.out.println("El coche ha aparcado en la posicion "+posEscritura);

		buffer[posEscritura] = matricula;
		contadorOcupado++;
		posEscritura = (posEscritura + 1)%buffer.length;
		
	}
	

}
public synchronized void Salir() {
	System.out.println("El coche ha salido");
	ocupado=false;
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