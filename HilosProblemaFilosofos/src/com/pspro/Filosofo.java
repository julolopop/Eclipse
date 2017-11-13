package com.pspro;

class Filosofo extends Thread{
	private Cena cena;
	private int piz, pde;
	private int numero; 
	private int veces; 
	public Filosofo(int pos, int nVeces,Cena cena) {
		this.numero = pos;
		this.cena = cena;
		this.veces = nVeces;
		piz = cena.cogerPalilloIzquierdo(pos);
		pde = cena.cogerPalilloDerecho(pos);
	}
	@Override
	public void run() {
		for(int i= 0; i< veces; i++){
			pensar();
			cogerPalillos();
			comer();
			soltarPalillos();
		}
	}
	public void pensar(){
		System.out.println("Filosofo "+ numero +" pensando");
		try {
			Thread.sleep((int)(Math.random()*10001));
			System.out.println("Filosofo "+ numero +" tiene hambre");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void cogerPalillos(){
		System.out.println("Filosofo "+ numero +" trata de coger sus palillos");
		if(numero%2 ==0){
			cena.cogerPalillo(piz).coger();
			cena.cogerPalillo(pde).coger();
		}else{
			cena.cogerPalillo(pde).coger();
			cena.cogerPalillo(piz).coger();
		}
	}
	public void comer(){
		System.out.println("Filosofo "+ numero +" comiendo");
		try {
			Thread.sleep((int)(Math.random()*20001));
			System.out.println("Filosofo "+ numero +" esta satisfecho");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void soltarPalillos(){
		System.out.println("Filosofo "+ numero +" suelta sus palillos");
			cena.cogerPalillo(piz).soltar();
			cena.cogerPalillo(pde).soltar();
		
	}
}
