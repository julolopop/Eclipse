package com.pspro;

public class Caja {
	int nCaja;
boolean ocupado = false;
	
public Caja(int nCaja) {
this.nCaja = nCaja;
}


public synchronized void atender() {
	while(ocupado) {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	if(!ocupado) {
		ocupado=true;
		System.out.println("La caja "+nCaja+" pide el dinero");
	}
}
public synchronized void Salir() {
	System.out.println("la caja "+nCaja+ " esta libre");
	ocupado=false;
	notifyAll();
}

}
