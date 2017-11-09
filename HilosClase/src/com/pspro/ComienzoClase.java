package com.pspro;



public class ComienzoClase {

	public static void main(String[] args) {
		//objeto compartido
		Bienvenida b = new Bienvenida();
		
		int nAlumno = Integer.parseInt(args[0]);
		for (int i = 0; i < nAlumno; i++) {
			new Alumno("Alumno "+i,b).start();
		}
		Profesor profe = new Profesor("Maestro", b);
		profe.start();
		
		try {
			profe.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
}



class Bienvenida {

	private boolean comienzaLaClase = false;
	
	
	public synchronized void SaludarAlProfesor(String nombre) {
		System.out.println("EL alumno "+ nombre +" Quiere saludar");
		while (!comienzaLaClase){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("EL alumno "+ nombre+" Saluda");
	}
	
	public synchronized void ProfesorSaluda() {
		System.out.println("EL Profesor Saluda ");
		this.comienzaLaClase = true;
		notifyAll();
	}

}
