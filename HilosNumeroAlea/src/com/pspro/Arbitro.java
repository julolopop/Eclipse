package com.pspro;

public class Arbitro {
	int numJugador;
	int turno;
	int objetivo;
	boolean acertado;
	int maximo = 1000;
	
	public Arbitro(int nJug) {
		this.numJugador= nJug;
		this.turno = (int)(this.numJugador * Math.random());
		this.objetivo = 1 + (int) (this.maximo* Math.random());
		this.acertado = false;
		System.out.println("numero a acertar : "+this.objetivo);
	}
	
	

	public int esTurnoDe() {
		return this.turno;
	}
	public synchronized boolean seAcabo() {
		return this.acertado;
	}
	public synchronized void jugar(int jugador,int jugada) {
		while (jugador != this.turno && !this.acertado) {
			try {
				System.out.println("[pre] jugador "+jugador + "y es turno de "+this.turno);
				wait();
				System.out.println("[post] jugador "+jugador + "y es turno de "+this.turno);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(!acertado) {
			System.out.println("El jugador "+jugador+" prueba con  " + jugada );
			if (jugada == objetivo) {
				acertado=true;
				System.out.println("Jugador "+turno+" Win!!");
			}else {
				turno=(turno+1)%numJugador;
			}
			notifyAll();
		}
	}
}
