package com.pspro;

public class PruebaFicherosHilosSincronizadoConFicheros {

	public static void main(String[] args) throws InterruptedException {
		ControladorFichero cf = new ControladorFichero("poema.txt");

		String parrafo1 = "¡ ser o no se ! es el la cuestión";
		String parrafo2 = "¡ add o no add! son los problemón";
		
		Escritor cervantes = new Escritor(cf);
		Escritor sheakespeare = new Escritor(cf);
		
		cervantes.fraseAdd(parrafo1);
		sheakespeare.fraseAdd(parrafo2);
		
		cervantes.start();
		sheakespeare.start();
		
		
		cervantes.join();
		sheakespeare.join();
		
		cf.Closed();
		System.out.println("Los datos han sido escritos correctamente");
		
						
	}

}
