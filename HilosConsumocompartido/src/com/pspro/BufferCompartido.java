package com.pspro;

public class BufferCompartido implements Buffer {

	private int buffer = -1;
	private int contadorOcupado = 0;
	
	@Override
	public synchronized int Leer() {
		
		while (contadorOcupado==0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			}
		
		MostrarEstado(Thread.currentThread().getName()+" consige leer "+buffer);
		contadorOcupado=0;
		notify();
		return buffer;
	}

	@Override
	public synchronized void Escribir(int valor) {
		
		while (contadorOcupado==1) {
			MostrarEstado(Thread.currentThread().getName()+" trata de escribir");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		buffer = valor;
		MostrarEstado(Thread.currentThread().getName()+" Escribio "+buffer);
		contadorOcupado=1;
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

}
