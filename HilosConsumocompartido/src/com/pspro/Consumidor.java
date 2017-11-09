package com.pspro;

public class Consumidor extends Thread {
	private Buffer compartido;
	private int veces;//veces que tiene que iterar el consumo de enteros de enteros
	
	public Consumidor(Buffer elBuffer,int nVeces) {
		this.compartido = elBuffer;
		this.veces = nVeces;
	}
	 @Override
	public void run() {
		 int suma =0;
		 
		 for (int i = 0; i < this.veces; i++) {
			try {
				Thread.sleep((int)(Math.random()*3001));
				suma += compartido.Leer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 System.out.println(getName()+" Termino de leer un total de "+ suma);
	}
}
