package com.pspro;

import java.util.Random;

public class PinchaGlobos implements Runnable{
	Thread th;
	Globos globo;
	boolean fin = false;
	
	public PinchaGlobos(String nombre,Globos globo) {
		this.globo = globo;
		
		this.th = new Thread(this,nombre);
		this.th.start();
	}
	@Override
	public void run() {
		Random rnd = new Random();
		try {
			Thread.sleep((rnd.nextInt(10)*1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(this.globo.getVolumen() < 5 && this.globo.getVolumen() > -1)  {

			
			this.globo.pinchar(th.getName());
		}
		
		fin = true;

	}
}
