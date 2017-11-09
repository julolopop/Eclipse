package com.pspro;

public class Alumno extends Thread{
	
	String nombre;
	Bienvenida saludo;

	public Alumno(String nomAlumno,Bienvenida b) {
		this.nombre = nomAlumno;
		this.saludo = b;
	}
	
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			saludo.SaludarAlProfesor(this.nombre);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}