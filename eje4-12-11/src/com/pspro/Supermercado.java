package com.pspro;


public class Supermercado {

	public static void main(String[] args) {
		Caja[] cajas;
		Cliente cliente;
		int nCajas =0;
		int nClientes=0;	
	
		try {
			nCajas = Integer.valueOf(args[0]);
			nClientes = Integer.valueOf(args[1]);	
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		cajas = new Caja[nCajas];
		for (int i = 0; i < cajas.length; i++) {
			cajas[i] = new Caja(i);
		}
		for (int i = 0; i < nClientes; i++) {
			cliente = new Cliente(cajas);
			cliente.start();
		}
		
		
	}
	
}
