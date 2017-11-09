package com.pspro;

class DatoCompartido{
	public static int a = 0;
	public static int b = 0;
	public static final Object MUTEX1 = new Object();
	public static final  Object MUTEX2 = new Object();
	
	
	
	public static void incrementarA() {
		//sc1
		synchronized (MUTEX1) {
		a++;
		}
		//fin sc1
	}
	
	public static void incrementarB() {
		//sc2
		synchronized (MUTEX2) {
		b++;
		}
		//fin sc2
	}
	
}

class HiloMutex extends Thread{
		@Override
		public void run() {
			DatoCompartido.incrementarA();
			DatoCompartido.incrementarB();
		}
		
}




public class HilosExclusionMutua {

	public static void main(String[] args) {
		
		int N = Integer.parseInt(args[0]);
		
		HiloMutex[] hilos;
		
		System.out.println("Creando "+N+" hilos");
		hilos = new HiloMutex[N];
		
		for (int i = 0; i < hilos.length; i++) {
			hilos[i] =  new HiloMutex();
			hilos[i].start();
		}
		
		for (int i = 0; i < hilos.length; i++) {
			try {
				hilos[i].join();
			} catch (InterruptedException e) {
			}
		}
		
		
		System.out.println("A = "+DatoCompartido.a+" , B "+DatoCompartido.b);
		

	}

}
