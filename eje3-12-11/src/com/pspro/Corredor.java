package com.pspro;

public class Corredor extends Thread {
	@Override
	public void run() {
		System.out.println("El corredor"+currentThread().getName()+" ha empezado a correr");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("el corredor"+currentThread().getName()+" ha dejado el testigo");
	}
}
