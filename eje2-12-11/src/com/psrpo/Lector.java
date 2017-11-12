package com.psrpo;


public class Lector extends Thread {
	private Bufer compartido;
	private int veces;
	
	public Lector(Bufer elBuffer,int nVeces) {
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
