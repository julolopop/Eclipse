package com.psp;

public class Numero {
	private int total;
	private static final Object mutex = new Object();
	
	public Numero() {
		total = 0;
	}
	
	public void esPrimo(int numero) {
		boolean primo = true;
		if(numero >1) {
			for(int i = 2; i<numero;i++ ) {
				if(numero%i==0)
					primo = false;
			}
		}
		
		if(primo)
			aumentar();
	}
	
	private void aumentar() {
		synchronized(mutex) {
			total++;
		}
	}
	public  int obtenerTotal() {
		int res;
		synchronized (mutex) {
			res = total;
			
		}
		
		return res;
	}

}
