package com.pspro;

public class Testigo {

	boolean enUso = false;
	int turno=0;
	
	public synchronized void coger(int corredor) {
		while (corredor!=turno) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(!enUso) {
		System.out.println("El testigo ha sido recogido");
		enUso=true;
		}
	}
	
	public synchronized void soltar() {
		enUso=false;
		turno++;
		notifyAll();
	}
}
