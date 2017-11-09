package com.pspro;

public class Profesor extends Thread{
	
	String nombre;
	Bienvenida saludo;

	public Profesor(String nomAlumno,Bienvenida b) {
		this.nombre = nomAlumno;
		this.saludo = b;
	}
	
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			saludo.ProfesorSaluda();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
