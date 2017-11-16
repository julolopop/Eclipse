package com.pspro;

public class Controlador {

	public static void main(String[] args) {
		Parking parking;
		Coche coche;
		Camion camion;
		int nParking =0;
		int nCoche=0;
		int nCamion=0;
	
		try {
			nParking = Integer.valueOf(args[0]);
			nCoche = Integer.valueOf(args[1]);
			nCamion = Integer.valueOf(args[2]);
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		parking = new Parking(nParking);
		
		
	
	for (int i = 0; i < nCamion; i++) {
		camion = new Camion(parking,100+i);
		camion.start();
	}
		for (int i = 0; i < nCoche; i++) {
			coche = new Coche(parking,i);
			coche.start();
		}
		
		
	}
	
}
