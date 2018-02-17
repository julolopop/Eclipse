package com.pspro;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {

	static final int PUERTO = 8888;
	
	public static void main(String[] args) {

		System.setProperty("java.net.preferIPv4Stack" , "true");
		new Servidor();
	}
	
	public Servidor() {
	
		ServerSocket skServer;
		
		try {
			skServer = new ServerSocket(PUERTO);
			System.out.println("Servidor escuchando en :"+skServer.getLocalSocketAddress().toString());
			while (true){
				Socket skAtencion = skServer.accept();
				System.out.println("Se esta atendiendop al nuevo cliente ");
				new ServidorHilo(skAtencion).start();						
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	

}
