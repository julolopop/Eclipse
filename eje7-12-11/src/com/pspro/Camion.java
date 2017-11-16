package com.pspro;

public class Camion extends Thread {
	Parking parking;
	int numero;
	
	public Camion(Parking parking,int matricula) {
		this.parking = parking;
		this.numero = matricula;
	}
	
	@Override
	public void run() {
	System.out.println("El Camion "+currentThread().getName()+" se pone en cola");
	parking.AparcarCamion(numero);
	System.out.println("El Camion "+currentThread().getName()+" ha aparcardo");
	
	try {
		Thread.sleep((long) (Math.random()*2000));
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	System.out.println("El Camion "+currentThread().getName()+" va ha salir");
	parking.SalirCamion();
	}
}