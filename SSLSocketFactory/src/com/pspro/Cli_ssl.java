package com.pspro;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Cli_ssl {

	static final String DESTINO = "127.0.0.1";
	static final int PUERTO = 5555;
	
	public Cli_ssl() throws Exception{
		System.out.println("obteniendo factoria de socker del cliente---");
		SSLSocketFactory socketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		
		System.out.println("Creando el socket del cliente-...");
		SSLSocket socketCliente = (SSLSocket) socketFactory.createSocket(DESTINO, PUERTO);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
