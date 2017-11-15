package com.pspro;

public class Caja {
	private int[] buffer;
	private int contadorOcupado =0;
	private int posLectura=0;
	private int posEscritura=0;
	boolean ocupado = false;
	
public Caja(int cajas) {
	buffer = new int[cajas];
	for (int i = 0; i < cajas; i++) {
		buffer[i]=-1;
	}
}	


public synchronized int atender() {
	while (contadorOcupado==buffer.length) {
		try {
			this.wait();
		} catch (InterruptedException e) {				
			e.printStackTrace();
		}	
	}
	if(!ocupado) {
		ocupado=true;
		System.out.println("La caja "+posLectura+" pide el dinero");
		buffer[posEscritura] = (int)Math.random()*10;
		contadorOcupado++;
		posEscritura = (posEscritura + 1)%buffer.length;
		
	}
	
	return buffer[posEscritura];
}
public synchronized void Salir() {
	System.out.println("la caja "+posLectura+ " esta libre");
	ocupado=false;
	contadorOcupado--;
	notifyAll();
}


	

}