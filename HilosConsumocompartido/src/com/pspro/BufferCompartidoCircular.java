package com.pspro;


public class BufferCompartidoCircular implements Buffer  {
	private int[] buffer = {-1,-1,-1};
	private int contadorOcupado =0;
	private int posLectura=0;
	private int posEscritura=0;
	
	
	
	
	@Override
	public synchronized int Leer() {
		String hiloLlamador = Thread.currentThread().getName();
		
		while (contadorOcupado==0) {
			System.out.println(hiloLlamador+ " Trata de leer");
			System.out.println("Buffer vaío "+hiloLlamador+" debe esperar");
			
			try {
				this.wait();
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}	
		}
		
		int valorLeido = buffer[posLectura];
		contadorOcupado--;
		posLectura = (posLectura + 1)%buffer.length;

		System.out.println(hiloLlamador+ " Consigue leer "+ valorLeido);
		MostrarSalida();
		notify();
		
		return valorLeido;
	}

	@Override
	public synchronized void Escribir(int valor) {
		String hiloLlamador = Thread.currentThread().getName();
		
		while (contadorOcupado==buffer.length) {
			System.out.println(hiloLlamador+ " Trata de escribir");
			System.out.println("Buffer lleno "+hiloLlamador+" debe esperar");
			
			try {
				this.wait();
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}	
		}
		
		buffer[posEscritura] = valor;
		contadorOcupado++;
		posEscritura = (posEscritura + 1)%buffer.length;

		System.out.println(hiloLlamador+ " Consigue Escribir "+ valor);
		notify();
		
		
		
	}

	@Override
	public void MostrarEstado(String cadena) {
		StringBuffer linea = new StringBuffer(cadena);
		linea.setLength(80);
		linea.append(this.buffer+" "+this.contadorOcupado);
		System.out.println(linea);
		System.out.println();
		
		
	}
	
	public String MostrarSalida() {
		String salida = "(Huecos ocupados "+ contadorOcupado+")\nhuecos:  ";
		for (int i = 0; i < buffer.length; i++) {
			salida += " "+buffer[i];
		}
		salida+= "\n         ";
		for (int i = 0; i < buffer.length; i++) {
			if (i == posEscritura && posLectura == i) {
				salida+= " EL ";
			}else {
			if (i == posEscritura) {
				salida+= " E ";
			}
			if (posLectura == i) {
				salida+= " L ";
			}}
		}
		salida+= "\n";
		System.out.println(salida);
		return salida;
				
	}

	

}
