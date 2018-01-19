package com.pspro;

public class HinchaGlobos implements Runnable{
	Thread th;
	Globos globo;
	boolean fin = false;
	
	public HinchaGlobos(String nombre,Globos globo) {
		this.globo = globo;
		
		this.th = new Thread(this,nombre);
		this.th.start();
	}
	
	@Override
	public void run() {
		
		System.out.println("El globo Globo"+this.globo.getNumero()+" ha sido cogido por "+th.getName());
		
		while(this.globo.getVolumen() != 5) {
			this.globo.inchar();
			this.globo.verEstado();
		}
		this.globo.estallar();
		fin = true;
	}

}
