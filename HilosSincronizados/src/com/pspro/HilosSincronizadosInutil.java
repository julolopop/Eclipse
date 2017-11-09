package com.pspro;

class Inutil{
	private int a = 0;
	private int b = 0;
	
	public synchronized void marca5() {
		a=5;
		System.out.println("Marcando no me metas bulla");
		b=5;
	}
	
	public synchronized boolean esVerdad() {
		return a==0 || b == 5;
	}
	
}

class HiloA extends Thread{
	private Inutil i;
	public HiloA(Inutil in) {
		this.i=in;
	}

	@Override
	public void run() {
		i.marca5();
	}
}

class HiloB extends Thread{
	private Inutil i;

	public HiloB(Inutil in) {
		this.i=in;
	}
	@Override
	public void run() {
		if(i.esVerdad())
			System.out.println("Verdadero");
			else
				System.out.println("Mas falso que judas");
		}
}


public class HilosSincronizadosInutil {

	public static void main(String[] args) {
		Inutil in = new Inutil();
		
		HiloA ha = new HiloA(in);
		HiloB hb = new HiloB(in);
		
		ha.start();
		hb.start();
		
	}

}
