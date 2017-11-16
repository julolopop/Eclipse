package com.pspro;

public class Coche extends Thread {
	Parking parking;
	int numero;
	
	public Coche(Parking parking,int matricula) {
		this.parking = parking;
		this.numero = matricula;
	}
	
	@Override
	public void run() {
	System.out.println("El coche "+currentThread().getName()+" se pone en cola");
	parking.Aparcar(numero);
	System.out.println("El coche "+currentThread().getName()+" ha aparcardo");
	
	try {
		Thread.sleep((long) (Math.random()*2000));
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	System.out.println("El coche "+currentThread().getName()+" va ha salir");
	parking.Salir();
	}
}
