package com.psrpo;


public class Escritor extends Thread{
	private Bufer compartido;
	private int veces;
	
	public Escritor(Bufer elBuffer,int nVeces) {
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
