package com.pspro;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	static final int PUERTO = 5000;
	
	public static void main(String[] args) {
		/*
		 * -Djava.net.preferIPv4Stack=true //Argumento
		 * System.setProperty("java.net.preferIPv4Stack" , "true");*/

		System.setProperty("java.net.preferIPv4Stack" , "true");
		new Servidor();
		
	}
	
	public Servidor() {
	
		ServerSocket skServer;
		
		try {
			skServer = new ServerSocket(PUERTO);
			System.out.println("Servidor escuchando en :"+skServer.getLocalSocketAddress().toString());
			
			int ncCli =0;
			while (true){
				Socket skAtencion = skServer.accept();
				ncCli++;
				System.out.println("Se esta atendiendop al nuevo cliente :"+ncCli);
				
				//creamos un holo para atender al cliente y asi liberar al socket principal
				new ServidorHilo(skAtencion,ncCli).start();						
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	

}
