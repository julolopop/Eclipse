package com.pspro;

public class Testigo {

	boolean enUso = false;
	
	public synchronized void coger() {
		while (enUso) {
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
		notify();
	}
}
