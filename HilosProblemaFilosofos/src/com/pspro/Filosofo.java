package com.pspro;

public class Filosofo  implements Runnable{

	int PalilloIzq,PalilloDer;
	int numero;
	int veces;
	
	
	public Filosofo(int numero,int veces) {
		this.PalilloIzq = numero+1;
		this.PalilloDer=numero;
		this.numero = numero;
		this.veces = veces;
		
	}
	
	@Override
	public void run() {
		for (int i = 0; i < veces; i++) {
			Pensar();
			CogerPalillos();
			Comer();
			SoltarPalillos();
		}
		
	}

	public void Pensar() {
		System.out.println("El filosofo "+this.numero+" Esta pensando..." );
	}
	public void CogerPalillos() {
		System.out.println("El filosofo "+this.numero+" Cogio sus palillos..."+this.PalilloIzq+" y "+this.PalilloDer );
	}
	public void SoltarPalillos() {
		System.out.println("El filosofo "+this.numero+" Solto los palillos..."+this.PalilloIzq+" y "+this.PalilloDer );
	}
	public void Comer() {
		System.out.println("El filosofo "+this.numero+" Esta Comiendo..." );
	}


}
