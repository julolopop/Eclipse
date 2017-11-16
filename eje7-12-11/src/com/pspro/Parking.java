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
	while (buffer[(posLectura + 1)%buffer.length] == -2) {
		try {
			this.wait();
		} catch (InterruptedException e) {				
			e.printStackTrace();
		}	
	}
	System.out.println("El coche "+buffer[posLectura]+" ha salido");
	ocupado[posLectura]=false;
	contadorOcupado--;
	posLectura = (posLectura + 1)%buffer.length;
	notifyAll();
}




public synchronized void AparcarCamion(int matricula) {

	while (contadorOcupado==buffer.length || (ocupado[posEscritura] ||ocupado[(posEscritura + 1)%buffer.length]) ) {
		try {
			this.wait();
		} catch (InterruptedException e) {				
			e.printStackTrace();
		}	
	}
	if(!ocupado[posEscritura] &&!ocupado[(posEscritura + 1)%buffer.length]) {
		ocupado[posEscritura]=true;
		ocupado[(posEscritura + 1)%buffer.length]=true;
		System.out.println("El camion ha aparcado en la posicion "+posEscritura);

		buffer[posEscritura] = matricula;
		buffer[(posEscritura + 1)%buffer.length] = -2;
		contadorOcupado+=2;
		posEscritura = (posEscritura + 2)%buffer.length;
		
		String salida = "(Parking  \nhuecos:  ";
		for (int i = 0; i < buffer.length; i++) {
			salida += " "+buffer[i];
		}
	System.out.println(salida);
		
	}
	

}

public synchronized void SalirCamion() {

	System.out.println("El camion ha salido "+buffer[posLectura]);
	ocupado[posLectura]=false;
	ocupado[(posLectura + 1)%buffer.length]=false;
	buffer[(posLectura + 1)%buffer.length] = -1;
	contadorOcupado-=2;
	posLectura = (posLectura + 2)%buffer.length;
	notifyAll();
}

	

}