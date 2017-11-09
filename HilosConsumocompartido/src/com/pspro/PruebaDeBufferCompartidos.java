package com.pspro;

public class PruebaDeBufferCompartidos {

	public static void main(String[] args) {
		//Buffer bCompartido = new BufferCompartido();
		Buffer bCompartido = new BufferCompartidoCircular();

		
		
		Productor prod = new Productor(bCompartido, 10);
		Consumidor cons1 = new Consumidor(bCompartido, 6);
		Consumidor cons2 = new Consumidor(bCompartido, 4);
		StringBuffer encabezado = new StringBuffer("Operacion");
		
		encabezado.setLength(40);		
		encabezado.append("Buffer  contador ocupado");
		System.out.println(encabezado);
		System.out.println();
		
		bCompartido.MostrarEstado("Estado inicial");
		
		prod.start();
		cons1.start();
		cons2.start();
		
		try {
			prod.join();
			cons1.join();
			cons2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Hilos principales ha finalizado");

	}

}
