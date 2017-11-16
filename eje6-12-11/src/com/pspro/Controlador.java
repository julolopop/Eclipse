package com.pspro;

public class Controlador {

	public static void main(String[] args) {
		Parking parking;
		Coche coche;
		int nParking =0;
		int nCoche=0;	
	
		try {
			nParking = Integer.valueOf(args[0]);
			nCoche = Integer.valueOf(args[1]);	
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		parking = new Parking(nParking);
		
		for (int i = 0; i < nCoche; i++) {
			coche = new Coche(parking,i);
			coche.start();
		}
		
		
	}
	
}
