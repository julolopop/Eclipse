package com.pspro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HiloInterrumpible implements Runnable{

	private Thread miHilo;
	private volatile boolean vivo;
	
	HiloInterrumpible(){
		this.miHilo = new Thread(this,"Hilo nuevo");
		this.vivo =true;
		this.miHilo.start();
	}
	

	public boolean isVivo() {
		return vivo;
	}


	public void interrumpir() {
		if (this.miHilo != null)
			this.miHilo.interrupt();
	}
	
	public void detener() {
		this.vivo = false;
	}
	
	public void esperar() {
		try {
			this.miHilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		System.out.println("Inicio del hilo");
		while (this.vivo){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("Hilo paso a dormir...");
			}
		}
		System.out.println("Fin del Hilo....");
	}





	
	
	
}

public class PuebaHiloInterrumpible {

	public static void main(String[] args) {

		HiloInterrumpible hilo = new HiloInterrumpible();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tecla;
		
		while(hilo.isVivo()) {
			

		try {
			tecla= br.readLine();
			if(tecla.equals("i"))
				hilo.interrumpir();
			if(tecla.equals("k"))
				hilo.detener();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		}
		try {
		hilo.esperar();
		}catch (Exception e) {
			// TODO: handle exception
		}
	
		
	}
	
	

}
