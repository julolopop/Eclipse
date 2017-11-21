package com.pspro;

public class Almacen {
	
		int numPiezas=8000;
		int maxPiezas = 20000;
		boolean estado;
		int contadorEnvios;
		boolean pedidoRealizado;
		
		public synchronized boolean getState()
		{
			return estado;
		}
		public Almacen() {
			contadorEnvios =0;
			pedidoRealizado=false;
			estado = true;
		}

		public synchronized void envio(int numPiezasEnvio)
		{
			while(!pedidoRealizado)
			{
				try {
				this.wait();
				}catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			if(estado)
			{
			if((numPiezas+numPiezasEnvio)>maxPiezas)
			{
				System.out.println("El almacen esta lleno");
				estado = false;
				pedidoRealizado=false;
			}else {
				numPiezas=numPiezas+numPiezasEnvio;
				System.out.println("Llegan "+numPiezasEnvio+" piezas");
				
				System.out.println("Hay "+numPiezas+" piezas en el almacén");
				contadorEnvios++;
			}
			if(contadorEnvios==3)
			{
				pedidoRealizado=false;
				contadorEnvios=0;
				
			}
			}
			notify();
		}
		
		public synchronized void retirada(int numPiezasRetirada)
		{
			while(pedidoRealizado)
			{
				try {
					this.wait();
					}catch (InterruptedException e)
					{
						e.printStackTrace();
					}
			}
			if(estado)
			{
			System.out.println("Se ha realizado un pedido de "+numPiezasRetirada+" piezas");
			if(numPiezas-numPiezasRetirada<1)
			{
				System.out.println("No hay piezas ");
				estado = false;
				pedidoRealizado=true;
			}
			else {
				
				numPiezas=numPiezas-numPiezasRetirada;
				pedidoRealizado=true;
				System.out.println("Hay "+numPiezas+" piezas en el almacén");
			}
			}
			notify();
		}
	
}