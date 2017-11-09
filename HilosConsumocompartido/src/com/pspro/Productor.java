package com.pspro;

public class Productor extends Thread{
	private Buffer compartido;
	private int veces;//veces que tiene que iterar las produciones de enteros
	
	public Productor(Buffer elBuffer,int nVeces) {
		this.compartido = elBuffer;
		this.veces = nVeces;
	}
	 @Override
	public void run() {
		 for (int i = 0; i < this.veces; i++) {
			try {
				Thread.sleep((int)(Math.random()*1001));
				compartido.Escribir(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 System.out.println(getName()+" Termino de producir datos");
	}
}
